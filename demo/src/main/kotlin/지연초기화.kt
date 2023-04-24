class HelloBot{

    // val과 같이 항상 불변 프로퍼티에 적용 가능 by lazy와 같은 지연 초기화는
    // var greeting: String? = null

    // by lazy를 사용하여 불변을 유지하며 지연 초기화 가능
    // 멀티스레드 환경에서도 안전하게 동작하도록 설계 되어있음
    val greeting: String by lazy {
        println("초기화 로직 수행")
        getHello()
    }

    // LazyThreadSafetyMode.NONE 초기화 로직이 여러번 호출될 수 있음 (default = SYNCHRONIZED 스레드 동기화)
    // 멀티 쓰레드가 아닌경우 동기화가 오버헤드가 될수 있음
    // 멀티 쓰레드 환경이어도 동기화가 필요하지 않은경우 PUBLICATION 모드 사용
//    val greeting: String by lazy(LazyThreadSafetyMode.NONE) {
//        getHello()
//    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()
//    helloBot.greeting = getHello()

    // 멀티스레드 환경에서도 안전하게 동작하도록 설계 되어있음
    for ( i in 1..5){
        Thread{
            helloBot.sayHello()
        }.start()
    }
    helloBot.sayHello()
}