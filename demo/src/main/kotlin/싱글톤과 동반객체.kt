import java.time.LocalDateTime
import javax.swing.text.DefaultFormatter
// 싱극톤 패턴 - 객체의 인스턴스를 하나만 만들어서 계속 재사용하는 패턴
// 객체 선언 키워드를 통해서 싱글톤 객체 생성
//object Singleton{
//
//    val a = 1234
//    fun printA() = println(a)
//}
//
//fun main() {
//    println(Singleton.a)
//    Singleton.printA()
//}

//object 키워드로 생성된 싱글톤 객체는 유틸리티 클래스에서 많이 사용된다. 또는 상수들의 집합으로서 object 클래스를 사용할 수 있다.
//object DatetimeUtils{
//    val now : LocalDateTime
//        get() = LocalDateTime.now()
//
//    //상수 선언
//    const val DEFAULT_FORMAT = "YYYY-MM-DD"
//
//    fun same(a : LocalDateTime, b : LocalDateTime) : Boolean{
//        return a == b
//    }
//}
//
//fun main() {
//    println(DatetimeUtils.now)
//    println(DatetimeUtils.now)
//    println(DatetimeUtils.now)
//
//    println(DatetimeUtils.DEFAULT_FORMAT)
//
//    val now = LocalDateTime.now()
//    println(DatetimeUtils.same(now, now))
//
//}

//동반객첷
class MyClass{

    private constructor()

    companion object{
        val a = 1234

        fun newInstance() = MyClass()
    }

}

fun main() {
    println(MyClass.a)
    println(MyClass.newInstance())
}