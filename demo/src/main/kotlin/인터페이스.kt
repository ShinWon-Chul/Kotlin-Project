class Product(val name: String, val price: Int)

interface Wheel{
    fun roll()
}

interface Cart : Wheel {

    var coin: Int

    // 프로퍼티에 대한 초기값이 없어 backing field에 접근할 수 없음
    val weight : String
        get() = "20KG"
//        get() {
//            field
//        }

    //추상함수
    fun add(product: Product)

    fun rent() {
        if (coin > 0 ) {
            println("카트를 대여합니다.")
        }
    }

    override fun roll(){
        println("카트가 굴러갑니다.")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product){
        println("${product.name} 주문이 완료되었습니다.")
    }
    fun printId() = println("5678")
}

// 인터페이스는 생성자 호출이 아닌 인터페이스명만 사용하는점이 클래스 상속과 다른점
class MyCart(override var coin: Int) : Cart, Order{

    override fun add(product: Product){
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다.")

        // 주문하기
        super<Order>.add(product)
    }

    override fun printId(){
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}