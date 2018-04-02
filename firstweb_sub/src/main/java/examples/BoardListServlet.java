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
import java.util.List;

@WebServlet(name = "/BoardListServlet", urlPatterns = "/list")
public class BoardListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/list.jsp");

        BoardService service = BoardService.getService();

        int pageSize = service.list.size();

        BoardPagingInfo pagingInfo = new BoardPagingInfo();
        if(req.getParameter("page") != null){
            pagingInfo.setPage(Integer.parseInt(req.getParameter("page")));
        }else{
            pagingInfo.setPage(1);
        }

        pagingInfo.setTotCount(pageSize);
        req.setAttribute("pagingInfo", pagingInfo);
        ArrayList list = new ArrayList();
        for( Iterator itr = service.getBoard(); itr.hasNext(); ) { //리스트 담기
            list.add( itr.next() );
        }
        int startPage = pagingInfo.getPageVal(); //시작페이지
        int endPage = startPage + pagingInfo.getPageSize();
        if( pageSize < endPage ){
            endPage = pageSize;
        }
        List resultList = list.subList(startPage, endPage); //startPage 이상 endPage 미만

        req.setAttribute("iter", resultList);
        req.setAttribute("startPage", startPage);

        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destory가 호출합니다.");
        BoardService service = BoardService.getService();
        service.save();
    }
}
