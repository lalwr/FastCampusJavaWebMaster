package examDice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExamDice {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DiceGameConfig.class);
        Game game = context.getBean(Game.class);
        game.play();

    }
}
