package tdd.examples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/*
spy()는 진짜 인스턴스를 mock하는 것이다. 당연히 spy된 인스턴스를 stub 할 수 있다.
단, 어떤 경우는 stub 할 때 조심해야 한다. 위의 when(spy.get(10))에서는 진짜 인스턴스의 메소드를 호출하기 때문에 IndexOutOfBountException이 발생하게 된다.
이럴 경우 doReturn()를 사용해서 문제를 회피할 수 있다.
 */
@RunWith(MockitoJUnitRunner.class)
public class Examples11 {

    @Test
    public void test() {
        List list = new LinkedList();
        List spy = spy(list); //spy는 선언한 객체의 기능을 모두다 이용 가능하다.

        when(spy.size()).thenReturn(100); // stubbing

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0)); // one
        System.out.println(spy.size()); // 100

        verify(spy).add("one");
        verify(spy).add("two");

// Wrong use case
        //when(spy.get(10)).thenReturn("foo"); // IndexOutOfBoundsException 구현되어 있는 객체라서 에러가 나온다.

// use doReturn() instead
        doReturn("foo").when(spy).get(0);

        System.out.println(spy.get(0));
    }
}
