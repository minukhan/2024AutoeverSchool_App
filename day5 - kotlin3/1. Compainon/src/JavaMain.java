public class JavaMain {

    // 일반 맴버 변수
    public int javaA1 = 100;
    // 정적 맴버 변수
    public static int javaA2 = 200;

    // 일반 맴버 메서드
    public void javaMethod1(){
        System.out.println("javaMethod1");
    }
    // 정적 맴버 메서드
    public static void javaMethod2(){
        System.out.println("javaMethod2");
    }

    public static void main(String [] args){
        // Kotlin에서 만든 클래스 사용
        TestClass1 t1 = new TestClass1();
        System.out.println("t1.a1 : " + t1.getA1());
        t1.testMethod1();

        // Kotlin에서 정의한 정적 맴버를 사용한다.
        System.out.println("TestClass1.a2 : " + TestClass1.Companion.getA2());
        TestClass1.Companion.testMethod2();

        System.out.println("TestClass1.a3 : " + TestClass1.getA3());
        TestClass1.testMethod3();
    }
}
