package Class.interface_delegation

fun main() {
    val plecostomus = Plecostomus(RedColor)
    plecostomus.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor{
    val color: String
}

class Plecostomus(fishColor: FishColor = GoldColor): FishAction by PrintingFishAction("eat algae"),
                                                     FishColor by GoldColor {
}

class Shark: FishAction, FishColor {
    override val color: String = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}