class `7_LateInit` {

    // lateinit은 항상 가변변수 var로 사용해야함
    // lateinit은 ? 연산자를 사용해 nullable사용이 불가능함
    lateinit var text: String

//    fun printText() {
//        text = "안녕하세요"
//        println(text)
//    }
    fun printText() {
        text = "안녕하세요"
        // isInitialized는 클래스 내부에서만 사용가능
        if (this::text.isInitialized){
            println("초기화됨")
        }
        else{
            text = "안녕하세요"
        }
        println(text)
    }

}

fun main() {
    val test = `7_LateInit`()
    test.printText()
}