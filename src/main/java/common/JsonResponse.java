package common;

import com.google.gson.Gson;

import java.util.List;

public class JsonResponse {
    private String status;
    private String message;
    private List data;

    public JsonResponse success(String message) {
        status = "SUCCESS";
        this.message = message;
        return this;
    }

    public JsonResponse failed(String message) {
        status = "FAILED";
        this.message = message;
        return this;
    }

    public JsonResponse error(String message) {
        status = "ERROR";
        this.message = message;
        return this;
    }

    public JsonResponse data(List data) {
        this.data = data;
        return this;
    }

    public String build() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
