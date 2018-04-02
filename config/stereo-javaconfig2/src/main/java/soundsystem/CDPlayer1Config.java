package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayer1Config {
  @Bean
  public CompactDisc compactDisc() {
    return new SgtPeppers();
  }

  @Bean(name="cdPlayer1")
  public CDPlayer1 cdPlayer1() {
    return new CDPlayer1(compactDisc());
  }

  @Bean(name="cdPlayer2")
  public CDPlayer2 cdPlayer2() {
    return new CDPlayer2(compactDisc());
  }
}
