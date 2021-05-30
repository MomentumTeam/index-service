# search-service

when you change the proto file you need to inform drive team & run this command:

```
protoc -I proto/ proto/search/search.proto --go_out=plugins=grpc:./proto
```
