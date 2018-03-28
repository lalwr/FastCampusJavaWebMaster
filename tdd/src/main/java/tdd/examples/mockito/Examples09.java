package tdd.examples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.List;

/*
가끔씩 하나의 메소드에서 순차적으로 여러 다른 값을 돌려주거나 예외를 발생시켜야 할 때가 있다.
한 번 stub한 값은 바뀌지 않지만 다음과 같이 매번 호출할 때 마다 다른 행동을 하도록 정할 수 있다.
 */
@RunWith(MockitoJUnitRunner.class)
public class Examples09 {
    @Mock
    private MyBean mock;

    @Test
    public void test1() {
// chaining
        when(mock.someMethod(anyString())) //한번에 설정을 하기위해
                .thenReturn("foo")
                .thenReturn("bar") // 마지막 값이 계속고정되서 나온다.
                .thenThrow(new RuntimeException());

        System.out.println(mock.someMethod("some arg")); // foo
        System.out.println(mock.someMethod("some arg")); // bar
//        System.out.println(mock.someMethod("some arg")); // Runtime Exception
    }

    @Test
    public void test2() {
// multi arguments
        when(mock.someMethod(anyString()))
                .thenReturn("one", "two"); // 마지막 값이 계속고정되서 나온다.

        System.out.println(mock.someMethod("some arg")); // one
        System.out.println(mock.someMethod("some arg")); // two
        System.out.println(mock.someMethod("some arg")); // two - 마지막 stub한 값으로 고정
    }
}


interface MyBean{
    public String someMethod(String str);
}