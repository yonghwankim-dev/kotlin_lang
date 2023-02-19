# 클래스 생성
## 클래스에 속성 생성
```kotlin
class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
}
```
- var 타입으로 선언시 속성 값을 변경할 수 있음
- val 타입으로 선언ㅅ 속성 값을 변경할 수 없음

## 클래스에 메서드 생성
```kotlin
class Aquarium {
    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }
}
```

## 클래스의 인스턴스 생성
```kotlin
val myAquarium = Aquarium()
```

