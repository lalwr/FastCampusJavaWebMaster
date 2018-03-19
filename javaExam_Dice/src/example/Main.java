package example;

public class Main {

    public static void main(String[] args) throws Exception{
        Dice dice = new Dice();
        int total = 0;
        for(int i =0; i < 3; i++){
            total += dice.randomValue();
        }

        System.out.println(total);

    }
}
