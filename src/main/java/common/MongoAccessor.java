package common;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.lang.reflect.Type;

public class MongoAccessor<T> {
    private MongoCollection collection;
    private Type type;

    public MongoAccessor(MongoCollection collection, Type type) {
        this.collection = collection;
        this.type = type;
    }

    public void insert(T item) {
        Gson gson = new Gson();
        String json = gson.toJson(item);
        collection.insertOne(Document.parse(json));
    }

    public T get(String key) throws IllegalAccessException, InstantiationException {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", key);

        Object docs = collection.find(query).first();
        if(docs == null) return null;
        Gson gson = new Gson();
        String json = gson.toJson(docs);
        return gson.fromJson(json, type);
    }
}
