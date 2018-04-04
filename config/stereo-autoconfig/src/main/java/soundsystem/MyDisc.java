package soundsystem;

import org.springframework.stereotype.Component;

@Component("myDisc")
public class MyDisc implements CompactDisc{

    @Override
    public void play() {
        System.out.println("MyDisc Play()");
    }

}
