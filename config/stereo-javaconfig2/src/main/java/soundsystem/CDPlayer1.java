package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer1 implements MediaPlayer {
  private CompactDisc cd;

  public CDPlayer1(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

  public CompactDisc getCompactDisc(){
    return cd;
  }
}
