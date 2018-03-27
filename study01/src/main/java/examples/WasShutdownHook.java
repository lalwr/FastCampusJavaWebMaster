package examples;

public class WasShutdownHook extends Thread{
    private WebApplicationServer webApplicationServer;

    public WasShutdownHook(WebApplicationServer server){
        this.webApplicationServer = server;
    }

    public void run(){
        System.out.println("프로그램이 진짜 종료됨!!");
    }
}
