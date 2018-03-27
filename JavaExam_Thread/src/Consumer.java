public class Consumer implements Runnable {

    private Balance mBalance;

    public Consumer(Balance balance) {
        mBalance = balance;
    }

    @Override
    public void run() {

        while(true) {
            // 무한 루프를 돌면서 100씩 인출한다.
            mBalance.withdraw(100);

        }
    }
}