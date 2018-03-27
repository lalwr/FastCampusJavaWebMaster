public class Producer implements Runnable {

    private Balance mBalance;

    Producer(Balance balance) {
        mBalance = balance;
    }

    @Override
    public void run() {

        // 100번 루프를 돌면서 100씩 저금한다.
        for(int i=0; i<100; i++) {
            mBalance.deposit(100);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}