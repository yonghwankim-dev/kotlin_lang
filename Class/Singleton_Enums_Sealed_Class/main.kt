package Class.Singleton_Enums_Sealed_Class


fun main() {
    println(Color.RED)
    println(Color.RED.rgb)
    println(Color.RED.name)
    println(Color.RED.ordinal)
}

interface FishColor{
    val color: String
}

// 싱글톤 생성
object GoldColor: FishColor {
    override val color: String = "gold"
}

// enum 생성
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "Walrus"
        is SeaLion -> "SeaLion"
    }
}