# 싱글톤, enums, sealed 클래스
## 싱글톤 클래스 생성
```kotlin
object GoldColor : FishColor {
   override val color = "gold"
}
```

## enum 생성
```kotlin
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun main() {
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}
```

## sealed 클래스 생성
`sealed class`는 특별한 종류의 클래스로, 그 클래스의 하위 클래스들을 제한하는데 사용됩니다.

`sealed class`는 추상 클래스와 유사하게 도앚ㄱ하지만 하위 클래스가 제한됩니다.

```kotlin
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
   return when(seal) {
       is Walrus -> "walrus"
       is SeaLion -> "sea lion"
   }
}
```