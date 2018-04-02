package examples.spring.ch02.dice;

public class Test {
	public static void main(String[] args) {
		Dice dice = new Dice4();
		Player p = new Player(dice);
		p.play();
		System.out.println("세번 굴린 주사위의 합 : " + p.getTotalValue());
	}
}
