package tdd.examples.mockito;

import org.mockito.InOrder;

import java.util.List;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

// Verification in order
public class Examples06 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        // single mock
        List singleMock = mock(List.class);

        singleMock.add("first");
        singleMock.add("second");

        InOrder inOrder = inOrder(singleMock);

        inOrder.verify(singleMock).add("first");
        inOrder.verify(singleMock).add("second");
    }

    public static void test2(){
        // multiple mocks
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        //using mocks
        firstMock.add("first");
        secondMock.add("second");

        InOrder inOrder = inOrder(firstMock, secondMock); // pass multiple mocks to verify

        inOrder.verify(firstMock).add("first");
        inOrder.verify(secondMock).add("second");
    }
}

