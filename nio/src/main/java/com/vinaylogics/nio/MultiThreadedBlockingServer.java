package com.vinaylogics.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket  ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept(); // never null
            handle(s);
        }

    }

    private static void handle(Socket s){
        new Thread( () -> {
            System.out.println("Connected to :" + s);
            try (
                 InputStream in = s.getInputStream();
                 OutputStream out = s.getOutputStream()) {

                int data;
                while ((data = in.read()) != -1) {
                    out.write(transmogrify(data));
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } finally {
                System.out.println("Disconnected from : " + s);
            }
        }).start();
    }

    private static int transmogrify(int data) {
        return Character.isLetter(data) ? data^ ' ':data;
    }
}
