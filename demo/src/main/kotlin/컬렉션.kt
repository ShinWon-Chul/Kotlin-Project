import java.util.*

fun main() {
    //immutable
    val currencyList = listOf("달러", "유로", "원")

    // mutable
//    val mutableCurrencyList = mutableListOf<String>()
//    mutableCurrencyList.add("달러")
//    mutableCurrencyList.add("유로")
//    mutableCurrencyList.add("원")

    val mutableCurrencyList = mutableListOf<String>().apply{
        add("달러")
        add("유로")
        add("원")
    }

//    print(mutableCurrencyList)

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val muuableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2)

    // mutable map
    val mutableNumber = mutableMapOf<String, Int>()
    mutableNumber["one"] = 1
    mutableNumber["two"] = 2
    mutableNumber["three"] = 3

    // 컬렉션 빌더는 내부에선 Mutable 반환은 immutable
    val numberList: List<Int> = buildList{
        add(1)
        add(2)
        add(3)
    }


    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator()
    while (iterator.hasNext()){
        println(iterator.next())
    }
    println("========================")

    for (currency in currencyList) {
        println(currency)
    }

    println("========================")
    currencyList.forEach{
        println(it) // 람다 학습에서 자세히 설명
    }

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
//    val upperList = mutableListOf<String>()

//    for (lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }
    val upperList = lowerList.map {it.uppercase()}
    println(upperList)


    //filter
//    val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A" || upperCase == "C"){
//            filteredList.add(upperCase)
//        }
//    }

//    val filteredList = upperList.filter { it == "A" || it == "C"}

    // Filter 와 같은 체인이나 다루는 데이터가 많으면 asSequence API 사용하느게 적절하다.
    val filteredList = upperList
        .asSequence()
        .filter { it == "A" || it == "C"}
        .filter { it == "C" }
        .filter { it == "C" }
        .filter { it == "C" }
        .toList()
    println(filteredList)

}