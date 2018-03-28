package tdd.examples.mockito;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// Mocking과 Verification
public class Examples01 {
    public static void main(String[] args){
        // mock
        // List인터페이스를 구현하고 있는객체를 실행시 만들어 준다. 원래 List는 인터페이스다.
        List mockedList = mock(List.class); //static한 import라서 앞에 Mockito를 입력 안해도 된다. ->  mock

        // mock 사용하기
        mockedList.add("one");
        mockedList.clear();

        // verification
        verify(mockedList).add("one"); //static한 import라서 앞에 Mockito를 입력 안해도 된다. -> verify
        verify(mockedList).clear();
    }
}

/*
사용과 검증값이 다를경우

list.add("one");
-> at tdd.examples.mockito.Examples01.main(Examples01.java:19)
Actual invocation has different arguments:
list.add("two");
-> at tdd.examples.mockito.Examples01.main(Examples01.java:15)

	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at tdd.examples.mockito.Examples01.main(Examples01.java:19)
*/