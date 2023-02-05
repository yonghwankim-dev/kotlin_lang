## 학습목표
- [ ] ConstraintLayout

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

## References
- [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)
- [\[Android\] ConstraintLayout 톺아보기 (안드로이드 공식 문서 번역)](https://shinjekim.github.io/android/2019/08/07/Android-ConstraintLayout/)

