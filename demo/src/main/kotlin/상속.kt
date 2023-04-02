open class Dog{
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

open class Bulldog(final override var age : Int = 0) : Dog() {
//    override var age : Int = 0

    final override fun bark(){
//        println("컹컹")
        super.bark()
    }

}

abstract class Developer {

    abstract var age: Int
    abstract fun code(language:String)

}

class BackendDeveloper(override var age: Int = 0) : Developer() {
    override fun code(language: String){
        println("I code with $language")
    }

}

fun main() {
//    val dog = Bulldog(age=2)
//    println(dog.age)
//    dog.bark()

    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")
}

