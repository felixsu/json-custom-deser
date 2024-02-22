package personal.felix.custom_deser.client;

public class BaseClient {

  public Response doGet(String url, Request request) {
    System.out.println("get method");
    return new Response();
  }

  public Response doPut(String url, Request request) {
    System.out.println("put method");
    return new Response();
  }

  public Response doPost(String url, Request request) {
    System.out.println("post method");
    return new Response();
  }

  public static class Request {

  }

  public static class Response {

  }

}
