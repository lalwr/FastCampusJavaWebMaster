package soundsystem;
import org.springframework.stereotype.Component;

@Component
// 《Sgt. Pepper's Lonely Hearts Club Band》는 영국의 록 밴드 비틀즈의 여덟 번째 정규 음반이다.
public class SgtPeppers implements CompactDisc {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";
  
  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }
  
}
