package examples;

public class ThreadExam02 {
    public static void main(String[] args) {
        /*
            2) Thread(Runnable) 생성자에 Runnale인터페이스를 구현하고 있는 인스턴스를 파라미터로 전달한다.
        */
        Thread t1 = new Thread(new MyThread02("*"));
        Thread t2 = new Thread(new MyThread02("-"));
        Thread t3 = new Thread(new MyThread02("|"));
        t1.start();
        t2.start();
        t3.start();
        System.out.println("end!!");
    }
}

/*
Thread를 만드는 방법.
1) Runnable 인터페이스를 구현한다.
2) run() 메소드를 구현한다.
   run() 메소드안에 동시에 수행하고 싶은 작업(코드)를 작성한다.
3) Thread의 실행은 Thread인스턴스를 생성 후 start()메소드를 사용한다.
*/
class MyThread02 implements Runnable {
    private String name;
    public MyThread02(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=0; i<=10; i++){
            System.out.print(name);
            try{ // 0<= x < 1000
                Thread.sleep((int) (Math.random() * 1000));
            }catch (Exception ex){

            }
        }
    }
}
