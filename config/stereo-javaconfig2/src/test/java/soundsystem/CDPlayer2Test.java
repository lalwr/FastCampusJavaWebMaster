package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= CDPlayer2Config.class)
public class CDPlayer2Test {

  @Autowired
  @Qualifier("cdPlayer3")
  private CDPlayer1 player1;

  @Autowired
  @Qualifier("cdPlayer4")
  private CDPlayer1 player2;

  @Test
  public void play() {
    player1.play();
    player2.play();
  }

}
