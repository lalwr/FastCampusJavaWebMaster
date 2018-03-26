package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 직렬화를 실제 수행하는 클래스는 ObjectOutputStream, ObjectInputStream
public class IOExam07 {
    public static void main(String[] args) throws Exception {
        List<MyData> list = new ArrayList<>();
        MyData myData = new MyData();
        myData.setName("홍길동");
        myData.setAge(50);
        list.add(myData);

        FileOutputStream fos = new FileOutputStream("mydata.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(list.size());
        for(int i = 0; i < list.size(); i++){
            dos.writeUTF(myData.getName());
            dos.writeInt(myData.getAge());
        }
        dos.close();

        FileInputStream fis = new FileInputStream("mydata.dat");
        DataInputStream dis = new DataInputStream(fis);
        int size = dis.readInt();
        List<MyData> list2 = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String name = dis.readUTF();
            int age = dis.readInt();
            MyData data = new MyData();
            data.setName(name);
            data.setAge(age);
            list2.add(data);
        }
        dis.close();

        System.out.println(list2.size());
        System.out.println(list2.get(0).getName());
    }
}
