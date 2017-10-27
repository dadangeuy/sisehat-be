package common;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Database {
    public static MongoClient client = new MongoClient("localhost", 27017);
    public static MongoDatabase jongko = client.getDatabase("sisehat-jongko");
}
