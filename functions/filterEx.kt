package functions

fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { it[0] == 'p' })

    // eager
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    // lazy
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered : $filtered")

    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("---")
    println("first: ${lazyMap.first()}")
    println("---")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }
        .map {
            println("access: $it")
            it
        }
    println("---")
    println("filtered: ${lazyMap2.toList()}")

    // 람다와 고차 함수
    
    var dirtylevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtylevel))

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2}
    println(waterFilter2(dirtylevel))
    
    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    println(updateDirty(20, waterFilter))

    fun increaseDirty(start: Int) = start + 1
    println(updateDirty(15, ::increaseDirty))

    dirtylevel = updateDirty(dirtylevel){ dirtylevel -> dirtylevel + 23}
    println(dirtylevel)
}