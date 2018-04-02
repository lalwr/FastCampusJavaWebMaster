package soundsystem.examDice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class Dice implements BeanNameAware, BeanFactoryAware {
    private String name;
    private int face;

    @Override
    public void setBeanName(String s) {
        name = s;
        System.out.println("Dice.setBeanName() : " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Dice.setBeanFactory()");
        Player kim = beanFactory.getBean("kim", Player.class);
    }

    public Dice(int face){
        System.out.println("Dice 생성자");
        this.face = face;
    }

    public int getNumber(){
        System.out.println("Dice.getNumber");
        return (int)(Math.random() * face) +1;
    }

}
