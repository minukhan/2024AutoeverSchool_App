// set : 객체를 관리하는 위한 이름이나 순서가 없다.
// 특정 객체를 지칭하여 가져오는 것이 불가능하다.
// 중복된 객체를 담을 수 없다.
// 집합 연산을 할 수 있다.

fun main(){
    // 수정 불가능한 set
    val set1 = setOf(1, 5, 10, 1, 5, 10)
    println("set1 : $set1")

    // 수정 가능한 set
    val set2 = mutableSetOf(1, 5, 10, 1, 5, 10)
    println("set2 : $set2")

    // 텅비어 있는 set
    val set3 = setOf<Int>()
    val set4 = mutableSetOf<Int>()

    println("----------------------------------")

    // set에서 관리하는 객체를 가져온다.
    // println("set1 0 : ${set1[0]}")
    // println("ste1 1 : ${set1.get(1)}")

    // set 은 이름이나 순서로 관리하는 요소가 아니기 때문에
    // 특정 객체를 지칭할 수 없다.
    // for 문을 통해 처음부터 끝까지 순회하며 가져 와야 한다.
    for(item in set1){
        println("set1 : $item")
    }

    println("----------------------------------")

    // set이 관리하는 객체의 개수
    println("set1 size : ${set1.size}")

    println("----------------------------------")

    // 수정 가능한 set을 만든다.
    val set5 = mutableSetOf<Int>()
    println("set5 : $set5")
    // 객체를 추가한다.
    set5.add(10)
    set5.add(20)
    set5.addAll(listOf(30, 40, 50))
    println("set5 : $set5")

    // 이미 있는 객체를 추가한다.
    set5.add(20)
    println("set5 : $set5")

    // 다수의 객체를 추가한다.
    // 추가하는 객체의 일부는 이미 있는 경우
    set5.addAll(listOf(40, 50, 60, 70))
    println("set5 : $set5")

    // 제거
    // 제거할 객체를 지정하여 제거한다.
    set5.remove(30)
    println("set5 : $set5")

    println("----------------------------------")

    val set6 = setOf(10, 20, 30)
    println("set6 : $set6")

    // 수정 불가능한 set을 통해 수정 가능한 set을 생성한다.
    val set7 = set6.toMutableSet()
    set7.add(40)
    println("set7 : $set7")

    // 수정 가능한 set을 통해 수정 불가능한 set을 생성한다.
    val set8 = set7.toSet()
    // set8.add(50)
    println("set8 : $set8")

    // set 혹은 mutableSet을 통해 list를 생성한다.
    val list1 = set8.toList()
    val list2 = set8.toMutableList()
    println("list1 : $list1")
    println("list2 : $list2")

    // list를 통해 set을 생성한다.
    val set9 = list1.toSet()
    val set10 = list1.toMutableSet()
    println("set9 : $set9")
    println("set10 : $set10")

    println("---------------------------------")

    // 집합연산
    val set11 = setOf(1, 2, 3, 4)
    val set12 = setOf(3, 4, 5, 6)

    // 합집합
    val set13 = set11.union(set12)
    println("set13 : $set13")

    // 차집합
    val set14 = set11.subtract(set12)
    println("set14 : $set14")

    // 교집합
    val set15 = set11.intersect(set12)
    println("set15 : $set15")
}








