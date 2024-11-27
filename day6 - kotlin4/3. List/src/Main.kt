// 리스트 : 0부터 1식 증가하는 순서값을 가지고 객체를 관리한다.
// 배열과 다르게 관리하는 객체의 수를 줄이거나 늘릴 수 있다.
// 코틀린 list는 불변형과 가현형으로 제공된다.
// 불변형은 추가, 수정, 삭제 등이 불가능하다.

fun main(){
    // 리스트 생성
    // 불변형 리스트
    // 리스트 생성 이후 값의 추가, 수정, 삽입, 삭제 등이 불가능하다.
    val list1 = listOf(10, 20, 30, 40, 50)
    println("list1 : $list1")

    val list2 = listOf("문자열1", "문자열2", "문자열3")
    println("list2 : $list2")

    // 담기는 객체의 타입이 달라도 된다.
    val list3 = listOf(100, 11.11, "문자열", true)
    println("list3 : $list3")

    // 수정 가능한 list를 생성한다.
    // 텅 비어 있는 리스트
    val list4 = mutableListOf<Int>()
    println("list4 : $list4")
    // 생성시 관리할 객체를 지정할 수 있다.
    val list5 = mutableListOf("문자열1", "문자열2", "문자열3")
    println("list5 : $list5")

    // 비어있는 수정 불가능한 리스트
    val list6 = emptyList<Int>()
    println("list6 : $list6")

    // null이 있을 경우
    // null 값을 포함한 리스트가 생성된다.
    val list7 = listOf(10, 20, null, 40, null, 60, 70)
    println("list7 : $list7")
    // null 값이 모두 빠져버린 리스트가 생성된다.
    val list8 = listOfNotNull(10, 20, null, 40, null, 60, 70)
    println("list8 : $list8")

    // 관리하는 객체의 개수
    println("list size : ${list1.size}")

    // 관리하는 객체에 접근한다.
    println("list1.get(0) : ${list1.get(0)}")
    println("list1.get(1) : ${list1.get(1)}")
    println("list1[0] : ${list1[0]}")
    println("list1[1] : ${list1[1]}")

    // 처음 부터 끝까지 반복하면서 하나씩 사용한다.
    // 리스트가 관리하는 객체의 수 만큼 반복한다.
    // 매 반복 횟차때 마다 해당 번째의 객체를 추출하여 변수에 담아준다.
    for(item in list1){
        println("item : $item")
    }

    for(idx in list1.indices){
        println("list $idx : ${list1[idx]}")
    }

    val list9 = listOf(10, 20, 30, 10, 20, 30)

    // 지정한 객체가 앞에서 부터 몇 번째에 있는가..
    val index1 = list9.indexOf(20)
    println("index1 : $index1")

    // 지정한 객체가 뒤에서 부터 몇 번째에 있는가..
    val index2 = list9.lastIndexOf(20)
    println("index2 : $index2")

    // indexOf, lastIndexOf 모두 없는 것을 지정하면 -1을 반환한다.
    val index3 = list9.indexOf(100)
    println("index3 : $index3")

    // 일부를 발췌하여 새로운 리스트를 생성한다.
    // 순서값 1 ~ 3 - 1 까지
    val list10 = list9.subList(1, 3)
    println("list10 : $list10")

    println("------------------------------")

    // list는 관리하는 객체에 대한 변경 작업을 수행할 수 없다.
    val list20 = listOf(10, 20, 30)

    val list21 = mutableListOf(10, 20, 30)

    // 객체를 추가한다
    // 리스트 뒤에 추가된다.
    list21.add(40)
    list21.add(50)
    list21.addAll(listOf(60, 70, 80, 90, 100))
    println("list21 : $list21")

    // 삽입
    // add 메서드를 이용할 때 위치를 지정하면 그 위치에 삽입된다.
    // add(순서값, 객체) : 순서값에 해당하는 위치에 객체를
    // 삽입하고 그 이후의 객체들은 뒤로 밀린다.
    list21.add(1, 200)
    println("list21 : $list21")

    // 삽입할 데이터가 다수라면 addAll을 사용한다.
    list21.addAll(3, listOf(2000, 3000, 4000, 5000))
    println("list21 : $list21")

    // 값을 수정 한다.
    // set(순서값, 객체)
    list21.set(1, 1000)
    println("list21 : $list21")

    list21[2] = 2000
    println("list21 : $list21")

    // 제거
    // 지정한 객체를 제거하고 하나씩 당겨진다.
    list21.remove(5000)
    println("list21 : $list21")

    // 중복된 객체가 여러개 있는 객체를 지정하여 제거한다.
    list21.remove(2000)
    println("list21 : $list21")

    // 다수의 객체를 동시에 제거하고자 한다면...
    list21.removeAll(listOf(1000, 2000, 3000, 4000))
    println("list21 : $list21")

    // 위치를 지정하여 제거한다.
    list21.removeAt(1)
    println("list21 : $list21")

    // 모두 삭제
    list21.clear()
    println("list21 : $list21")

    println("------------------------------------")

    val list100 = listOf(10, 20, 30, 40, 50)

    // list가 관리하는 객체들을 가지고 있는 mutable list를 생성한다.
    val list200 = list100.toMutableList()
    list200.add(60)
    println("list200 : $list200")

    // mutable list가 관리하는 객체들을 가지고 있는 list를 생성한다.
    val list300 = list200.toList()
    // list300.add(70)
    println("list300 : $list300")
}












