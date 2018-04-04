package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CDPlayer2 implements MediaPlayer {


  /*
    @Autowried
    @Qualifier("myDisc")
    는
    @Resource(name = "myDisc")
    와 같은 소스이다.
  */
  // CompactDisc를 자동으로 주입받는다.
  @Autowired
  @Qualifier("myDisc") // CompactDisc 를 구현하는 클래스가 2개 이상일 경우 이름을 지정한다.
  private CompactDisc cd;

  public CDPlayer2(){
    System.out.println("CDPlayer2()");
  }

  public void play() {
    cd.play();
  }


}
