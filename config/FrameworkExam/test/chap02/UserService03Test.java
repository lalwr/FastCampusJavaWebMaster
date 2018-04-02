package chap02;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//  spring-test관련 라이브러리가 classpath에 존재해야한다.
//  @ContextConfiguration(locations = { "file:**/WEB-INF/spring/root-context.xml", "file:**/WEB-INF/spring/servlet-context.xml"}) 와 같이 여러개의 스프링 설정파일을 지정할 수 있다.
// 앞의 예제는 스프링 컨테이너를 직접 선언하고 사용하는 방식이었다면 아래의 방법은 Spring이 제공하는 Junit4를 상속받는 클래스인
// SpringJUnit4ClassRunner를 이용하여 설정파일을 지정하면 내부적으로 ApplicationContext가 사용되어 진다.
// 개발자 입장으로 보면 블랙박스형태로 되어, 이해가 더 어려울 수 있으나 사용법만 익혀서 사용한다는 개념으로 봤을때는 훨씬 간편한 방법이라고 말할 수 있다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:**/resource/applicationContextPage37.xml"})
public class UserService03Test {
	@Autowired
	UserService userService;
	
	@Before
	public void setUp(){
		System.out.println("setUp");
	}
	
	@Test
	public void AddUser(){
		userService.addUser();
	}
}
