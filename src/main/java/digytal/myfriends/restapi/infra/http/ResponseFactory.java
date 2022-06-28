package digytal.myfriends.restapi.infra.http;

import java.io.Serializable;

public class ResponseFactory {
    public static Response error() {
        return error("Error","Contacte o Suporte Técnico");
    }
    public static Response error(String message,String suggestion) {
        return error(500,message,suggestion);
    }
    public static Response error(Serializable code, String message, String suggestion) {
        return response(false,code, message, null,suggestion);
    }
    public static Response ok() {
        return ok(null);
    }
    public static Response ok(Object body) {
        return response(true,200, "Success", body,"");
    }
    protected static Response response(boolean success, Serializable code, String message, Object body, String suggestion) {
        Response response = new Response();
        response.code =code;
        response.message =message;
        response.body =body;
        response.success = success;
        response.suggestion = suggestion;
        return response;
    }
}
