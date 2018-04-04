package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam02 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context
                = new ClassPathXmlApplicationContext("cdplayer-config.xml");

    }
}
