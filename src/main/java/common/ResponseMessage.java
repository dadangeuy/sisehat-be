package common;

public class ResponseMessage {
    // status
    public static String SUCCESS = "SUCCESS";
    public static String FAILED = "FAILED";
    public static String ERROR = "ERROR";

    // message
    public static String USER_NOT_FOUND = "user is not registered yet.";
    public static String USER_FOUND = "user is already registered.";
    public static String WRONG_PASSWORD = "wrong password.";
    public static String LOGIN_SUCCESS = "login success, user may login now.";
    public static String SIGNUP_SUCCESS = "signup success, user can login now.";
    public static String UNDER_DEVELOPMENT = "feature still under development.";
}
