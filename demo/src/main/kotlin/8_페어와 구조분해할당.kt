// f((1, 3)) = 1 + 3 = 4
// f(1, 3) = 1 + 3 = 4

// gatter, setter, canonical methods(equlas, hashCode, toString)를 알아서 생성해주는 data class
// equlas(other: Any?): Boolean - 이 메소드는 참조가 아니라 데이터 클래스 간 값의 일치를 비교한다.
// hashCode(): Int - 해쉬코드는 인스턴스의 숫자 표현이다. hashCode()가 같은 인스턴스에서 여러 번 호출될 때 항상 동일한 값을 반환해야 한다. equals()로 비교할 때 참을 반환하는 두 인스턴스는 같은 hashCode()를 가져야만 한다.
// toString(): String - 인스턴스의 문자열 표현이다. 데이터 클래스는 이를 멤버 변수의 값을 나열하도록 자동으로 재정의 한다.
// 코틀린에서는 Pair라는 클래스를 제공해서 Tuple과 같은 클래스를 작성할 필요가 없다.

// data class Tuple(val a: Int, val b: Int)
// fun plus(tuple: Tuple) = tuple.a + tuple.b

fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    // println(plus(1, 3))
    val plus = plus(Pair(1, 3))
    println(plus)

    val pair = Pair("A", 1)
    val newPair = pair.copy(first = "B")
    println(newPair)

    // 두번째 요소 가져오기
    val second = newPair.component2()
    println(second)

    // toList로 immutable 형태의 불변리스트 변환
    val list = newPair.toList()
    println(list)


    // 3개의 요소를 가지는 튜플인 Triple 제공 (불변)
    val triple = Triple("A", "B", "C")
    println(triple)
    triple.first
    triple.second
    val newTriple = triple.copy(third = "D")
    println(newTriple)

    println(newTriple.component3())

    // 구조분해 할당
    // val (a, b, c) = newTriple
    val (a: String, b: String, c: String) = newTriple
    println("$a, $b, $c")

    // 리스트도 트리플이나 페어처럼 component1~5() 함수를 가지고 있음
    val list3 = newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")

    // map에서 to 키워드를 Pair로 치환가능
    // val map = mutableMapOf("신원철" to "개발자")
    val map = mutableMapOf(Pair("신원철","개발자"))
    for ((key, value) in map ) {
        println("${key}의 직업은 $value")
    }
}