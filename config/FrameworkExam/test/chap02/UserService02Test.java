package chap02;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 라이브러리에서 JUnit4 를 추가해야한다.
public class UserService02Test {
	// ApplicationContext를 사용하는 것이 BeanFactory를 사용하는 것보다 훨씬 유리하다.
	// ApplicationContext를 이용하면 Spring이 제공하는 대부분의 중요기능을 사용할 수 있다. (AOP등)
	private ApplicationContext cxt;
	
	@Before
	public void setUp(){
		System.out.println("Container 초기화 전");
		cxt = new ClassPathXmlApplicationContext("applicationContextPage37.xml");
		System.out.println("Container 초기화 후");
	}
	
	@Test
	public void AddUser(){
		System.out.println("Bean 이용");;
		UserService a1 = (UserService)cxt.getBean("userService");
		a1.addUser();
	}
}
