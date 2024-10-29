fun main() {

    /** Interface
     * -
     */

    val obj1 = TestClass1()
    val obj2 = TestClass2()
    testFun1(obj1)
    testFun2(obj2)

    println("------------------------------")

    val obj3 = TestClass3()
    val obj4 = TestClass4()
    testFun3(obj3)
    testFun4(obj4)

    println("------------------------------")

    val obj5 = TestClass5()
    testFun3(obj5)
    testFun4(obj5)

    println("-------------예제---------------")


}

abstract class AbstractClass1 {
    abstract fun abstractMethod1()
}

abstract class AbstractClass2 {
    abstract fun abstractMethod2()
}

fun testFun1(obj: AbstractClass1) {
    obj.abstractMethod1()
}

fun testFun2(obj: AbstractClass2) {
    obj.abstractMethod2()
}

class TestClass1 : AbstractClass1() {
    override fun abstractMethod1() {
        println("TestClass1의 abstractMethod1()")
    }
}

class TestClass2 : AbstractClass2() {
    override fun abstractMethod2() {
        println("TestClass2의 abstractMethod2()")
    }
}

interface Inter1 {
    fun inter1method1() {
        println("Inter1의 inter1method1()")
    }
    fun inter1method2()
}

interface Inter2 {
    fun inter2method1() {
        println("Inter2의 inter1method1()")
    }
    fun inter2method2()
}

fun testFun3(obj: Inter1) {
    obj.inter1method1()
    obj.inter1method2()
}

fun testFun4(obj: Inter2) {
    obj.inter2method1()
    obj.inter2method2()
}

class TestClass3 : Inter1 {
    override fun inter1method2() {
        println("TestClass3의 inter1method2()")
    }
}

class TestClass4 : Inter2 {
    override fun inter2method2() {
        println("TestClass4의 inter2method2()")
    }
}

class TestClass5 : Inter1, Inter2 {
    override fun inter1method2() {
        println("TestClass5의 inter1method2()")
    }

    override fun inter2method2() {
        println("TestClass5의 inter2method2()")
    }
}