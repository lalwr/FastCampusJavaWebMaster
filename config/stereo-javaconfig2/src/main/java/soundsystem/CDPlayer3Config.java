package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayer3Config {
  @Bean
  public CompactDisc compactDisc() {
    return new SgtPeppers();
  }

  @Bean("cdPlayer1")
  public CDPlayer1 cdPlayer1() {
    return new CDPlayer1(compactDisc());
  }

  @Bean("cdPlayer2")
  public CDPlayer2 cdPlayer2() {
    return new CDPlayer2(compactDisc());
  }

  @Bean("cd1")
  public CompactDisc compactDisc1() {
    return new MyCD("워너원");
  }

  @Bean("cd2")
  public CompactDisc compactDisc2() {
    return new MyCD("아이유");
  }


  @Bean("cdPlayer3")
  public CDPlayer1 cdPlayer3(@Qualifier("cd1") CompactDisc cd) {
    return new CDPlayer1(cd);
  }

  @Bean("cdPlayer4")
  public CDPlayer1 cdPlayer4(@Qualifier("cd2") CompactDisc cd) {
    return new CDPlayer1(cd);
  }
}
