package examples;

public class ThreadBank{
    /*
	 *  withdraw 함수와 deposit 함수를  synchronized 키워드를 사용 하였다.
	 *  한 쓰레드가 withdraw 함수를 실행하는 동안 다른 쓰레드가 deposit 함수를 호출하거나
	 *  withdraw 함수를 호출할 수 없다.
	 */

    private int money = 0;

    ThreadBank(int money) {
        this.money = money;
    }

    synchronized void withdraw(int value) {

        try {
            // if 문을 사용하여 현재 money 가 0 인지 확인한다.
            while(money == 0)
                wait(); // money 가 0이면 Lock 을 릴리즈하고 대기 상태에 빠진다.

            money -= value;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Withdraw. money : " + money);

    }

    synchronized void deposit(int value) {
        money += value;

        // wait 을 호출하여 대기 상태에 빠져 있는 모든 쓰레드들을 깨운다.
        notifyAll();

        System.out.println("Deposit. money : " + money);
    }
}

class Producer implements Runnable {

    private ThreadBank mBalance;

    Producer(ThreadBank balance) {
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

class Consumer implements Runnable {

    private ThreadBank mBalance;

    public Consumer(ThreadBank balance) {
        mBalance = balance;
    }

    @Override
    public void run() {

        while(true) {
            // 무한 루프를 돌면서 10씩 인출한다.
            mBalance.withdraw(10);

        }
    }
}

class Main {

    public static void main(String[] args) {

        ThreadBank bank = new ThreadBank(0);

        Producer producer = new Producer(bank);
        Consumer consumer = new Consumer(bank);

        // Producer 쓰레드는 1개, Consumer 쓰레드는 10개를 만들어서 시작시킨다.
        new Thread(producer).start();

        for(int i=0;i<10;i++) {
            new Thread(consumer).start();
        }
    }
}
