package examples;

import java.net.ServerSocket;

public class WASMain {
    public static void main(String[] args) {
        ServerSocket listener = null;
        try{
            listener = new ServerSocket(8080);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally { // finatlly부분에서 서버소켓을 close한다.
            try{
                listener.close();
            }catch (Exception e){};
        }
    }
}
