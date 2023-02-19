# 서브 클래스
## 서브 클래스 허용 설정
코틀린에서는 기본적으로 서브 클래스화 시킬 수 없습니다.

서브 클래스화 시키기 위해서는 `open` 키워드를 사용하여 서브 클래스를 허용하게 할 수 있습니다.

```kotlin
open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }
```

## 서브 클래스 만들기
```kotlin
class TowerTank (override var height: Int, var diameter: Int): 
    Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
    // ellipse area = π * r1 * r2
    get() = (width/2 * length/2 * height / 1000 * PI).toInt()
    set(value) {
        height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
    }

    override var water = volume * 0.8
    override val shape = "cylinder"
}
```