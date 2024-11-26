// Companion
// Java에서 Static과 동일하다.
// 클래스내에서 companion 맴버로 정의된 요소들은 객체 생성 없이 사용이 가능하며
// 클래스의 이름을 통해 접근한다.
// companion 변수의 경우 딱 하나만 생성되어 사용할 수 있다.

fun main(){
    val t1 = TestClass1()
    // 클래스에 정의한 모든 일반 맴버들은
    // 객체를 생성해야지만 사용할 수 있다.
    println("t1.a1 : ${t1.a1}")
    t1.testMethod1()

    // Companion Object에 정의한 맴버들은 객체를 통해 사용할 수 없다.
    // println("t1.a2 : ${t1.a2}")
    // t1.testMethod2()

    // Companion Object에 정의한 맴버들은 객체 생성 없이
    // 클래스의 이름을 통해 접근해야 한다.
    println("TestClass1.a2 : ${TestClass1.a2}")
    TestClass1.testMethod2()

    // Java 코드로 만들어진 클래스를 통해 객체를 생성한다.
    val javaMain = JavaMain()
    println("javaMain.javaA1 : ${javaMain.javaA1}")
    javaMain.javaMethod1()

    // println("javaMain.javaA2 : ${javaMain.javaA2}")
    // javaMain.javaMethod2()
    println("JavaMain.javaA2 : ${JavaMain.javaA2}")
    JavaMain.javaMethod2()
}

class TestClass1{
    // 일반 맴버 변수
    var a1 = 100

    // companion object 정의
    companion object{
        var a2 = 200
        // @JvmStatic : companion 맴버를 자바에서 사용할 때 Companion를 클래스를 거치지 않고
        // 직접 사용할 수 있도록 할 수 있다.
        @JvmStatic var a3 = 300

        fun testMethod2(){
            println("testMethod2")
            // 일반 맴버 변수 사용
            // println("testMethod2 - a1 : $a1")
            // 정적 맴버 변수 사용
            println("testMethod2 - a2 : $a2")
        }

        @JvmStatic fun testMethod3(){
            println("testMethod3")
        }
    }

    // 일반 메서드
    fun testMethod1(){
        println("testMethod1")
        // 일반 맴버 변수 사용
        println("testMethod1 - a1 : $a1")
        // 정적 맴버 변수 사용
        println("testMethod1 - a2 : $a2")
    }
}