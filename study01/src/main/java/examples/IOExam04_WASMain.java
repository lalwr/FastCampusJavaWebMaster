package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IOExam04_WASMain {
    public static void main(String[] args) throws Exception{
        ServerSocket listener = null;
        try{
            listener = new ServerSocket(8090);
            System.out.println("client를 기다립니다.");

            Socket client = listener.accept(); // 블러킹 메소드.
            System.out.println(client);

            InputStream in = client.getInputStream(); //클라이언트에게서 받은 데이터를 처리를 위한 작업
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String fileName = br.readLine();
            System.out.println("fileName : " + fileName);
             PrintWriter pw = new PrintWriter(new FileOutputStream(new File(fileName)));

            String line  = null;
            while ((line = br.readLine()) != null){
                if("quit".equals(line)){
                    break;
                }
                pw.println(line);
            }
            pw.close();
            in.close();
            client.close(); // 클라이언트와 접속이 close된다.

        }catch(Exception ex){
            ex.printStackTrace();
        }finally { // finally부분에서 서버소켓을 close한다.
            try {
                listener.close();
            }catch(Exception e){}
        }
    }

}
