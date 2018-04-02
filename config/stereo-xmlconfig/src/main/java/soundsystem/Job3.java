package soundsystem;

import org.springframework.beans.factory.BeanNameAware;

public class Job3 implements BaseJob,BeanNameAware {
    private String id;

    @Override
    public void setBeanName(String s) {
        this.id = s;
    }

    @Override
    public void exec() {
        System.out.println("Job3 exec!!!");
    }
}
