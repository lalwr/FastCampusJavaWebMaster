package examples;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args){
        WebApplicationServer was = new WebApplicationServer(8080);
        new Thread(was).start();
    }

}

