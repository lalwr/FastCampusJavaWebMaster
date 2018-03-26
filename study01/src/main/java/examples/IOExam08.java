package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 직렬화를 실제 수행하는 클래스는 ObjectOutputStream, ObjectInputStream
public class IOExam08 {
    public static void main(String[] args) throws Exception {
        List<MyData> list = new ArrayList<>();
        MyData myData = new MyData();
        myData.setName("홍길동");
        myData.setAge(50);
        list.add(myData);

        List<MyData> list2 = (List)ObjectCopyUtil.copy(list);
        System.out.println(list2.size());
    }


}

class ObjectCopyUtil{
    public static Object copy(Object obj) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(obj);

        oos.close();

//        byte[] memory = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object result = ois.readObject();
        ois.close();
        return result;
    }
}
