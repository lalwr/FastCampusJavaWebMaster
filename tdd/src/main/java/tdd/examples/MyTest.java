package tdd.examples;

import java.lang.annotation.*;

//MyTest 라는 애노테이션을 작성한다
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTest {

}
