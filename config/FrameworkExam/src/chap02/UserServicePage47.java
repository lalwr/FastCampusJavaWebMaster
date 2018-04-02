package chap02;


public class UserServicePage47 {
	// private 생성자
	private UserServicePage47(){
		super();
		System.out.println("UserService47 생성자 호출...");
	}
	
	public static UserServicePage47 getInstance(){
		return new UserServicePage47();
	}
	
	public void addUser(){
		System.out.println("UserSErvice:addUser call....");
	}
		
}
