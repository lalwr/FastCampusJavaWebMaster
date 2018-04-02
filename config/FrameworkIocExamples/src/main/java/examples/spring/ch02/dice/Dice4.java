package examples.spring.ch02.dice;

public class Dice4 implements Dice {
	
	/* (non-Javadoc)
	 * @see ch02.dice.Dice#getDiceValue()
	 */
	public int getDiceValue() {
		int num = (int) (Math.random() * 4) + 1;
		System.out.println("1~4까지 발생한 수 : " + num);
		return num;
	}
}
