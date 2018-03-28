package tdd.examples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exam04 {
    public static void main(String[] args) throws Exception{

        String className = "tdd.examples.MyUiil";
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();

        // MyUtil클래스의 메소드중 @MyTest애노테이션이 붙은 메소드이름만 출력하시오.

        //모든 메소드의 메소드 이름을 출력한다.
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for(Method method : declaredMethods){
            MyTest annotation = method.getAnnotation(MyTest.class);
            if(annotation != null){
                method.invoke(obj, null);
            }

        }


    }
}
