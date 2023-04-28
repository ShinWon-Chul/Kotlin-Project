
fun main() {

    // run let with는 함수 블록의 마지막이 반환타입인 반면 컨텍스트 객체가 반환됨
    // 컨텍스트 객체의 변수를 초기화 하는 용도로 사용
    val client: DatabaseClient = DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }
//    print(client)
    val connected = client.connect()
    println(connected)

//    DatabaseClient().apply {
//        url = "localhost:3306"
//        username = "mysql"
//        password = "1234"
//    }.connect()
//        .run { println(this) }


}