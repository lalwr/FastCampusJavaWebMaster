package soundsystem.examDice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExamDice {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("soundsystem/examDice/examDice.xml");

        Game game = context.getBean(Game.class);
        game.play();

    }
}
