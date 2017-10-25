package jongko;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Login {
    private final MongoCollection collection;

    public Login(MongoDatabase db) {
        collection = db.getCollection("user");
    }


}
