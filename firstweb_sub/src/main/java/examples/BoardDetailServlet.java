package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "BoardDetailServlet" , urlPatterns = "/detail")
public class BoardDetailServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("detail.jsp");

        ArrayList list = new ArrayList();
        for(Iterator itr = BoardService.getService().getBoard(); itr.hasNext(); ) { //리스트 담기
            list.add( itr.next() );
        }
        int no = Integer.parseInt(req.getParameter("no"));
        BoardVO boardVo = (BoardVO) list.get(no);
        req.setAttribute("name", boardVo.getName());
        req.setAttribute("content", boardVo.getContent());
        req.setAttribute("regDate", boardVo.getRegDate());

        requestDispatcher.forward(req, resp);

    }
}
