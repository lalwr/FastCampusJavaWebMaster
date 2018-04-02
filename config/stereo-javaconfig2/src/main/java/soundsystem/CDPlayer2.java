package soundsystem;

public class CDPlayer2 implements MediaPlayer {
  private CompactDisc cd;

  public CDPlayer2(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

  public CompactDisc getCompactDisc(){
    return cd;
  }
}
