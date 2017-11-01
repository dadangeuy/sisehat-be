package bobo;

import com.mongodb.client.MongoDatabase;
import common.Database;
import common.JsonResponse;
import common.MongoAccessor;

public class BoboServiceImpl implements BoboService{

    private final MongoDatabase db = Database.jongko;
    private final MongoAccessor<RequestDoctor> requestAccessor = new MongoAccessor<>(db.getCollection("request"), RequestDoctor.class);
    private final MongoAccessor<RequestDoctor> viewAccessor = new MongoAccessor<>(db.getCollection("request"), RequestDoctor.class);

    @Override
    public JsonResponse request(RequestDoctor data){
        requestAccessor.insert(data);
        JsonResponse response = new JsonResponse();
        return response;
    }
}
