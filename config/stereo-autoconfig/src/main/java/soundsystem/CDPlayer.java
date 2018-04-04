package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  // 기본생성자가 없을 경우 스프링은 최대한 파라미터에 값을 넣어서 인스턴스 생성을 하려고 노력한다.
  // Spring 4.1부터는 생성자에 @Autowried를 안붙여도, 자동으로 주입을 한다.
  //@Autowired
  public CDPlayer(@Qualifier("myDisc") CompactDisc cd) {
    System.out.println("CDPlayer()");
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }


}
