package examples;

public class HelloMain {
    public static void main(String[] args) throws Exception{
        //Hello1 hello1 = new Hello1();
        //Hello2 hello2 = new Hello2();

        for(int i =1; i <=2; i++){
            //Hello hello = new Hello1();
            String className1 = "examples.Hello" +i;
            // className1에 해당하는 클래스 정보를 clazz에 대입
            Class clazz = Class.forName(className1);
            // clazz가 가지고 있는 정보를 이용해 인스턴스를 생성
            Hello hello = (Hello)clazz.newInstance();

            hello.hello();
        }

        //Hello hello1 = new Hello1();
        String className1 = "examples.Hello" +1;
        Class clazz = Class.forName(className1);
        Hello hello1 = (Hello)clazz.newInstance();
        Hello hello2 = new Hello2();

        hello1.hello();
        hello2.hello();
    }
}

//문제
//1. 이름을 알 수 없는 클래스가 여러개 만들어질 경우, 어떻게 인스턴스를 생성할 것인가?

//2. Git에 특정 파일을 올리지 않으려면?
//.gitignore를 만들고 디렉토리와 파일 이름 패턴을 등록한다. Intellij에서는 회색으로 표시된다.

// class : Hello1 ~ Hello10 ...계속 증가 할떄
// method : hello()
// Hello1 ~ Hello10 ... 인스턴스를 만든 후 Hello()메소드를 호출하라.

// Hello100 h100 = new Hello100();
// Hello + 100 h100 = new Hello + 100();

//Httpservlet 구현하기 위해서