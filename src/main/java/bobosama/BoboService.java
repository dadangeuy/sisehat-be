package bobosama;

import com.mongodb.client.MongoDatabase;
import common.Database;
import common.JsonResponse;
import common.MongoAccessor;
import jongko.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class BoboService {

    private final MongoDatabase db = Database.jongko;
    private final MongoAccessor<Request> requestAccessor = new MongoAccessor<>(db.getCollection("request"), Request.class);
    private final MongoAccessor<Request> viewAccessor = new MongoAccessor<>(db.getCollection("request"), Request.class);
    public String request(Request data){
        requestAccessor.insert(data);
        JsonResponse response = new JsonResponse();
        return response.build();
    }
    public List<Document> view(){
        List<Document> viewDB  = viewAccessor.getall();
        JsonResponse response = new JsonResponse();
        response.setData(viewDB);
        return response.build();
    }
}
