package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); //오타 나면 다운로드됨..

        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if( session.isNew()){
            session.setAttribute("name","kim");
            System.out.println("session start");
        }else{
            System.out.println(session.getAttribute("name"));
            session.getId();
        }



        PrintWriter pw = response.getWriter();

        pw.print("<h1>Hello Servlet</h1>");
    }
}
