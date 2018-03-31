package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://localhost:8080/redirect
 */
@WebServlet(name = "RedirectServlet", urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // 오타 나면 안된다.....
        PrintWriter pw = response.getWriter();


        response.sendRedirect("/count1"); //http://localhost:8080/count1으로 리다이렉트하라.
    }


}
