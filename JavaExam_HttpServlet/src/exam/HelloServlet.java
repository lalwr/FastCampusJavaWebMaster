package exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        //서블릿의 생명 주기중에 현재 서블릿이 초기화 작업을 시키기 위해서 오버라이딩해서 사용함.
        //딱 한번만. 실행된다. 전체 초기화 작업같은 일에 사용될 수 있다.
        System.out.println("init() 메소드 호출");

    }

    // 컨테이너가 생성한 Request와 Response 객체를 전달 받는다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // Response 객체의 PrintWriter를 사용해 브라우저에 HTML을 출력한다.
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h2>GET방식 요청</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    // 컨테이너가 생성한 Request와 Response 객체를 전달 받는다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // Response 객체의 PrintWriter를 사용해 브라우저에 HTML을 출력한다.
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h2>POST 방식 요청</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // Response 객체의 PrintWriter를 사용해 브라우저에 HTML을 출력한다.
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h2>service 메소드 요청</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    public void destroy(){

        System.out.println("destroy 호출");

    }
}
