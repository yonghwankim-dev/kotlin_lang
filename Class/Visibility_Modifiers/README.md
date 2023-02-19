# 접근 제어자
코틀린에서는 기본적으로 모든것(클래스, 메서드, 프로퍼티, 멤버변수)이 public 입니다.

코틀린에서 class, object, interface, constructor, function, propertiy, setter에

접근 제어자를 설정할 수 있습니다.
- public : 외부에서 전부 접근 가능
- internal : 같은 모듈안에서 접근 가능
- private : 같은 클래스 내에서만 접근 가능
- protected : private와 같으나 자손 클래스에서 접근 가능

## 멤버 변수에 setter에 private 설정
```kotlin
var volume: Int
    get() = width * height * length / 1000
    private set(value) {
        height = (value * 1000) / (width * length)
    }
```