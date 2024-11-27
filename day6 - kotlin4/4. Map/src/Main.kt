// map : 객체를 이름을 통해 관리하는 요소
// 순서에 대한 개념은 없다.
fun main(){
    // 이름 to 객체 형태로 지정한다.
    // 수정 불가능한 map
    val map1 = mapOf("key1" to 10, "key2" to 20, "key3" to 30)
    println("map1 : $map1")

    // 이름은 문자열이 아니어도 된다.
    val map2 = mapOf(10 to 11.11, 20 to 22.22, 30 to 33.33)
    println("map2 : $map2")

    // 수정 가능한 맵
    val map3 = mutableMapOf("key1" to 10, "key2" to 20, "key3" to 30)
    println("map3 : $map3")

    // 다양한 타입을 사용할 수 있다.
    val map4 = mapOf("key1" to 10, 22.22 to "문자열", "key3" to 11.11)
    println("map4 : $map4")

    // 제네릭을 설정할 수도 있다.
    // map은 제네릭을 설정하지 않아도 되지만 딱 한 경우에는 무조건 설정해야 한다.
    // <이름으로 사용할 객체의 클래스 타입, 저장할 객체의 클래스 타입>
    val map5 = mapOf<String, Int>("key1" to 10, "key2" to 20, "key3" to 30)
    println("map5 : $map5")

    val map6 = mapOf<String, Any>("key1" to 10, "key2" to 11.11, "key3" to "문자열")
    println("map6 : $map6")

    // 텅 비어 있는 map을 만들 때는 반드시 제네릭을 설정해야 한다.
    // 수정 불가능한 맵은 텅 비어있는 맵을 만드는 것이 의미가 없지만
    // 수정 가능한 맵은 나중에 객체를 추가할 수 있기 때문에 의미가 있다.
    val map7 = mapOf<String, Int>()
    val map8 = mutableMapOf<String, Int>()
    println("map7 : $map7")
    println("map8 : $map8")

    println("---------------------------------------")

    val map9 = mapOf("key1" to 10, "key2" to 20, "key3" to 30)
    val map10 = mutableMapOf("key1" to 10, "key2" to 20, "key3" to 30)

    // 관리하는 객체를 가지고 온다.
    println("map9 key1 : ${map9.get("key1")}")
    println("map10 key1 : ${map10.get("key1")}")

    println("map9 key2 : ${map9["key2"]}")
    println("map10 key2 : ${map10["key2"]}")

    println("map9 key100 : ${map9["key100"]}")
    println("map10 key100 : ${map10["key100"]}")

    println("---------------------------------------------")

    // 맵이 관리하는 객체의 개수
    println("map1 size : ${map1.size}")
    // 객체를 저장할 때 사용한 이름들을 가져온다.
    println("map1 keys : ${map1.keys}")
    // 저장되어 있는 객체들을 가져온다.
    println("map1 values : ${map1.values}")

    // 지정한 이름으로 저장된 객체가 있는지 확인한다.
    val chk1 = map1.containsKey("key1")
    val chk2 = map1.containsKey("key100")
    println("chk1 : $chk1")
    println("chk2 : $chk2")

    // 지정한 객체가 저장되어 있는지 확인한다
    val chk3 = map1.containsValue(10)
    val chk4 = map1.containsValue(1000)
    println("chk3 : $chk3")
    println("chk4 : $chk4")

    println("-------------------------------")

    val map12 = mutableMapOf("a1" to 10, "a2" to 20)
    println("map12 : $map12")

    // 객체를 추가한다.
    map12.put("a3", 30)
    println("map12 : $map12")

    // 없는 이름을 이용하여 객체를 넣어주는 작업을 하면
    // 객체가 추가된다.
    map12["a4"] = 40
    println("map12 : $map12")

    // 수정
    // 있는 이름으로 객체를 넣어준다.
    map12["a4"] = 400
    println("map12 : $map12")

    // 삭제
    map12.remove("a4")
    println("map12 : $map12")

    println("------------------------------------")

    val map13 = mapOf("a1" to 10, "a2" to 20, "a3" to 30)

    // 수정 불가능한 맵을 통해 수정 가능한 맵을 생성한다.
    val map14 = map13.toMutableMap()
    map14["a4"] = 40
    println("map14 : $map14")

    // 수정 가능한 맵을 통해 수정 불가능한 맵을 생성한다.
    val map15 = map14.toMap()
    // map15["a5"] = 50
    println("map15 : $map15")
}









