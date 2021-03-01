package com.example;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.tomcat.util.http.fileupload.IOUtils;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

public class httpServer {
    public static void main(String[] args) throws Exception{

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(80),0);
        httpServer.createContext("/",new TestHandler());
        httpServer.start();
    }

    static class TestHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                InputStream inputStream = exchange.getRequestBody();
                System.out.println(inputStream);
                byte[] bytes = new byte[0];
                bytes = new byte[inputStream.available()];
                inputStream.read(bytes);

//                String post = exchange.getRequestBody().toString();
                String post = new String(bytes);
                System.out.println(post);
                int b = formData2Dic(post);
                String s = Integer.toString(b);
                System.out.println(b);
                exchange.sendResponseHeaders(200,0);
                OutputStream os = exchange.getResponseBody();
                os.write(s.getBytes());
                System.out.println(b);
                os.close();
            }catch (Exception e){}
            }
    }

    private static int formData2Dic(String post){
        JSONObject jsonObject = JSONObject.parseObject(post);
        System.out.println(jsonObject);
        String s = jsonObject.getString("user_id");
        int id = Integer.parseInt(s);
        System.out.println(id);
        if (id % 10<6)return 1;
        else return 0;
    }
}
