package jongko;

import com.mongodb.client.MongoDatabase;
import common.Database;
import common.JsonResponse;
import common.MongoAccessor;
import common.ResponseMessage;

public class JongkoService {
    private final MongoDatabase db = Database.jongko;
    private final MongoAccessor<User> userAccessor = new MongoAccessor<>(db.getCollection("user-data"), User.class);

    public String login(User data) throws InstantiationException, IllegalAccessException {
        User dbData = userAccessor.get(data.getEmail());
        JsonResponse response = new JsonResponse();
        if (dbData != null) {
            if (dbData.getPassword().equals(data.getPassword())) {
                response.setStatus(ResponseMessage.SUCCESS);
                response.setMessage(ResponseMessage.LOGIN_SUCCESS);
            }
            else {
                response.setStatus(ResponseMessage.FAILED);
                response.setMessage(ResponseMessage.WRONG_PASSWORD);
            }
        }
        else {
            response.setStatus(ResponseMessage.FAILED);
            response.setMessage(ResponseMessage.USER_NOT_FOUND);
        }
        return response.build();
    }

    public String signup(User data) {
        JsonResponse response = new JsonResponse();
        return response.build();
    }
}
