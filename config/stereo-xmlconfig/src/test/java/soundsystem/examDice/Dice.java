package soundsystem.examDice;

public class Dice {
    int face;

    public Dice(int face){
        System.out.println("Dice()");
        this.face = face;
    }

    public int getNumber(){
        return (int) ((Math.random() * face) +1);
    }
}
