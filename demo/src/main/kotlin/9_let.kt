// 객체의 컨텍스트 내에서 코드 블록을 실행하기위해서만 존재하는 함수
// 스코프 함수의 코드 블록내부에서는 수싡다 객체의 참조로 변수명을 사용하지 않고도 객체에 접근할 수 있음.
// Null이 아닌경우 사용될 로직을 작성하고 거기에 따른 새로운 결과를 반환하고 싶을때 사용
fun main() {

    val str: String? = "안녕"

    val result: Int? = str?.let{
        println(it)

        val abc : String? = "abc"
        val def : String? = "def"
        if(!abc.isNullOrEmpty() && !def.isNullOrEmpty()){
            println("abcdef가 null 아님")
        }

        // return 키워드 없이 let함수 마지막 값은 return 값이 됨
        1234
    }

    println(result)

    // let을 사용할때 hi에서 Hello에 접근하기 위해서는 변수명을 사용해야함
    val hello = "hello"
    val hi = "hi"

    hello.let { a : String ->

        //println(a.length)

        hi.let{ b ->
            println(a.length)
            println(b.length)
        }
    }
}