# 클래스 생성자 추가
## 클래스 정의에 생성자 추가
```kotlin
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

}
```

## 객체 생성시 생성자 사용
```kotlin
fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}
```

## 프로퍼티에 getter/setter 추가
```kotlin
var volume: Int
    get() = width * height * length / 1000
    set(value) {
        height = (value * 1000) / (width * length)
    }
```