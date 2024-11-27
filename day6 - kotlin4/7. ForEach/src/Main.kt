fun main(){
    // 배열
    val array1 = arrayOf(10, 20, 30, 40, 50)

    for(v1 in array1){
        println("array1 v1 : $v1")
    }

    array1.forEach {
        println("array1 it : $it")
    }

    array1.forEachIndexed { index, i ->
        println("array1 index : $index , value : $i")
    }

    println("----------------------------------------")

    // list
    val list1 = listOf(10, 20, 30, 40, 50)

    list1.forEach {
        println("list1 it : $it")
    }

    list1.forEachIndexed { index, i ->
        println("list1 index : $index , value : $i")
    }

    println("-------------------------------")

    val set1 = setOf(10, 20, 30, 40, 50)

    set1.forEach {
        println("set1 it : $it")
    }

    set1.forEachIndexed { index, i ->
        println("set1 index : $index , i : $i")
    }

    println("-----------------------------")

    val map1 = mapOf("a1" to 10, "a2" to 20)

    map1.forEach { t, u ->
        println("t : $t , u : $u")
    }

    map1.forEach {
        println("key : ${it.key}, value : ${it.value}")
    }
}








