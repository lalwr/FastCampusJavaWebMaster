package examples;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args){
        WebApplicationServer was = new WebApplicationServer(8080);
        new Thread(was).start();

        WasShutdownHook wasShutdownHook = new WasShutdownHook(was);
        //jvm 종료될 때 실행항 Thread을 등록한다.
        Runtime.getRuntime().addShutdownHook(wasShutdownHook);
    }

}

// jvm shutdown hook