package common;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoAccessor {
    MongoCollection collection;

    public MongoAccessor(MongoCollection collection) {
        this.collection = collection;
    }

    public void insert(Object doc) {
        Gson gson = new Gson();
        String json = gson.toJson(doc);
        collection.insertOne(Document.parse(json));
    }

    public Object get(String id) {
        return null;
    }
}
