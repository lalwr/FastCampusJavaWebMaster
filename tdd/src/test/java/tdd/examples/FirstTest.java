package tdd.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Juinit은 메소드 선언된 순서대로 실행되는것은 아니다.
public class FirstTest {
    // 테스트 대상은 필드로 선언
    MyUtil myUtil;
    @Before
    public void init(){
        myUtil = new MyUtil();
        System.out.println("init");
    }
    @Test
    public void test3() throws Exception{
        System.out.println("test3");
    }
    @Test
    public void test1() throws Exception{
        System.out.println("test1");
    }
    @Test
    public void test2() throws Exception{
        System.out.println("test2");
    }

    @After
    public void destory(){
        myUtil = null;
        System.out.println("destory");
    }

}
