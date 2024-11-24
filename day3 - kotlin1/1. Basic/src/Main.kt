import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // 한 줄 주석
    // 한 줄 주석 윈도우 단축키(컨트롤 + /), 맥 단축키(커맨드 + /, 보통 윈도우에서 컨트롤은 맥에서 커맨드에 해당한다.)

//    한 줄씩 주석. 한꺼번에도 가능
//    한 줄씩 주석. 한꺼번에도 가능
//    한 줄씩 주석. 한꺼번에도 가능
//    한 줄씩 주석. 한꺼번에도 가능
//    한 줄씩 주석. 한꺼번에도 가능

    /* 여러 줄 주석
    * 하나
    * 둘
    * 셋
    * 넷
    * */

    /*1
    2
    3
    4*/

    /** 문서 주석 : "/ * *" 입력 후 제목 입력 후 엔터 또는 그냥 엔터
     * 첫 번째 행
     * 두 번째 행
     */

    print("안녕하세요") // 콘솔에 개행이 안됨
    print("안녕하세요")
    print("안녕하세요")

    println("안녕하세요")
    println("안녕하세요")
    println("안녕하세요")

    println("세미콜론 있음");
    println("세미콜론 없음")
    println("코틀린에서는 세미콜론 없는 게 정석")

    /** 입력 관련
     * 다양한 방법으로 입력을 받을 수 있다.
     * Scanner.nextInt(), Scanner.next() : 정수 입력 또는 문자열 입력
     * readLine() : 문자열 입력
     */

    println("문자열을 입력하세요:")
    val input = readLine() // 입력을 문자열로 받음
    println("입력한 값: $input")

    val scanner = Scanner(System.`in`) // `in`은 예약어이므로 백틱으로 감쌉니다.

    println("문자열을 입력하세요:")
    val line = scanner.nextLine()
    println("입력한 문자열: $line")

    println("숫자를 입력하세요:")
    val number = scanner.nextInt() // 정수 입력 받기
    println("입력한 숫자: $number")

    println("문자열을 입력하세요:")
    val string = scanner.next()
    println("입력한 문자열: $string")

    println("논리값을 입력하세요:")
    val boolean = scanner.nextBoolean()
    println("입력한 논리값: $boolean") // 대소문자 구분 없이 true, false만 입력 가능

    /** Scanner.next() VS readLine()
     *
     * Scanner.next()
     * - 입력 단위: 공백(스페이스, 탭, 엔터 등)으로 구분된 단어 단위로 입력을 받습니다.
     * - 종료 시점: 공백 문자를 만날 때까지 입력을 읽습니다. 예를 들어, "Hello World"를 입력하면 next()는 "Hello"를 반환합니다.
     *
     * readLine()
     * - 입력 단위: 한 줄 전체를 읽어 문자열로 반환합니다. 즉, 사용자가 입력한 한 줄을 통째로 반환하며, 줄바꿈(Enter)을 만나면 입력이 종료됩니다.
     * - 종료 시점: 사용자가 Enter를 누를 때까지 모든 문자를 읽어들입니다.
     */

    /** 문자열 관련
     * - 문자열은 배열처럼 사용가능
     */
    // 문자열 해당 인덱스에 있는 문자 구하기
//    val a = "abcde"
//    println(a[3]) // index of 0: a, 1: b, 2: c, 3: d, 4: e

}