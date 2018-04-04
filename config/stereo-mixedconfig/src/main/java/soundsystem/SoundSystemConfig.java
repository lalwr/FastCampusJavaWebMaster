package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:cd-config.xml")
@Import(CDPlayerConfig.class)
public class SoundSystemConfig {

}
