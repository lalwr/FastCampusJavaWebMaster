package chap02;

// ��Ŭ����
public class UserBean {
	
	//�ʵ�� private�Ѵ�.
	private String name;
	private int age;
	private boolean male;
	
	//�⺻�����ڸ� �ݵ�� ������ �־�� �Ѵ�.
	public UserBean() {
	}
	
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}

	// setter, getter�޼ҵ�� ������Ƽ��� �Ѵ�.
	public void setName(String name) {
		this.name = name;
	}

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
