require("dotenv").config();
const assert = require("assert");
const { MongoClient } = require("mongodb");
const amqp = require("amqplib");

// process.env.MONGO_HOST = "mongodb://168.63.40.248:27017";
// process.env.MONGO_DB = "barak";
// process.env.MONGO_COLLECTION = "files";
// process.env.MONGO_PAGE_SIZE = "10";
// process.env.RABBIT_HOST = "amqp://localhost";
// process.env.RABBIT_EXCHANGE = "indexService";
// process.env.RABBIT_KEY = "eventsKey";
// const from = new Date("2021-01-01T14:00:00");
// const to = new Date("2021-02-29T14:00:00");
// const field = "createdAt"; // createdAt or updatedAt

const client = new MongoClient(process.env.MONGO_HOST, { useUnifiedTopology: true });
const pageSize = parseInt(process.env.MONGO_PAGE_SIZE);
const args = process.argv.slice(2);
assert.strictEqual(args.length, 3);
const field = args[0]; // createdAt or updatedAt
const from = new Date(args[1]); // for example 2021-01-24T16:56:07.00
const to = new Date(args[2]);

console.log(`field = ${field}, from = ${from},  to = ${to}`);

const pushToRabbit = async (message) => {
  try {
    const connection = await amqp.connect(process.env.RABBIT_HOST);
    const channel = await connection.createChannel();
    await channel.publish(process.env.RABBIT_EXCHANGE, process.env.RABBIT_KEY, Buffer.from(JSON.stringify(message)));
  } catch (error) {
    throw error;
  }
};

(async () => {
  try {
    await client.connect();
    const database = client.db(process.env.MONGO_DB);
    const collection = database.collection(process.env.MONGO_COLLECTION);
    let query,
      messages,
      page = 0;

    query = {
      [field]: {
        $gte: from,
        $lte: to,
      },
    };

    while (true) {
      messages = await collection
        .find(query)
        .limit(pageSize)
        .skip(page * pageSize)
        .toArray();
      messages = messages.map((file) => {
        return {
          fileId: file["_id"].toString(),
          event: "CREATE",
        };
      });
      page++;
      if (!messages || messages.length == 0) {
        break;
      }
      for (let message of messages) {
        await pushToRabbit(message);
      }
      console.log(`Page = ${page}: FileIds = ${messages.map((message) => message.fileId)}`);
    }
    await client.close();
    console.log("finished!");
    process.exit();
  } catch (error) {
    console.log(error);
    await client.close();
  }
})();
