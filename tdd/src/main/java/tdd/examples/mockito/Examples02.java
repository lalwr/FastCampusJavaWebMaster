package tdd.examples.mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

// Mocking과 Verification
public class Examples02 {
    public static void main(String[] args) {
        // 클래스 뿐만이 아니라 인터페이스도 mock 할 수 있다.
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0)); // first
        System.out.println(mockedList.get(1)); // Runtime exception 발생
        System.out.println(mockedList.get(10)); // null

        verify(mockedList).get(0);
    }
}

/*
생성한 Mock의 메소드를 호출하면 아무런 행동도 하지 않는다.
위의 예제에서와 같이 Mock의 메소드를 호출해도 실제로 코드를 실행하지 않으므로 내부의 값은 변하지 않는다.
메소드의 리턴값도 객체의 경우 null, int의 경우 0, boolean의 경우 false로 그 타입의 기본값을 넘겨준다.
 */