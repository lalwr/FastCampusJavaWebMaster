package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        CompactDisc compactDisc1 = context.getBean("compactDisc", CompactDisc.class);
        CompactDisc compactDisc2 = context.getBean("compactDisc", CompactDisc.class);
        if(compactDisc1 == compactDisc2){
            System.out.println("compactDisc1 == compactDisc2");
        }

        CompactDisc compactDisc3 = context.getBean("myDisc", CompactDisc.class);
        compactDisc3.play();

        CDPlayer compactDisc4 = context.getBean("cdPlayer", CDPlayer.class);
        compactDisc4.play();
    }
}
