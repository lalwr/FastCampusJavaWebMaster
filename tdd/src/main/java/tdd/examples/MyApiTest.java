package tdd.examples;

import org.junit.Test;
import org.springframework.util.Assert;

public class MyApiTest {
    MyApi myApi = new MyApiImpl();

    @Test
    public void testGet() throws Exception{
        String s = myApi.get();
        Assert.notNull(s);
    }
}
