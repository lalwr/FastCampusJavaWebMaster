public class Main {
    public static void main(String[] args) {

        Balance balance = new Balance(0);

        Producer producer = new Producer(balance);
        Consumer consumer = new Consumer(balance);

        // Producer 쓰레드는 1개, Consumer 쓰레드는 10개를 만들어서 시작시킨다.
        new Thread(producer).start();

        for(int i=0;i<10;i++) {
            new Thread(consumer).start();
        }
    }
}
