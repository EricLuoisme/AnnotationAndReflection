import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation3(value = "1234")
public class TestDiyAnnotation {

    @MyAnnotation2(name = "test", schools = {"1233", "2331"})
    public void test() {
    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数: 参数类型 + 参数名();
    String name() default "";

    int age() default 0;

    int id() default -1; // 默认值-1代表不存在

    String[] schools() default {"111", "222"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();
}
