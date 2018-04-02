package soundsystem.examDice;

public class Player {
    private String name;
    private Dice dice;

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println(name + "은 주사위를 던져 " + dice.getNumber() + " 나왔습니다.");
    }
}
