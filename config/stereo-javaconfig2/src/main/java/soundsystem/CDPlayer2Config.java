package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayer2Config {
  @Bean(name="cd1")
  public CompactDisc compactDisc1() {
    return new MyCD("워너원");
  }

  @Bean(name="cd2")
  public CompactDisc compactDisc2() {
    return new MyCD("아이유");
  }


  @Bean(name="cdPlayer3")
  public CDPlayer1 cdPlayer1(@Qualifier("cd1") CompactDisc cd) {
    return new CDPlayer1(cd);
  }

  @Bean(name="cdPlayer4")
  public CDPlayer1 cdPlayer2(@Qualifier("cd2") CompactDisc cd) {
    return new CDPlayer1(cd);
  }
}
