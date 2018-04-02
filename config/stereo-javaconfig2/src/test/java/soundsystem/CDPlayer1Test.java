package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= CDPlayer1Config.class)
public class CDPlayer1Test {

  @Autowired
  @Qualifier("cdPlayer1")
  private CDPlayer1 player1;

  @Autowired
  @Qualifier("cdPlayer2")
  private CDPlayer2 player2;

  @Test
  public void play() {
    if(player1.getCompactDisc() == player2.getCompactDisc()){
      System.out.println("player1.getCompactDisc() == player2.getCompactDisc()");
    }
  }

}
