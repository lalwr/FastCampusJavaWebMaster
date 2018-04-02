package examples.spring.ch01.javabeans;

// 자바빈즈
public class UserBean {
	
	//멤버변수는 private로 선언
	private String name;
	private int age;
	private boolean male;
	
	// 기본생성자를 가지고 있어야 한다.
	public UserBean() {
	}
	
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}

	//setter, getter 메소드를 가지고 있어야 한다. - 프로퍼티 라고 한다.
	//setter 메소드 선언
	public void setName(String name) {
		this.name = name;
	}

	//getter 메소드 선언
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}
