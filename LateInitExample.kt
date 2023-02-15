class LateInitExample {
    lateinit var text: String

    init {
        initText()
    }

    private fun initText(){
        text = "Hell World"
    }
}

fun main(){
    val example = LateInitExample();
    println(example.text)
}