package examples;


public class ThreadExam04 {
    public static void main(String[] args) {
        Exam exam = new Exam();
        MyThread04 t1 = new MyThread04(exam, 1);
        MyThread04 t2 = new MyThread04(exam, 2);
        MyThread04 t3 = new MyThread04(exam, 3);

        t1.start();
        t2.start();
        t3.start();
    }


}

class Exam{

    public void a() {
        for(int i=0; i<10; i++){
            System.out.print("a");
            try{ // 0<= x < 1000
                Thread.sleep((int) (Math.random() * 1000));
            }catch (Exception ex){

            }
        }
    }

    public synchronized void b() {
        for(int i=0; i<10; i++){
            System.out.print("b");
            try{ // 0<= x < 1000
                Thread.sleep((int) (Math.random() * 1000));
            }catch (Exception ex){

            }
        }
    }

    public synchronized void c() {
        for(int i=0; i<10; i++){
            System.out.print("c");
            try{ // 0<= x < 1000
                Thread.sleep((int) (Math.random() * 1000));
            }catch (Exception ex){

            }
        }
    }
}

class MyThread04 extends Thread{
    private Exam exam;
    private int num;
    public MyThread04(Exam exam, int num){
        this.exam = exam;
        this.num = num;
    }

    @Override
    public void run(){
        if(num == 1){
            exam.a();
        }else if(num == 2){
            exam.b();
        }else if(num == 3){
            exam.c();
        }

    }


}
