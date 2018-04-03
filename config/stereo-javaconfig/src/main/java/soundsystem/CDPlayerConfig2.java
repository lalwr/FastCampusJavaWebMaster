package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//java config 클래스에는 @Configuration 이 클래스위에 있어야 한다.
@Configuration
public class CDPlayerConfig2 {

  // Bean을 생성하는 메소드는 예를 들어 myDisc()는 2번째 호출될 경우에는 이미 생성된 MyDisc()를 리턴한다.
  @Bean
  public CDPlayer cdPlayer() {
    System.out.println("cdPlayer() 호출");
    return new CDPlayer(myDisc());
  }

  //메소드 이름이 id가 된다. 메소드 이름이 중복되면 id가 중복된다는 의미기때문에 안된다.
  // <bean id="conpacDisc" class="soundsystem.SgtPeppers" />
  // Bean 생성을 하는 메소드는 @Bean이 붙어야 한다.
  @Bean
  public CompactDisc compactDisc() {
    System.out.println("compactDisc() 호출");
    return new SgtPeppers();
  }

  @Bean
  public CompactDisc myDisc(){
    System.out.println("-----------------------");
    System.out.println(getClass().getName());
    System.out.println("myDisc() 호출");
    System.out.println("-----------------------");
    return new MyDisc();
  }

}
