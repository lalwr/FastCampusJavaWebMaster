package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://localhost:8080/count1
 */
@WebServlet(name = "CookieCounter", urlPatterns = "/count1")
public class CookieCounter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // 오타 나면 안된다.....
        PrintWriter pw = response.getWriter();

        int count = 1;
        Cookie c = CookieUtil.getCookie(request,"count");
        if(c == null){
            c = new Cookie("count", "1");
            c.setPath("/");
            response.addCookie(c);
        }else{
            String str = c.getValue();
            try{
                int num = Integer.parseInt(str);
                count = num + 1;
                c = new Cookie("count", count +"");
                c.setPath("/");
                response.addCookie(c);
            }catch(Exception ex){
                c = new Cookie("count", "1");
                c.setPath("/");
                response.addCookie(c);
            }
        }

        // 1. 처음 실행하면 쿠키의 이름이 count인 것을 찾는다.
        // 2. 쿠키 이름이 count인 것을 찾았다면, 해당 값에 +1을 한 후 그 결과를 출력
        // 3. count쿠키를 1증가한 값으로 다시 브라우저에게 전송한다.
        // 4. 쿠키 이름이 count인 것이 없다면 1을 출력
        // 5. count쿠키의 value를 1로 하여 브라우저에게 전송한다.
        //  Cookie cookie = new Cookie("count", "1");
        //  cookie.setPath("/");

        pw.println("<h1>" + count + "</h1>");
    }


}
