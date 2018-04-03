package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// reflection proxy , cgLIB
public class SpringExam02 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CDPlayerConfig2.class);

        CompactDisc mydisc = context.getBean("myDisc", CompactDisc.class);
        CDPlayer cdPlayer = context.getBean(CDPlayer.class);
        CompactDisc disc = cdPlayer.getCompactDisc();

        if(mydisc == disc){
            System.out.println("myDisc == disc");
        }else{
            System.out.println("myDisc =! disc");
        }


    }
}
