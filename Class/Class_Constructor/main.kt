package Class.Class_Constructor

fun main() {
    buildAquarium()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()

    // height과 length를 기본값으로 생성
    val myAquarium2 = Aquarium(width = 25)
    myAquarium2.printSize()

    // width을 기본값으로 생성
    val myAquarium3 = Aquarium(length = 110, height = 35)
    myAquarium3.printSize()

    // 모든 속성 명시하여 생성
    val myAquarium4 = Aquarium(width = 25, length = 110, height = 35)
    myAquarium4.printSize()

    val myAquarium5 = Aquarium(numberOfFish = 29)
    myAquarium5.printSize()

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
}

class Aquarium(
    var width: Int = 20,
    var length: Int = 100,
    var height: Int = 40
) {
    var volume: Int
        get() = width * length * height / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    init {
        println("aquarium initializing")
    }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm " +
        "Length: $length cm " +
        "Height: $height cm")
        println("Volume: $volume l")
    }
}
