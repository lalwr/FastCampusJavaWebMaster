package soundsystem;

public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  public CDPlayer(CompactDisc cd) {
    System.out.println("CDPlayer(CompactDisc) 호출");
    this.cd = cd;
  }

  public CompactDisc getCompactDisc() {
    return cd;
  }

  public void play() {
    cd.play();
  }

}
