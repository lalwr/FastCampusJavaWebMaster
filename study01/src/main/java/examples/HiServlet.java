package examples;

import java.io.OutputStream;
import java.io.PrintWriter;

public class HiServlet extends Servlet{
    public HiServlet(){
        System.out.println("HiServlet");
    }

    @Override
    public void init() {
        System.out.println("HiServlet init");
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        PrintWriter pw = response.getOut();
        OutputStream out = response.getOutputStream();

        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html");
        pw.println();

        pw.println("<h1>hi servlet</h1>");
        pw.flush();

    }
}
