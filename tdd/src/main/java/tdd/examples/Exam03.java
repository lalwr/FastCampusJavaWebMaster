package tdd.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Exam03 {
    public static void main(String[] args) throws Exception{
        String className = "tdd.examples.MyUtil";
        String methodName = "setName"; //void setName(String)
        Object[] parameterValues = {"Kim"};

        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();

        Method method = clazz.getMethod(methodName, String.class);
        if(method != null){
            Object returnValue = method.invoke(obj, parameterValues);
        }

    }
}
