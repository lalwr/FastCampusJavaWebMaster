package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// GuestbookListServlet -----> GuestbookService(조회)
// GuestbookWriteServlet -----> GuestbookService(저장)
//싱글턴 : 메모리에 오직 한개의 인스턴스만 생성하도록 한다.
public class GuestbookService {
    //필드 선언
    List<GuestBook> list;

    // 1. private생성자를 만든다.
    private GuestbookService(){
        File file = new File("guestbook.dat");
        if(file.exists()){
            ObjectInputStream ois = null;
            try{
                System.out.println(file.getAbsolutePath()); ///Users/mac/programing/SERVER/apache-tomcat-8.5.29/bin/guestbook.dat
                ois = new ObjectInputStream(new FileInputStream(file));
                list = (List)ois.readObject();
            }catch(Exception ex){
                ex.printStackTrace();
            }finally {
                try{ ois.close(); }catch(Exception e){}
            }
        }else {
            list = Collections.synchronizedList(new ArrayList());
        }
    }

    // 2. private static 하게 자기자신을 참조하는 변수를 생성. 이때 초기화도 한다.
    private static GuestbookService service = new GuestbookService();

    // 3. 2.에서 생성한 인스턴스를 반환하는 public static 한 메소드를 만든다.
    public static GuestbookService getService(){
        return service;
    }

    public void addGuestBook(GuestBook guestBook){
        list.add(guestBook);
    }

    // list를 수정할수 있게 객체를 전달 해줘서 외부에서 조작이 가능하다
    /*public List<GuestBook> getGuestBooks2(){
        return list;
    }*/

    public Iterator<GuestBook> getGuestbooks(){ //객체의 값 여부만 확인 할 수 있다.
        return list.iterator();
    }

    public void save(){
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("guestbook.dat"));
            os.writeObject(list);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                os.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }
}
