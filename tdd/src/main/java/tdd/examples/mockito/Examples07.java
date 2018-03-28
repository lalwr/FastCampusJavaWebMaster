package tdd.examples.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;


public class Examples07 {
    @Mock private List mockedList;

    @Before
    public void initMocks() {
        //class에 가지고 있는 필드에서 @Mock를 가지고 있는 모든 애들한테 MOCK객체를 할당한다.
        MockitoAnnotations.initMocks(this); // mock all the field having @Mock annotation
    }

    @Test
    public void test() {
        mockedList.add("one");

        verify(mockedList).add("one");

    }
}
