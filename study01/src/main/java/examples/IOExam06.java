package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//직렬화를 실제 수행하는 클래스는 ObjectOutputStream, ObjectInputStream
public class IOExam06 {
    public static void main(String[] args) throws Exception{
        List<MyData> list = new ArrayList<>();
        MyData myData = new MyData();
        myData.setName("홍길동");
        myData.setAge(50);
        list.add(myData);

        FileOutputStream fos = new FileOutputStream("mydata.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(list);
        oos.close();

        FileInputStream fis = new FileInputStream("mydata.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<MyData> list2 = (List)ois.readObject();
        ois.close();

        System.out.println(list2.size());
        System.out.println(list2.get(0).getName());

    }
}

// Serializable는 메소드가 없다. 이러한 인터페이스를 마크(Mark)인터페이스라고 한다.
// 표시를 한다.
// 객체 직렬화 되는 조건 : Serializable를 구현하거나 기본형타입
//                    필드로 선언된 타입도 같은 조건이어야 한다.
class MyData implements Serializable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}