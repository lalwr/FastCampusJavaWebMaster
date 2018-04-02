package examples.spring.ch02.dice;

public class Player {

	Dice dice;
	int totalValue = 0;
	
	public Player(Dice dice) {
		this.dice = dice;
	}

	public void play() {
		for (int i = 0; i < 3; i++) {
			totalValue += dice.getDiceValue();
		}
	}
	
	public int getTotalValue() {
		return totalValue;
	}

}
