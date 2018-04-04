package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class B {
    @Autowired
    @Qualifier("D2")
    D d2;
}
