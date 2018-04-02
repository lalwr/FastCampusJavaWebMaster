package soundsystem;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.util.List;

public class JobRunner implements BeanFactoryAware {
    private BeanFactory beanFactory;
    private List<String> list;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void exec(){
        for(String jobName : list){
            BaseJob job = beanFactory.getBean(jobName, BaseJob.class);
            job.exec();
        }
    }
}
