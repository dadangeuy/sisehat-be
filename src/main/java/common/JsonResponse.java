package common;

import com.google.gson.Gson;

import java.util.List;

public class JsonResponse {
    private String status;
    private String message;
    private List data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String build() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
