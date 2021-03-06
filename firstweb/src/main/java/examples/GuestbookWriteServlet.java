package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "GuestbookWriteServlet", urlPatterns = "/write")
public class GuestbookWriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String content = req.getParameter("content");
        Date regDate = new Date();

        GuestBook guestBook = new GuestBook();
        guestBook.setName(name);
        guestBook.setContent(content);
        guestBook.setRegdate(regDate);

        GuestbookService guestbookService = GuestbookService.getService();
        guestbookService.addGuestBook(guestBook);

        resp.sendRedirect("/list");

    }
}
