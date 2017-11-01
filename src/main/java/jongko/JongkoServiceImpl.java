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
                    return response.success(ResponseMessage.LOGIN_SUCCESS);
                } else {
                    return response.failed(ResponseMessage.WRONG_PASSWORD);
                }
            } else {
                return response.failed(ResponseMessage.USER_NOT_FOUND);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return response.error(ExceptionUtils.getStackTrace(e));
        } catch (InstantiationException e) {
            e.printStackTrace();
            return response.error(ExceptionUtils.getStackTrace(e));
        }
    }

    @Override
    public JsonResponse signup(User user) {
        JsonResponse response = new JsonResponse();
        return response.failed(ResponseMessage.UNDER_DEVELOPMENT);
    }

    @Override
    public JsonResponse get(User user) {
        JsonResponse response = new JsonResponse();
        return response.failed(ResponseMessage.UNDER_DEVELOPMENT);
    }
}
