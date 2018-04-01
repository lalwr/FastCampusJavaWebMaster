package examples;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "BoardWriteServlet", urlPatterns = "/write")
public class BoardWriteServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        Date date = new Date();
        String regDate = new SimpleDateFormat("yyyy-MM-dd").format(date);

        BoardVO boardVO = new BoardVO();
        boardVO.setName(name);
        boardVO.setContent(content);
        boardVO.setRegDate(regDate);

        BoardService boardService = BoardService.getService();
        boardService.addBoard(boardVO);

        resp.sendRedirect("/list");
    }
}
