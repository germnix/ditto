//package com.ditto;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestUtils {
//    public static final Map<String, RequestResponse> RESPONSES_FOR_GET = new HashMap<>();
//    static {
//        RESPONSES_FOR_GET.put("/service/user/123?param=value", new RequestResponse("GET /service/user/123?param=value HTTP/1.1\r\n" +
//                "connection: Keep-Alive\r\n" +
//                "host: localhost:8080\r\n" +
//                "authorization: BEARER nYnQbp7iI5hmNZxd6-q4mg\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "HTTP/1.1 200 OK\r\n" +
//                "Date: Sun, 25 Sep 2016 16:30:44 GMT\r\n" +
//                "Content-Length: 576\r\n" +
//                "Expires: Sun, 25 Sep 2016 16:59:49 GMT\r\n" +
//                "Content-Type: application/json;charset=UTF-8\r\n" +
//                "Server: Apache-Coyote/1.1\r\n" +
//                "\r\n" +
//                "{\"name\":\"Sam\"}\r\n"));
//    }
//
//    public static final Map<String, RequestResponse> RESPONSES_FOR_POST = new HashMap<>();
//    static {
//        RESPONSES_FOR_POST.put("/service/user", new RequestResponse("POST /service/user HTTP/1.1\r\n" +
//                "connection: Keep-Alive\r\n" +
//                "host: localhost:9080\r\n" +
//                "authorization: BEARER nYnQbp7iI5hmNZxd6-q4mg\r\n" +
//                "\r\n" +
//                "{\"operation\":\"GET\"}\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "HTTP/1.1 500 Internal Server Error\r\n" +
//                "Date: Sun, 25 Sep 2016 16:30:55 GMT\r\n" +
//                "Content-Length: 1292\r\n" +
//                "Expires: Sun, 25 Sep 2016 16:59:57 GMT\r\n" +
//                "Content-Type: application/json;charset=UTF-8\r\n" +
//                "Server: Apache-Coyote/1.1\r\n"));
//    }
//
//    public static final Map<String, RequestResponse> RESPONSES_FOR_HEAD = new HashMap<>();
//    static {
//        RESPONSES_FOR_HEAD.put("/otherservice/orders/456", new RequestResponse("HEAD /otherservice/orders/456 HTTP/1.1\r\n" +
//                "connection: Keep-Alive\r\n" +
//                "host: localhost:9080\r\n" +
//                "authorization: BEARER nYnQbp7iI5hmNZxd6-q4mg\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "HTTP/1.1 200 OK\r\n" +
//                "Date: Sun, 25 Sep 2016 16:30:44 GMT\r\n" +
//                "Content-Length: 456\r\n" +
//                "Expires: Sun, 25 Sep 2016 17:00:23 GMT\r\n" +
//                "Content-Type: application/json;charset=UTF-8\r\n" +
//                "Server: Apache-Coyote/1.1\r\n"));
//    }
//
//    public static final Map<String, RequestResponse> RESPONSES_FOR_PUT = new HashMap<>();
//    static {
//        RESPONSES_FOR_PUT.put("/service/user", new RequestResponse("PUT /service/user HTTP/1.1\r\n" +
//                "connection: Keep-Alive\r\n" +
//                "host: localhost:9080\r\n" +
//                "authorization: BEARER nYnQbp7iI5hmNZxd6-q4mg\r\n" +
//                "\r\n" +
//                "{\"operation\":\"GET\"}\r\n" +
//                "\r\n" +
//                "HTTP/1.1 200 OK\r\n" +
//                "Date: Sun, 25 Sep 2016 16:30:44 GMT\r\n" +
//                "Content-Length: 456\r\n" +
//                "Expires: Sun, 25 Sep 2016 17:00:23 GMT\r\n" +
//                "Content-Type: application/json;charset=UTF-8\r\n" +
//                "Server: Apache-Coyote/1.1\r\n"));
//    }
//
//    public static final Map<String, RequestResponse> RESPONSES_FOR_DELETE = new HashMap<>();
//    static {
//        RESPONSES_FOR_DELETE.put("/service/user", new RequestResponse("DELETE /service/user HTTP/1.1\r\n" +
//                "connection: Keep-Alive\r\n" +
//                "host: localhost:9080\r\n" +
//                "authorization: BEARER nYnQbp7iI5hmNZxd6-q4mg\r\n" +
//                "\r\n" +
//                "\r\n" +
//                "HTTP/1.1 404 Not Found\r\n" +
//                "Date: Sun, 25 Sep 2016 16:30:44 GMT\r\n" +
//                "Content-Length: 456\r\n" +
//                "Expires: Sun, 25 Sep 2016 17:00:23 GMT\r\n" +
//                "Content-Type: application/json;charset=UTF-8\r\n" +
//                "Server: Apache-Coyote/1.1\r\n"));
//    }
//}
