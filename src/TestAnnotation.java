import java.lang.annotation.*;

@MyAnnotation
public class TestAnnotation {

    @MyAnnotation
    public void test() {

    }
}

// 定义一个注解
// Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})

// Retention表示我们的注解在什么地方有效
// run time > class > sources
@Retention(value = RetentionPolicy.RUNTIME)

// Documented 表示是否将注解生成在Java Doc里面
@Documented

// Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}