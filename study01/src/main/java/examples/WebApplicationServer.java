package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebApplicationServer implements Runnable{
    private int port;
    private DefaultServlet defaultServlet;

    public WebApplicationServer(int port) {
        this.port = port;
        defaultServlet = new DefaultServlet();
    }

    public void destory(){
        defaultServlet.destory();
    }

    public void run(){
        ServerSocket listener = null;
        try{
            listener = new ServerSocket(port);
            System.out.println("client를 기다립니다.");
            while(true) {
                Socket client = listener.accept(); // 블러킹 메소드.

//            System.out.println("접속한 client : " + client.toString());

                new Thread(() -> {
                    try {
                        handleSocket(client);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }).start();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally { // finally부분에서 서버소켓을 close한다.
            try {
                listener.close();
            }catch(Exception e){}
        }
    } // run


    private void handleSocket(Socket client) throws IOException {
        OutputStream out = client.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        HttpResponse response = new HttpResponse();
        response.setOut(pw);
        response.setOutputStream(out);

        InputStream in = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        HttpRequest request = new HttpRequest();
        line = br.readLine();
        String[] firstLineArgs = line.split(" ");
        request.setMethod(firstLineArgs[0]);
        request.setPath(firstLineArgs[1]);

        while((line = br.readLine()) != null){
            if("".equals(line)){ // 헤더를 읽고 빈줄을 만나면
                break;
            }
            String[] headerArray = line.split(" ");
            if(headerArray[0].startsWith("Host:")){
                request.setHost(headerArray[1].trim());
            }else if(headerArray[0].startsWith("Content-Length:")){
                int length = Integer.parseInt(headerArray[1].trim());
                request.setContentLength(length);
            }else if(headerArray[0].startsWith("User-Agent:")){
                request.setUserAgent(line.substring(12));
            }else if(headerArray[0].startsWith("Content-Type")){
                request.setContentType(headerArray[1].trim());
            }
        }
        System.out.println(request);


        defaultServlet.service(request, response);

        out.close();
        in.close();
        client.close(); // 클라이언트와 접속이 close된다.
    }
}
