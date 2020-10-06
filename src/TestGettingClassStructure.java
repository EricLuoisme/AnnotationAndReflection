import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class TestGettingClassStructure {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        Class<?> user = Class.forName("User");

        System.out.println(user.getName()); // 获取包名+类名
        System.out.println(user.getSimpleName()); // 获取类名

        // 只能获取到public的属性
        Field[] fields = user.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 可以获取到包括private的属性
        Field[] declaredFields = user.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declared " + declaredField);
        }
        System.out.println();

        // 获取该类, 以及其父类的所有public方法
        Method[] methods = user.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();

        // 获取该类所有方法
        Method[] declaredMethods = user.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declared method " + declaredMethod);
        }
        System.out.println();

        // 获取该类及其父类的所有构造方法
        Constructor<?>[] constructors = user.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        // 获取指定构造器
        Constructor<?> declaredConstructor = user.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);

    }
}
