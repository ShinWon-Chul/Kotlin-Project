//데이터를 보관하거나 전달하는 객체를 만들때 ex DTO
data class Person(val name: String, val age: Int){

}

//class Person(val name: String, val age: Int){
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        return result
//    }
//
//}


fun main() {
//    val person1 = Person(name = "tony", age = 12)
//    val person2 = Person(name = "tony", age = 12)
//    println(person1.toString())


//    println(person1 == person2) // equels 자동 생성으로 인해 ture return
//
//    val set = hashSetOf(person1)
//    println(set.contains(person2))


    //copy를 활용한 데이터 불변 객체를 손쉽게 만들 수 있음
//    val person1 = Person(name = "tony", age = 12)
//
//    val set = hashSetOf(person1)
//    println(set.contains(person1))
//    person1.name = "strange"
//    println(set.contains(person1))

//    val person1 = Person(name = "tony", age = 12)
//    val person2 = person1.copy(name= "strange")
//    println(person2)

    // component n
    val person1 = Person(name = "tony", age = 12)

    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    //구조 분해 할당
    val (name, age) = person1
    println("이름=${name}, 나이=${age}")
}
