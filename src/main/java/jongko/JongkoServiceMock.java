package jongko;

import common.JsonResponse;
import common.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

public class JongkoServiceMock implements JongkoService {
    @Override
    public JsonResponse login(User user) {
        JsonResponse response = new JsonResponse();
        return response.success(ResponseMessage.LOGIN_SUCCESS);
    }

    @Override
    public JsonResponse signup(User user) {
        JsonResponse response = new JsonResponse();
        return response.success(ResponseMessage.SIGNUP_SUCCESS);
    }

    @Override
    public JsonResponse get(User user) {
        JsonResponse response = new JsonResponse();

        User fake = new User();
        fake.setEmail("dinamariana@gmail.com");
        fake.setBirthdate(System.currentTimeMillis());
        fake.setGender("L");
        fake.setName("Dina Mariana");
        fake.setPhone("087771234532");

        List<User> result = new ArrayList<>();
        result.add(fake);
        return response
                .success(ResponseMessage.USER_FOUND)
                .data(result);
    }
}
