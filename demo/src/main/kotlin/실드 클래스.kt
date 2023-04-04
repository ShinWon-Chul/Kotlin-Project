//sealed 클래스의 하위 클래스는 같은 패키지/모듈 안에 속해있어야한다.
//when 식에서 버그 방지등 유용하게 사용할 수 있고, 구조를 잡을때도 유용하게 사용할 수 있다.
sealed class Developer{

    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String){
        println("저는 백엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {

    override fun code(language: String){
        println("저는 프론트엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

object OtherDeveloper : Developer() {
    override val name : String = "익명"

    override fun code(language: String){

    }
}

data class AndroidDevleoper(override val name: String) : Developer(){
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다. ${language}를 사용합니다.")
    }
}

object DeveloperPool{
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer){
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDevleoper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지않는 개발자종류입니다.")
        //sealed 클래스를 사용하면 하위 클래스가 2가지 밖에 없다는것을 컴파일 시점에 판단가능
        //하지만 when 식에서 모든 하위클래스에 대한 처리를 해주어야함
        //개발자가 실수로 하위클래스에 대한 처리를 빼먹음으로서 생시는 버그를 줄일수 있음,.
//        else -> {
//            println("지원하지않는 개발자입니다.")
//        }
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name="카즈야")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDevleoper(name= "안드로")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
    println(DeveloperPool.get("안드로"))
}