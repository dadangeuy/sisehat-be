package jongko;

import com.mongodb.client.MongoDatabase;
import common.Database;
import common.JsonResponse;
import common.MongoAccessor;
import common.ResponseMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class JongkoServiceImpl implements JongkoService {
    private final MongoDatabase db = Database.jongko;
    private final MongoAccessor<User> userAccessor = new MongoAccessor<>(db.getCollection("user-data"), User.class);

    @Override
    public JsonResponse login(User user) {
        JsonResponse response = new JsonResponse();
        try {
            User data = userAccessor.get(user.getEmail());

            if (data != null) {
                if (data.getPassword().equals(user.getPassword())) {
                    response.setStatus(ResponseMessage.SUCCESS);
                    response.setMessage(ResponseMessage.LOGIN_SUCCESS);
                } else {
                    response.setStatus(ResponseMessage.FAILED);
                    response.setMessage(ResponseMessage.WRONG_PASSWORD);
                }
            } else {
                response.setStatus(ResponseMessage.FAILED);
                response.setMessage(ResponseMessage.USER_NOT_FOUND);
            }
        } catch (IllegalAccessException e) {
            response.setStatus(ResponseMessage.ERROR);
            response.setMessage(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        } catch (InstantiationException e) {
            response.setStatus(ResponseMessage.ERROR);
            response.setMessage(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public JsonResponse signup(User user) {
        JsonResponse response = new JsonResponse();
        response.setStatus(ResponseMessage.FAILED);
        response.setMessage(ResponseMessage.UNDER_DEVELOPMENT);
        return response;
    }

    @Override
    public JsonResponse get(User user) {
        JsonResponse response = new JsonResponse();
        response.setStatus(ResponseMessage.FAILED);
        response.setMessage(ResponseMessage.UNDER_DEVELOPMENT);
        return response;
    }
}
