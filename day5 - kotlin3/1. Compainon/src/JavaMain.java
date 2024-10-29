public class JavaMain {
    public int javaA1 = 100;
    public static int javaA2 = 200;
    public void javaMethod1() {
        System.out.println("javaMethod1");
    }
    public static void javaMethod2() {
        System.out.println("javaMethod2");
    }
    public static void main(String[] args) {
        TestClass1 t1 = new TestClass1();
        System.out.printf("t1.a1: %d\n", t1.getA1());
        t1.testFun1();

//        System.out.printf("TestClass1.a2: %d\n", TestClass1.a2);
//        TestClass1.testFun2();
        System.out.printf("TestClass1.a2: %d\n", TestClass1.Companion.getA2());
        TestClass1.Companion.testFun2();

        System.out.printf("TestClass1.a3: %d\n", TestClass1.getA3());
        TestClass1.testFun3();
    }
}
