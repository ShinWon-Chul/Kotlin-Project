// 코틀린 화장함수는 앞에 확장에 대상에 해당하는 클래스를 적어주고 뒤에 변수를 선언

// String 의 0 번째를 char로 리턴하는 확장함수
fun String.first() : Char {
    // 리시버, 수신자 객체 this 확장에 해당하는 클래스가 첫번째 인자로 들어가게 됨
    return this[0]
}

fun String.addFirst(char : Char) : String{
    return char + this.substring(0)
}

// 확장함수는 동일한 시그니처가 있는 경우 맴버가 우선이 됨
// 확장함수 사용중 라이브러리에 동일한 시그니처를 가지는 매서드가 추가가 되면 의도치 않은 버그가 생길수 있음
class MyExample {
    fun printMessage() = println("클래스 출력")
}
fun MyExample.printMessage() = println("확장 출력")
fun MyExample.printMessage(message:String) = println(message)
fun MyExample?.printNullOrNotNull(){
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {
    var myExample: MyExample? = null

    // 함수 내부에서 null처리를 하고 있기때문에 myExample?.printNullOrNotNull() 와 같이 ?(안전연산자가 필요없음)
    myExample.printNullOrNotNull()


    myExample = MyExample()
    myExample.printNullOrNotNull()
//    println("ABCD".first())
//
//    println("ABCD".addFirst('Z'))
//    MyExample().printMessage("확장 출력") // "클래스 출력" 이 출력됨
}