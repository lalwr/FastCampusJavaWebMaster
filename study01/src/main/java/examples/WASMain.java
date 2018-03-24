package examples;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args){
        ServerSocket listener = null;
        try{
            listener = new ServerSocket(8080);
            System.out.println("client를 기다립니다.");
            while(true) {
                Socket client = listener.accept(); // 블러킹 메소드.
                System.out.println(client);
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
    }

    private static void handleSocket(Socket client) throws IOException {
        OutputStream out = client.getOutputStream(); //클라이언트에게 데이터를 보내기 위한 작업
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        InputStream in = client.getInputStream(); //클라이언트에게서 받은 데이터를 처리를 위한 작업
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
            }else if(headerArray[0].startsWith("Content-Type:")){
                request.setContentType(headerArray[1].trim());
            }
        }
        System.out.println(request);

        String baseDir = "/tmp/wasroot";
        String fileName = request.getPath();

        if("/".equals(fileName)){
            fileName = "/index.html";
        }else if(fileName.endsWith(".png")){
            fileName = request.getPath();
        }else{
            fileName = "/error.html";
        }
        fileName = baseDir + fileName;

        String contentType = "text/html; charset=UTF-8";
        if(fileName.endsWith(".png")){
            contentType =  "image/png";
        }

        File file = new File(fileName); // java.io.File
        long fileLength = file.length();

        if(file.isFile()){
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: " + contentType);
            pw.println("Content-Length: " + fileLength);
            pw.println();
        }else{
            pw.println("HTTP/1.1 404 OK");
            pw.println("Content-Type: " + contentType);
            pw.println("Content-Length: " + fileLength);
            pw.println();
        }

        pw.flush(); // 헤더와 빈줄을 char형식으로 출력

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int readCount = 0;
        while((readCount = fis.read(buffer)) != -1){
            out.write(buffer,0,readCount);
        }
        out.flush();


        out.close();
        in.close();
        client.close(); // 클라이언트와 접속이 close된다.
    }
}

// mini was 만들기
// 브라우저로 접속시 브라우저가 보내주는 정보를 출력하면??

//GET /hello/world HTTP/1.1
//Host: localhost:8080
//Connection: keep-alive
//Cache-Control: max-age=0
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

//POST / HTTP/1.1
//Host: localhost:8080
//Connection: keep-alive
//Content-Length: 11
//Origin: chrome-extension://aejoelaoggembcahagimdiliamlcdmfm
//User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36
//Content-Type: text/plain
//Accept: */*

// 구글 웹스토어 접속후 Restlet 검색하여
// Restlet Client - REST API Testing 설치 (postman과 비슷한 프로그램)