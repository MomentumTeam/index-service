package Models;

import com.github.javafaker.Faker;

public class Folder {

    private String name;
    private String id;

    public Folder(String name, String id){
        this.name = name;
        this.id = id;
    }

    public static Folder getRandom(){
        Faker faker = new Faker();
        String name = faker.color().name();
        String id = faker.idNumber().valid();
        return new Folder(name, id);
    }

    public static Folder getFolder(String id){
        String name = FileMetadata.getFileNameById(id);
        return new Folder(name, id);
    }
}
