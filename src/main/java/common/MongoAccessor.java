package common;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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

    public Object get(String key, Class classname) throws IllegalAccessException, InstantiationException {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", key);

        Object docs = collection.find(query).first();
        Gson gson = new Gson();
        String json = gson.toJson(docs);
        Object result = classname.newInstance();
        result = gson.fromJson(json, classname);
        return result;
    }
}
