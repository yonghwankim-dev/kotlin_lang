package Class.abstract_interface

fun main () {
    makeFish()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim()  {
        println("swim")
    }
}


abstract class AquariumFish: AquariumAction {
    abstract val color: String

    override fun eat(): Unit = println("yum")
    override fun jump() {
        println("jump")
    }
    override fun clean() {
        println("clean")
    }
    override fun catchFish() {
        println("catchFish")
    }
}

class Shark: AquariumFish(), FishAction{
    override val color: String = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction{
    override val color: String = "gold"
    override fun eat() {
        println("eat algae")
    }
}

interface FishAction {
    fun eat()
}

