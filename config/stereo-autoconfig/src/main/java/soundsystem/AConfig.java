package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AConfig {

    @Bean
    public C c(D3 d3){
        C c = new C();
        c.d3 = d3;
        return c;
    }
}
