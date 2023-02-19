package Class.Visibility_Modifiers

class Aquarium(var width: Int = 10, var length: Int = 20, var height: Int = 30) {
    var volume: Int
        get() = width * length * height / 1000
        private set(value) {
            height = (value * 1000) / (width * length)
        }

    fun printSize() {
        volume = 40 // 같은 클래스 내에서 접근 가능 (set)
        println("volume : $volume")
    }
}

fun main() {
    val myAquarium = Aquarium()
//    myAquarium.volume = 40 // 외부에서 접근 불가능, private 때문
    myAquarium.printSize()
}

