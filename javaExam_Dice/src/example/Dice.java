package example;

public class Dice {
    private int face;

    public Dice(){
        this.face = 6;
    }

    public Dice(int face){
        this.face = face;
    }

    public int randomValue(){
        return (int)(this.face * Math.random()) + 1;
    }
}
