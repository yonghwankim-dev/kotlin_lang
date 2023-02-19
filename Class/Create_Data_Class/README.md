# data 클래스 생성
코틀린에서 data class는 데이터를 다루기 위한 클래스를 간단하게 정의할 수 있는 기능을 제공합니다.

data class를 사용하면 컴파일러가 equals(), hashCode(), toString()과 같은 일반적으로

필요한 메서드를 자동으로 생성해주기 때문에 클래스를 작성하는데 드는 노력을 줄일 수 있습니다.

## data 클래스 특징
- 프로퍼티에 대한 getter/setter 자동 생성
- equals(), hashCode() 메서드 자동 생성
- toString() 메서드 자동 생성
- componentN() 함수를 자동으로 새성함. 이 함수는 객체의 N번째 프로퍼티를 반환함

data 클래스는 주로 DTO나 VO 등의 용도로 사용됩니다.


## data 클래스 생성
```kotlin
data class Decoration(val rocks: String) {
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)
}
```

## data 클래스 destructing
```kotlin
// Here is a data class with 3 properties.
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

fun makeDecorations() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

// Assign all properties to variables.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}
```