fun main() {
    val count: Int = 2
    println(count)
    println("hello $count")
    println("hello ${count + count}")

    var cartTotal = 0
    cartTotal = 1
    cartTotal++
    println("cartTotal : $cartTotal")
    cartTotal--
    println("cartTotal : $cartTotal")
}