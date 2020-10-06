import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class TestGenericReflection {

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = TestGenericReflection.class.getMethod("test01", Map.class, List.class);
        // 获取泛型的参数类型
        Type[] genericParameterTypes = test01.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("outside type " + genericParameterType);
            // 判断当前泛型的参数, 是否等于结构化泛型参数
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("inside type " + actualTypeArgument);
                }
            }
        }
        System.out.println();


        Method test02 = TestGenericReflection.class.getMethod("test02");
        Type genericReturnType = test02.getGenericReturnType();
        System.out.println("outside return type " + genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("return inside type " + actualTypeArgument);
            }
        }
    }
}
