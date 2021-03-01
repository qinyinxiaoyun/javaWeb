package com.example;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        System.out.println("Server start" + new Date() + "\n");
        try {
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new Handler(socket)).start();
            }

        }catch (Exception e){
            e.printStackTrace();
            serverSocket.close();
        }
    }
}

class Handler implements Runnable{
    public static int BUFFERSIZE = 2048;
    public Socket socket;
    public Handler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            byte[] buffer = new byte[BUFFERSIZE];
            int len = in.read(buffer);
            String s = new String(buffer,0,len);
            System.out.println(s);

            String a = "return value";
            out.write(a.getBytes(StandardCharsets.UTF_8));
            socket.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
