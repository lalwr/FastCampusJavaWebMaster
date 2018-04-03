package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//java config 클래스에는 @Configuration 이 클래스위에 있어야 한다.
@Configuration
public class CDPlayerConfig4 {


  //메소드 이름이 id가 된다. 메소드 이름이 중복되면 id가 중복된다는 의미기때문에 안된다.
  // <bean id="conpacDisc" class="soundsystem.SgtPeppers" />
  // Bean 생성을 하는 메소드는 @Bean이 붙어야 한다.
  @Bean
  @Scope("prototype")
  public CompactDisc compactDisc() {
    System.out.println("compactDisc() 호출");
    return new SgtPeppers();
  }



}
