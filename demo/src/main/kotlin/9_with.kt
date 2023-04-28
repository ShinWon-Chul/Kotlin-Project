// run 과의 차이점은 확장함수가 아니다는점이 다름
fun main() {

    val str = "안녕하세요"

    val length : Int = with(str) {
        length
    }

    print(length)
}