//class MyGenerics<T>(val t:T){
//
//}

// 공변성
class MyGenerics<out T>(val t:T){

}

class Bag<T> {
    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>
    ){
        to.addAll(from)
    }
}

fun main(){

    val bag = Bag<String>()
    // String이 Charsequence의 하위타입이기 때문에 반공변성으로 in 키워드로 String이 상위 개념이 됨
    bag.saveAll(mutableListOf<CharSequence>("1","2"), mutableListOf<String>("3", "4"))

    //CharSequence가 String의 상위 타입이기 때문에 out 키워드를 사용해서 공변성 구현 가능
    val generics = MyGenerics<String>("테스트")
    val charGenerics : MyGenerics<CharSequence> = generics

    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트를 제공
    // val generics = MyGenerics<String>("테스트")


//    val generics = MyGenerics("테스트") //<String> 타입 아규먼트는 생략 가능
//
//    // 변수의 타입에 제네릭을 사용한 경우
//    val list1 : MutableList<String> = mutableListOf()
//    // 타입아규먼트를 생성자에 추가
//    val list2 = mutableListOf<String>()
//
//    val list3 : List<*> = listOf<String>("테스트") // 스타 프로젝션
//    val list4 : List<*> = listOf<Int>(1,2,3,4)

    // 공변성 파라미터화된 타입이 서로 어떤 관계에 있는지 설명하는 개념 - 공변성, 반공변성, 무공변성
    // PECS는 Producer-Extends, Consumer-Super
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 In
    // 무공변성은 in이나 out을 사용하지 않았을경우

}