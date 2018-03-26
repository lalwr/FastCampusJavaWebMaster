package examples;

public class ThreadExam01 {
    public static void main(String[] args) {
        MyThread01 t1 = new MyThread01("*");
        MyThread01 t2 = new MyThread01("-");
        MyThread01 t3 = new MyThread01("|");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("end!!");

    }
}
/*
Thread를 만드는 방법.
1) Thread를 상속받는다.
2) run() 메소드를 오버라이딩 한다.
   run() 메소드안에 동시에 수행하고 싶은 작업(코드)를 작성한다.
3) Thread의 실행은 Thread인스턴스를 생성 후 start()메소드를 사용한다.
*/
class MyThread01 extends Thread{
    private String name;
    public MyThread01(String name){
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
