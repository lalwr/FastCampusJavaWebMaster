package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BoardService {
    //리스트
    List<BoardVO> list;

    private BoardService(){
        list = Collections.synchronizedList(new ArrayList());
    }

    public static BoardService service = new BoardService();

    public static BoardService getService() { return service; }

    public void addBoard(BoardVO boardVO){ list.add(boardVO); }

    public Iterator<BoardVO> getBoard(){ return list.iterator(); }

}
