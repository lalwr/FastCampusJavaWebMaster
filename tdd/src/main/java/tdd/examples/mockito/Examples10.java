package tdd.examples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.List;

/*
이때까지의 예제에서는 stub 할 때 모두 특정값을 넣었다.
만약 mock의 상태나 메소드 인자값에 따라 다른 값을 돌려주게 하게 만들고 싶다면 어떻게 해야할까.
Answer<?> 클래스를 사용하면 가능하다.
 */
@RunWith(MockitoJUnitRunner.class)
public class Examples10 {
    @Mock
    private List mockedList; //제네릭을 안쓰면 오브젝트로 타입으로 선언된다.

    @Test
    public void test() {
        //int get(int)
        when(mockedList.get(anyInt())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments(); // arguments
                List mock = (List)invocation.getMock(); // mock itself : 목객체는 호출만 하는것이지 값을 넣는것이 아니다.
                int result = (Integer)args[0] + 1;
                return result;
            }
        });
        //int size(); 0 <=x<=10
        //람다표현식 : Answer는 메소드가 1개다. 메소드가 한개인 인터페이스를 함수형인터페이스라고 한다.
        // 함수형 인터페이스를 사용하는 이름없는 객체는 람다표현식으로 바꿀 수 있다.
        //위의 메소드와 똑같이 구현한 것이다.
        when(mockedList.size()).thenAnswer(
            (invocation) -> {
                int result = (int) (Math.random() * 10 + 1);
                return result;
            }
        );

        when(mockedList.remove(0)).thenAnswer( //api에서 리턴하는 타입을 확인한다.
            (invocaton) -> {
                String result = "123";
                return result;
            }
        );



        System.out.println(mockedList.get(1)); // called with argument: 2
        System.out.println(mockedList.size()); // 람다표현식
        System.out.println(mockedList.remove(0)); // 테스트구현
    }
}
