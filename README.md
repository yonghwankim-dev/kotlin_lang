## 학습목표
- [ ] [ConstraintLayout](#ConstraintLayout)
- [ ] viewBinding
- [x] [코틀린 코딩 컨벤션](#코틀린-코딩-컨벤션)
- [x] [코틀린 변수](#코틀린-변수)
- [x] [변수값 변경](#변수값-변경)
- [x] [주석](#주석)
- [x] [함수 정의 및 호출](#함수-정의-및-호출)
- [x] [함수 매개변수의 기본값](#함수-매개변수의-기본값)
- [x] [lateinit](#lateinit)
- [x] [ActivityMainBinding](#ActivityMainBinding)
- [ ] [Intent](#Intent)

## ConstraintLayout
- 유동적인 방법으로 위치와 크기를 변경할 수 있는 레이아웃
- Constraint 타입 종류
  - Relative positioning
  - Margins
  - Centering positioning
  - Circular positioning
  - Visibility behavior
  - Dimension constraints
  - Chains
  - Virtual Helpers objects
  - Optimizer

### Relative positioning
ConstraintLayout에서 기본적인 블록 레이아웃을 생성하는 것 중 하나입니다.

Relative positioning은 제약 조건을 통해서 지정된 위젯을 다른 위젯과 비교하여 배치할 수 있습니다.

예를 들어 위젯을 수직 또는 수평 방향으로 제약을 설정할 수 있습니다.
- 수평(Horizontal) 제약 : left, right, start, end
- 수직(Vertical) 제약 : top, bottom, text baseline

예를 들어 버튼 A의 오른쪽에 버튼 B를 위치시키기 위해서 다음과 같이 코드로 표현할 수 있습니다.
```xml
        <Button android:id="@+id/buttonA" ... />
        <Button android:id="@+id/buttonB" ...
                app:layout_constraintLeft_toRightOf="@+id/buttonA" />  
```

### layout_constraint 종류
- layout_constraintLeft_toLeftOf
- layout_constraintLeft_toRightOf
- layout_constraintRight_toLeftOf
- layout_constraintRight_toRightOf
- layout_constraintTop_toTopOf
- layout_constraintTop_toBottomOf
- layout_constraintBottom_toTopOf
- layout_constraintBottom_toBottomOf
- layout_constraintBaseline_toBaselineOf
- layout_constraintStart_toEndOf
- layout_constraintStart_toStartOf
- layout_constraintEnd_toStartOf
- layout_constraintEnd_toEndOf

layout_constraint들은 또다른 위젯의 id를 가질수 있거나 parent를 가질 수 있습니다.
```xml
        <Button android:id="@+id/buttonB" ...
                app:layout_constraintLeft_toLeftOf="parent" />
```

### layout_margin
- android:layout_marginStart
- android:layout_marginEnd
- android:layout_marginLeft
- android:layout_marginTop
- android:layout_marginRight
- android:layout_marginBottom
- layout_marginBaseline

layout_margin 값으로 0이상의 값을 가집니다. 단위는 Dimension입니다.

## viewBinding
viewBinding을 사용하면 뷰와 상호작용하는 코드를 쉽게 작성할 수 있습니다.

### viewBinding 설정
build.gradle
```
android {
        ...
        viewBinding {
            enabled = true
        }
    }
    
```

결합 클래스를 생성하는 동안 레이아웃 파일 무시
```
<LinearLayout
            ...
            tools:viewBindingIgnore="true" >
        ...
    </LinearLayout>
```

### viewBinding 사용
모듈에 뷰 결합을 사용하도록 설정되면 모듈에 포함된 각 XML 레이아웃 파일의 결합 클래스가 생성됩니다. 각 결합 클래스에는 루트 뷰 및 ID가 있는 모든 뷰의 참조가 포함됩니다. 결합 클래스의 이름은 XML 파일의 이름을 카멜 표기법으로 변환하고 끝에 'Binding'을 추가하여 생성됩니다.

예를 들어 레이아웃 파일 이름이 result_profile.xml인 경우 다음과 같습니다.
```
<LinearLayout ... >
        <TextView android:id="@+id/name" />
        <ImageView android:cropToPadding="true" />
        <Button android:id="@+id/button"
            android:background="@drawable/rounded_button" />
    </LinearLayout>
```

생성된 결합 클래스 이름은 ResultProfileBinding이 됩니다. 이 클래스에는 name이라는 TextView와 button이라는 Button 등 두 필드가 있습니다. 레이아웃의 ImageView에는 ID가 없으므로 결합 클래스에 참조가 없습니다.

또한 모든 결합 클래스에는 상응하는 레이아웃 파일의 루트 뷰에 관한 직접 참조를 제공하는 getRoot() 메서드가 포함됩니다. 이 예에서는 ResultProfileBinding 클래스의 getRoot() 메서드가 LinearLayout 루트 뷰를 반환합니다.

### 활동에서 뷰 결합 사용
활동에 사용할 결합 클래스 인스턴스를 설정하려면 활동의 onCreate() 메서드에서 다음 단계를 따릅니다.

1. 생성된 결합 클래스에 포함된 정적 inflate() 메서드를 호출합니다. 그러면 활동에서 사용할 결합 클래스 인스턴스가 생성됩니다.
2. getRoot() 메서드를 호출하거나 Kotlin 속성 구문을 사용하여 루트 뷰 참조를 가져옵니다.
3. 루트 뷰를 setContentView()에 전달하여 화면상의 활성 뷰로 만듭니다.

```
    private lateinit var binding: ResultProfileBinding

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        binding = ResultProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    
```

이제 결합 클래스 인스턴스를 사용하여 뷰를 참조할 수 있습니다.

```
    binding.name.text = viewModel.name
    binding.button.setOnClickListener { viewModel.userClicked() }
```


## 코틀린 코딩 컨벤션
### 코틀린 함수 코딩 컨벤션
- 함수 이름 카멜 표기법, 동사 또는 동사구
- 각 명령어는 한줄에 하나씩
- 여는 중괄호는 함수가 시작되는 줄의 끝에 표시해야함
- 여는 중괄호 앞에는 공백이 하나 있어야함
- 함수 본문 들여쓰기 단위는 4칸 공백, Tab으로 들여쓰기 하지마라, 스페이스를 이용하라
- 닫는 중괄호는 함수 본문의 마지막 코드 줄 뒤 자체줄에 있어야함. 닫는 중괄호는 함수 시작 부분에 있는 fun 키워드와 정렬되어야함
```kotlin
fun main() {
    println("hello world")
}
```

### 코틀린 변수 코딩 컨벤션
- 변수 이름은 카멜 표기법, 소문자로 시작
- 데이터 타입 정의시 콜론 뒤에 공백이 있어야함
- 할당, 덧셈, 뺄셈, 곱셈, 나눗셈 연산자 등과 같은 연산자 앞뒤에 공백이 있어야함
```kotlin
var pet = "bird"
var sum = 1 + 2
```


## 코틀린 변수
- val name: datatype = value
  - ex) val count: Int = 2
  - ex) val name: String = "yonghwan"
- 변수 데이터 타입 유형
  - Int
  - String
  - Double
  - Float
  - Boolean
- 문자열 템플릿 ($)
```kotlin
fun main() {
    val count: Int = 2
    println("You have $count unread messages")
}
```
- 데이터타입 추론
  - 코틀린 컴파일러는 value값의 타입에 따라서 변수의 타입을 추론할 수 있음
```kotlin
val count = 2
```

## 변수값 변경
- val 키워드 : 변수 값이 변경되지 않음
- var 키워드 : 변수 값이 변경됨
```kotlin
var a = 1
a = 2
```

- 증감 연산자 (++, --)
```kotlin
var a = 1
a++
a--
println(a)
```

## 주석
- // 
- /* */

## 함수 정의 및 호출
- fun 키워드 사용

```kotlin
fun main() {
    birthdayGreeting()
}

fun birthdayGreeting() {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}
```

### 함수에서 값 반환하기
```kotlin
fun birthdayGreeting(): Unit {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}
```
- Unit : 반환값이 없다는 의미 (java에서는 void)

```kotlin
fun birthdayGreeting(): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
```

### 함수에 매개변수 추가하기
- 코틀린에서는 전달된 매개변수를 변경할 수 없음 (val)
```kotlin
fun birthdayGreeting(name: String): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
```

## 함수 매개변수의 기본값
```kotlin
fun birthdayGreeting(name: String = "Rover", age: Int): String{
    return "Happy Birthday, $name! You are now $age years old!"
}
```

## lateinit
"lateinit"은 코틀린에서 클래스의 non-null 프로퍼티를 지연 초기화 할때 사용하는 키워드입니다.

즉, 생성자에서 값을 할당하지 않고 나중에 값을 할당할 수 있게 하는 것을 의미합니다.

예를 들어 다음 코드는 lateinit으로 초기화하지 않은 프로퍼티 text를 "initText"메서드에서 초기화하는 코드입니다.
```
class Example {
    lateinit var text: String

    fun initText() {
        text = "Hello World"
    }
}
```

주의 : lateinit은 null이 아닌 타입에만 사용할 수 있습니다. 프로퍼티가 초기화되지 않았을 경우
예외가 발생할 수 있습니다.

## ActivityMainBinding
- 안드로이드 개발에 사용하는 라이브러리
- 안드로이드 스튜디오에서 생성한 layout XML 파일을 가져와서 메모리에 로딩하고,
이를 통해서 자바 코드에서 view의 데이터를 바인딩할 수 있게 해주는 클래스
- **자바 코드에서 view를 조작하고 데이터를 바인딩할 수 있음**

## Intent
- Intent 클래스는 컴포넌트간에 정보를 주고받거나, 새로운 액티비티를 시작하기 위한 화면 전환 등을 처리하는데 사용됨
- 안드로이드에서 액티비티, 서비스, Broadcase Receiver 등의 컴포넌트 사이의 네비게이션을 처리하는데 사용되는 객체


## References
- [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)
- [\[Android\] ConstraintLayout 톺아보기 (안드로이드 공식 문서 번역)](https://shinjekim.github.io/android/2019/08/07/Android-ConstraintLayout/)
- [뷰 결합](https://developer.android.com/topic/libraries/view-binding?hl=ko)

