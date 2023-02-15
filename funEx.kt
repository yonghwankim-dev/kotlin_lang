fun main() {
    val result: String = birthdayGreeting()
    println(result)
    var result2: String = sayName("yonghwan")
    println(result2)

    println(birthdayGreeting(age = 5))
    println(birthdayGreeting("Rex", 2))
}

fun birthdayGreeting(): String {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
    return "hello"
}

fun sayName(name: String): String{
    println("Name : $name")
    return name
}

fun birthdayGreeting(name: String = "Rover", age: Int): String{
    return "Happy Birthday, $name! You are now $age years old!"
}