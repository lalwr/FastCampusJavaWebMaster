package soundsystem;


public class SgtPeppers implements CompactDisc {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";

  public SgtPeppers(){
    System.out.println("SgtPeppers() 호출");
  }
  
  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }

}
