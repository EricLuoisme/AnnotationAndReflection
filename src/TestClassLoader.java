public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {

        // 系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统加载器的父类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器, 由于是C++编写的, java无法获取
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 查看当前类是哪个加载器加载的, 不为空, 可以看到都是使用AppClassLoader加载的
        ClassLoader testClassLoader = Class.forName("TestClassLoader").getClassLoader();
        System.out.println(testClassLoader);

        // 查看JDK类是哪个加载器加载的, 为空是因为使用根加载器加载的
        ClassLoader testClassLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(testClassLoader2);

        // 获取系统类加载器加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /**
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\charsets.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\deploy.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\javaws.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\jce.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfr.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\jsse.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\management-agent.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\plugin.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\resources.jar;
         * C:\Program Files\Java\jdk1.8.0_201\jre\lib\rt.jar;
         * C:\Users\lykis\IdeaProjects\AnnotationAndReflection\out\production\AnnotationAndReflection;
         * C:\Program Files\JetBrains\IntelliJ IDEA 2020.1\lib\idea_rt.jar
         */
    }
}
