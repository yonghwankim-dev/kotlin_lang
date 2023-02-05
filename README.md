## 학습목표
- [ ] [ConstraintLayout](#ConstraintLayout)
- [ ] viewBinding

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


## References
- [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)
- [\[Android\] ConstraintLayout 톺아보기 (안드로이드 공식 문서 번역)](https://shinjekim.github.io/android/2019/08/07/Android-ConstraintLayout/)
- [뷰 결합](https://developer.android.com/topic/libraries/view-binding?hl=ko)

