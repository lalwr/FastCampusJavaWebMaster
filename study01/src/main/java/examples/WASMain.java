package examples;

import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args) {
        ServerSocket listener = null; //특정 포켓에서 기다리고 있는 서버
        try{
            listener = new ServerSocket(8080);
            System.out.println("cliend를 기다립니다.");
            Socket client = listener.accept(); // 블러킹 메소드.
            System.out.println("접속한 cliend : " + client.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally { // finatlly부분에서 서버소켓을 close한다.
            try{
                listener.close();
            }catch (Exception e){};
        }
    }
}
