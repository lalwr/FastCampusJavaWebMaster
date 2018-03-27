package tdd.examples.mockito;

import java.util.List;

import static org.mockito.Mockito.*;

/*
체이닝(chaining)을 이용해서 mock 생성과 stub 까지 한 줄에 만들 수 있다.
마지막에 getMock()이 중요한 포인트. 코드가독성도 좋은 편이다.
 */
public class Examples15 {
    public static void main(String[] args) {
        List mock = when(mock(List.class).get(0)).thenReturn(1).thenReturn(2).thenThrow(Exception.class).getMock();

        // mock인지 spy 된 인스턴스인지 확인
        System.out.println(mockingDetails(mock).isMock());
        System.out.println(mockingDetails(mock).isSpy());
    }
}

