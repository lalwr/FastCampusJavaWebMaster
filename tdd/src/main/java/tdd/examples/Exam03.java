package tdd.examples;

import java.lang.reflect.Method;

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


        //연습
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //모든 메소드의 메소드 이름을 출력한다.
        for(Method method2 : declaredMethods){
            int parameterCount =  method2.getParameterCount();

           if(parameterCount == 0){
               System.out.println("222");
            }else{
               System.out.println("111");
            }
        }


    }
}
