package examples;

// was가 종료될때 실행되는 Thread
public class WasShutdownHook extends Thread{
    private WebApplicationServer webApplicationServer;

    public WasShutdownHook(WebApplicationServer server){
        this.webApplicationServer = server;
    }

    public void run(){
        webApplicationServer.destory();
        System.out.println("프로그램이 진짜 종료됨!!");
    }
}
