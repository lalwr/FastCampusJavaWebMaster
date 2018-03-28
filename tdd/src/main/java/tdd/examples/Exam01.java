package tdd.examples;

import java.lang.reflect.Method;

public class Exam01 {
    public static void main(String[] args) throws Exception{
        // tdd.examples.MyUiil 이름에 해당하는 클래스를 classpath에서 찾는다.
        // classpath정보를 찾는다. 그 클래스 정보를 메모리에 올린다.
        // static 변수는 메모리에 올라간다. static block이 실행된다.
        // JDBC에서 driver load와 관련됨 개념.
        // 클래스 정보를 구하는거를 리플렉션이라고 한다.
        Class clazz = Class.forName("tdd.examples.MyUtil");
        System.out.println(MyDriver.getName());
        //인스턴스 생성
        Object obj = clazz.newInstance();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        //모든 메소드의 메소드 이름을 출력한다.
        for(Method method : declaredMethods){
            System.out.println(method.getName());
            Class[] parameterTypes =  method.getParameterTypes();
            for(Class ptype : parameterTypes){
                System.out.println(ptype.getName());
            }
            Class returnType = method.getReturnType();
            if(returnType !=null)
                System.out.println("return type : " + returnType.getName());
            System.out.println("------------------------------");
        }


    }
}

class MyUtil{
    static{
        MyDriver.setName("MyUtilDriver");
        //System.out.println("static block");
    }

    @MyTest
    public void print1(){
        System.out.println("print1");
    }

    @MyTest
    public String getName(){
        return "urstory";
    }

    public void setName(String name){
        System.out.println(name + "으로 설정합니다.");
    }
}

class MyDriver{
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MyDriver.name = name;
    }


}
