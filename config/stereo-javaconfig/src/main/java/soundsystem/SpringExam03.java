package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam03 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CDPlayerConfig3.class);

        CDPlayer cdPlayer = context.getBean(CDPlayer.class);
        cdPlayer.play();




    }
}
