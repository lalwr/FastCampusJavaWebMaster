package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://localhost:8080/count2
 */
@WebServlet(name = "SessionCounter", urlPatterns = "/count2")
public class SessionCounter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // 오타 나면 안된다.....
        PrintWriter pw = response.getWriter();
        int count = 1;

        HttpSession session = request.getSession();
        Integer intObj = (Integer)session.getAttribute("count");
        if(intObj == null){
            session.setAttribute("count", 1); // "count", new Integer(1)
        }else{
            count = intObj.intValue() + 1;
            session.setAttribute("count", count);
        }

        pw.println("<h1>" + count + "</h1>");
    }


}
