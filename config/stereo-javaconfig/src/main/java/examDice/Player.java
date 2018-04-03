package examDice;

public class Player {
    private String name;
    private Dice dice;

    public Player(){
        System.out.println("Player()");
    }
    public void setDice(Dice dice) {
        System.out.println("Player.setDice");
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Player.setName");
        this.name = name;
    }

    public void play(){
        System.out.println(name + "은 주사위를 던져 " + dice.getNumber() + " 나왔습니다.");
    }
}
