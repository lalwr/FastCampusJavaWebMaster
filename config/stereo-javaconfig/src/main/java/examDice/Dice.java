package examDice;

public class Dice {
    private String name;
    private int face;


    public Dice(int face){
        System.out.println("Dice 생성자");
        this.face = face;
    }

    public int getNumber(){
        System.out.println("Dice.getNumber");
        return (int)(Math.random() * face) +1;
    }

}
