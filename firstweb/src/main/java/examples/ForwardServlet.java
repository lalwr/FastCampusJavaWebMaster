package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://localhost:8080/forward
 */
@WebServlet(name = "ForwardServlet", urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // 오타 나면 안된다.....
        PrintWriter pw = response.getWriter();

        // index.jsp 로 포워딩한다.
        // 포워딩할때는 path가 반드시 / 로 시작한다.
        // 포워딩 대상에 값을 전달하려면 request가 가지고 있는 setAttribute메소드를 이용하면 된다.
        RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.jsp");
        request.setAttribute("name", "urstory"); // jsp에 ${name} 으로 출력이 가능하다. EL문
        request.setAttribute("myNumber", 100); //jsp에서 500보더 작으면 "ture", 500보다 크면 "false"를 출력하시오.
        requestDispatcher.forward(request,response);

    }


}
/*
http://localhost:8080/forward  --------> forward 서블릿
                                                --------------> index.jsp
                       <---------------------------------------
*/