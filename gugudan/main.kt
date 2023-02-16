package gugudan

import java.util.regex.Pattern

fun main() {
    print("단 시작 종료 > ")
    val text = readLine() ?: ""

    if (!validateInput(text)){
        println("입력이 잘못되었습니다. : $text")
        return
    }

    val inputs: List<String> = text?.split(" ") ?: emptyList()
    val dan: Int = inputs[0].toInt()
    val start: Int = inputs[1].toInt()
    val end: Int = inputs[2].toInt()

    for (i in start..end) println("$dan * $i = ${dan*i}")
}

fun validateInput(text: String): Boolean{
    val INPUT_FORMAT_PATTERN: Pattern = Pattern.compile("\\d \\d \\d")
    return INPUT_FORMAT_PATTERN.matcher(text).matches()
}