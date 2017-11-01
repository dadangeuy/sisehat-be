package jongko;

import common.JsonResponse;

public interface JongkoService {
    public JsonResponse login(User user);
    public JsonResponse signup(User user);
    public JsonResponse get(User user);
}
