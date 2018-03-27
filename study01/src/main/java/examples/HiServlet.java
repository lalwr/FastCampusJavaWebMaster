package examples;

public class HiServlet extends Servlet{
    public HiServlet(){
        System.out.println("HiServlet");
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {

    }

    @Override
    public void init() {
        System.out.println("HiServlet init");
    }
}
