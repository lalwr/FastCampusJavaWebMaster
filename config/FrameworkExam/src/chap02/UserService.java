package chap02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class UserService implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware{
	public UserService(){
		super();
		System.out.println("UserService 생성자 호출...");
	}
	
	public void addUser(){
		System.out.println("UserSErvice:addUser call....");
	}
	
	@Override
	public void setBeanName(String beanId) {
		System.out.println("BeanNameAware 인터페이스의 메소드 setBeanName. 초기화되는 Bean의 Id를 전달 받는다. :" + beanId);
	}
	
	

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("BeanClassLoaderAware 인터페이스의 메소드 setBeanClassLoader. 스프링 컨테이너가 사용하는 ClassLoader를 전달한다.");
	}
	
	

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryAware 인터페이스의 메소드 setBeanFactory. 컨테이너 자체를 넘겨받는다. 빈 클래스 안에서 스프링 팩토리를 사용하고자 할 경우 사용한다.");
		
	}

	// ApplicationContext만 호출한다. BeanFactory는 호출하지 않음
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("ResourceLoaderAware 인터페이스 메소드 setResourceLoader");
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("ApplicationEventPublisherAware 인터페이스의 메소드 setApplicationEventPublisher");
		
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("MessageSourceAware 인터페이스의 메소드 setMessageSource ");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("ApplicationContextAware 의 setApplicationContext 메소드 호출. ApplicationContext를 사용할 경우 컨테이너를 전달");
		
	}

	// page 46 initMethod
	public void initMethod(){
		System.out.println("initMethod");
	}
	
	// page 46 destroyMethod
	public void destoryMethod(){
		System.out.println("destoryMethod");
	}
	
}
