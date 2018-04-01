package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BoardService {
    //리스트
    List<BoardVO> list;

    private BoardService(){
        File file = new File("board.dat");
        if(file.exists()){
            ObjectInputStream ois = null;
            System.out.println("파일 경로 : " + file.getAbsolutePath()); //파일경로
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                list = (List)ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try{ ois.close(); }catch(Exception e){}

            }
        }else{
            list = Collections.synchronizedList(new ArrayList());
        }
    }

    public static BoardService service = new BoardService();

    public static BoardService getService() { return service; }

    public void addBoard(BoardVO boardVO){ list.add(boardVO); }

    public Iterator<BoardVO> getBoard(){ return list.iterator(); }

    public void save(){
        ObjectOutputStream os = null;
        try{
            os = new ObjectOutputStream((new FileOutputStream("board.dat")));
            os.writeObject(list);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
