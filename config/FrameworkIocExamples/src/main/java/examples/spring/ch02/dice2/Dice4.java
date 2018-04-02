package examples.spring.ch02.dice2;

public class Dice4 implements Dice {
	
	public Dice4() {
		System.out.println("Dice4 생성 완료.");
	}

	/* (non-Javadoc)
	 * @see ch02.dice.Dice#getDiceValue()
	 */
	public int getDiceValue() {
		int num = (int) (Math.random() * 4) + 1;
		System.out.println("1~4까지 발생한 수 : " + num);
		return num;
	}
}
