package tdd.examples.mockito;

import org.junit.Assert;
import org.mockito.ArgumentCaptor;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/*
Argument Matcher와 비슷한 기능을 가지고 있는 Argument Captor라는 것도 있다.
Argument Matcher와 다른 점은 따로 클래스를 만들 필요가 없다는 점,
그리고 verification에만 사용할 수 있다는 점이다.
 */
public class Examples13 {
    public static void main(String[] args) {

        List mock = mock(List.class);
        mock.addAll(Arrays.asList("one", "two"));  // false

        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        verify(mock).addAll(argument.capture());
        Assert.assertTrue(argument.getValue().size() == 2);
    }
}

