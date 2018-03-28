package tdd.examples;

import java.lang.reflect.Method;

public class Exam03 {
    public static void main(String[] args) throws Exception{
        String className = "tdd.examples.MyUiil";
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
            System.out.println(parameterCount);
            System.out.println(method2.getName());
           if(parameterCount > 0){
                System.out.println("111");
                /*Method getMethod = clazz.getMethod(method2.getName(), String.class);
                if(method2 != null){
                    Object returnValue = getMethod.invoke(obj, parameterValues);
                }*/
            }else{
               System.out.println("222");
               Method getMethod = clazz.getMethod(methodName, null);
                System.out.println(getMethod.getName());
                if(method2 != null){
                    //obj의 메소드중 method정보에 해당하는 메소드를 실행하라.
                    Object returnValue = getMethod.invoke(obj, null);
                    if(returnValue != null){
                        System.out.println(returnValue.getClass().getName());
                    }
                }
            }
        }


    }
}
