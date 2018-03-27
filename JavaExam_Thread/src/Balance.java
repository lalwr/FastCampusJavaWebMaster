public class Balance {

    /*
     *  mBalance 는 Shared Resouce 이므로  mBalance 를 수정하는
     *  withdraw 함수와 deposit 함수를  synchronized 키워드로  지정하였다.
     *  즉 withdraw 함수와 deposit 함수는 각각 atomic 하게 실행되며,
     *  한 쓰레드가 withdraw 함수를 실행하는 동안 다른 쓰레드가 deposit 함수를 호출하거나
     *  withdraw 함수를 호출할 수 없다.
     */

    private int mBalance = 0;

    Balance(int balance) {
        mBalance = balance;
    }

    synchronized void withdraw(int value) {

        try {
            // if 문을 사용하여 현재 mBalance 가 0 인지 확인한다.
            if(mBalance == 0)
                wait(); // mBalance 가 0이면 Lock 을 릴리즈하고 대기 상태에 빠진다.

            mBalance -= value;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Withdraw. Current Balance : " + mBalance);

    }

    synchronized void deposit(int value) {
        mBalance += value;

        // wait 을 호출하여 대기 상태에 빠져 있는 모든 쓰레드들을 깨운다.
        notifyAll();

        System.out.println("Deposit. Current Balance : " + mBalance);
    }
}