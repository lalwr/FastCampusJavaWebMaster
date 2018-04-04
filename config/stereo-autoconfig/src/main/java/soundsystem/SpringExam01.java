package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(CDPlayerConfig.class); //@Configuration 이 붙어있는 class만 가능

        CDPlayer cdPlayer = context.getBean(CDPlayer.class); //이 예제가 더 좋은예제다. 스프링을 안써도 쓸수있기 때문에
        cdPlayer.play();

        CDPlayer cdPlayer2 = context.getBean(CDPlayer.class); //이 예제가 더 좋은예제다. 스프링을 안써도 쓸수있기 때문에
        cdPlayer.play();

        if(cdPlayer == cdPlayer2){
            System.out.println("cdPlayer == cdPlayer2");
        }


        CDPlayer2 cdPlayer3 = context.getBean(CDPlayer2.class); //스프링을 사용 안했을때 객체를 초기화 할수 없다.
        cdPlayer3.play();



    }
}
