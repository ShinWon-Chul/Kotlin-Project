// 이넘 클래스도 클래스 이기 때문에 프로퍼티, 함수가 존재 가능
enum class PaymentStatus(val label: String) : Payable{
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true
    },
    PAID("지급완료") {
        override fun isPayable(): Boolean = false
    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean = false
    }; //상수 뒤에 함수를 정의할 경우 세미콜론을 붙여줘야함

//    abstract fun isPayable(): Boolean
}

interface Payable{
    fun isPayable(): Boolean
}

fun main() {
//    print(PaymentStatus.UNPAID.isPayable())
//    if (PaymentStatus.UNPAID.isPayable()){
//        println("결제 가능 상태")
//    }
//    val paymentstatus = PaymentStatus.valueOf("PAID")
//    println(paymentstatus.label)
//
//    if (paymentstatus == PaymentStatus.PAID){
//        println("결제 완료 상태")
//    }

    for (status in PaymentStatus.values()){
        println("${status}(${status.label})")
    }

    for (status in PaymentStatus.values()){
        println("[${status.name}](${status.label}) : ${status.ordinal}")
    }
}