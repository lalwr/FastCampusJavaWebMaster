package chap02;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

// 라이브러리에서 JUnit4 를 추가해야한다.
public class UserService01Test {
	// BeanFactory 를 사용할 경우  Spring의 중요기능인 AOP등을 사용할 수 없다. 단순히 Bean컨테이너 기능만 사용할 경우 사용한다.
	private BeanFactory cxt;
	
	@Before
	public void setUp(){
		System.out.println("Container 초기화 전");
		cxt = new XmlBeanFactory(new FileSystemResource("./resource/applicationContextPage37.xml"));
		System.out.println("Container 초기화 후");
	}
	
	@Test
	public void AddUser(){
		System.out.println("Bean 이용");;
		UserService a1 = (UserService)cxt.getBean("userService");
		a1.addUser();
	}
}
