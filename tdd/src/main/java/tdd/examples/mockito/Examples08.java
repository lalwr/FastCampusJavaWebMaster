package tdd.examples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class) //class에 가지고 있는 필드에서 @Mock를 가지고 있는 모든 애들한테 MOCK객체를 할당한다.
public class Examples08 {
    @Mock
    private List mockedList;

    @Test
    public void test() {
        // test here
    }
}
