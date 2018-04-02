package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context
                = new ClassPathXmlApplicationContext("exam01.xml");

        //MyBean bean1 = new MyBean(); //스프링이 관리해 주는것이 아니다. 이렇게 사용하면 안된다.

        // Spring은 기본적으로 객체를 싱글턴으로 관리한다.
        MyBean bean1 = (MyBean)context.getBean("bean1"); //Object타입으로 반환된다.
        bean1.setName("홍길동");

        MyBean bean2 = (MyBean)context.getBean("bean1");
        System.out.println(bean2.getName()); //홍길동이 출력된다.

        //MyBean bean5 = context.getBean(MyBean.class); //형변환을 안해도 된다. 클래스 하나에 bean이 2개라서 에러 발생
        MyBean bean6 = context.getBean("bean1",MyBean.class); //형변환 하지 않는다. 빈 이름을 설정 가능하다.
        System.out.println(bean6.getName());

       /* MyBean bean3 = (MyBean)context.getBean("bean2");
        System.out.println(bean3.getName()); //값이 없다. */

        //bean3 이 라는 id의 빈은 설정되어 있지 않기 떄문에 Exception이 발생한다.
        /*MyBean bean4 = (MyBean)context.getBean("bean3");
        System.out.println(bean4.getName());*/



    }
}
