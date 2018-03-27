package examples;

import java.io.*;

public class DefaultServlet extends Servlet{
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        try{

            String baseDir = "/tmp/wasroot";
            String fileName = request.getPath(); //
            if("/".equals(fileName)){
                fileName = "/index.html";
            }else if(fileName.endsWith(".png")){ //png 이미지일때
                fileName = request.getPath();
            }else{ //잘못된 경로 처리
                fileName = "/error.html";
            }

            fileName = baseDir + fileName;

            String contentType = "text/html; charset=UTF-8";
            if(fileName.endsWith(".png")){
                contentType =  "image/png";
            }


            File file = new File(fileName); // java.io.File
            long fileLength = file.length();



            PrintWriter pw = response.getOut();
            OutputStream out = response.getOutputStream();

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
            pw.flush(); // 헤더와 빈줄을 출력 char단위 출력

            // body부분을 출력. byte단위로 출력
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
            out.flush();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
