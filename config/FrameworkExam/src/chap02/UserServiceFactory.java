package chap02;

public class UserServiceFactory {
	public UserService getInstance(){
		System.out.println("UserServiceFactory.getInstance");
		return new UserService();
	}
}
