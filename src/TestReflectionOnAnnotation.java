import java.lang.annotation.*;
import java.lang.reflect.Field;

public class TestReflectionOnAnnotation {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> student2 = Class.forName("Student2");

        // 1. 获取annotation
        Annotation[] annotations = student2.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 2. 获取annotation中的value的值
        TableTest annotation = student2.getAnnotation(TableTest.class);
        System.out.println(annotation.value());

        // 3. 获取某个field的annotation
        Field name = student2.getDeclaredField("name");
        FieldTest annotation1 = name.getAnnotation(FieldTest.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
    }

}

@TableTest("db_student")
class Student2 {

    @FieldTest(columnName = "db_id", type = "int", length = 10)
    private int id;

    @FieldTest(columnName = "db_age", type = "int", length = 10)
    private int age;

    @FieldTest(columnName = "db_name", type = "varchar", length = 5)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableTest{
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldTest{
    String columnName();
    String type();
    int length();
}