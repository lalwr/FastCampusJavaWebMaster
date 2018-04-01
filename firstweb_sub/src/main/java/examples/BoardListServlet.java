package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "/BoardListServlet", urlPatterns = "/list")
public class BoardListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/list.jsp");
        BoardService service = BoardService.getService();
        Iterator<BoardVO> iter = service.getBoard();
        req.setAttribute("iter", iter);

        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destory가 호출합니다.");
        BoardService service = BoardService.getService();
        service.save();
    }
}
