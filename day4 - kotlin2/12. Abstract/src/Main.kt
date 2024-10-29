fun main() {

    /** 추상 클래스 Abstract
     * -
     */

    val obj1 = Super1()
    testFun1(obj1)

    val obj2 = Sub1()
    testFun1(obj2)

}

open class Super1 {
    fun method1() {
        println("Super1 클래스의 method1()")
    }

    open fun method2() {
        println("Super1 클래스의 method2()")
    }
}

class Sub1 : Super1() {
    override fun method2() {
        println("Sub1 클래스의 method2()")
    }
}

fun testFun1(ob1: Super1) {
    ob1.method1()
    ob1.method2()
}

abstract class Super2 {
    fun method1() {
        println("Super2 클래스의 method1()")
    }

    abstract fun method2()
}

class Sub2 : Super2() {
    override fun method2() {
        println("Sub2 클래스의 method2()")
    }
}