# 코틀린 함수
- [함수 생성](#함수-생성)
- [when 표현식](#when-표현식)
- [함수 매개변수의 기본값](#함수-매개변수의-기본값)
- [압축 함수 만들기](#압축-함수-만들기)
- [filter](#filter)

## 함수 생성
randomDay(), fishFood() 함수를 생성함, randomDay는 랜덤한 요일을 반환함

https://github.com/yonghwankim-dev/kotlin_lang/blob/e77b2bcec710ac5473ed240d78ac05b3371875d0/functions/test.kt#L5-L14

randomDay() 함수 구현

https://github.com/yonghwankim-dev/kotlin_lang/blob/e77b2bcec710ac5473ed240d78ac05b3371875d0/functions/test.kt#L16-L20

## when 표현식
when 표현식은 어떤 한 값에 대해서 맞는 케이스에 따른 로직을 수행함

https://github.com/yonghwankim-dev/kotlin_lang/blob/e77b2bcec710ac5473ed240d78ac05b3371875d0/functions/test.kt#L22-L33

## 함수 매개변수의 기본값
매개변수에 기본값을 다음과 같이 설정할 수 있습니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/e77b2bcec710ac5473ed240d78ac05b3371875d0/functions/test.kt#L36-L38

매개변수의 기본값이 적용된 함수를 다음과 같이 호출 할 수 있습니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/c46bca4e3a36b51a9ce1d926c455b609438cbaa2/functions/test.kt#L9-L11

요구되는 파라미터를 설정하기 위해서는 매개변수의 기본값을 다음과 같이 설정하지 않으면 됩니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/c46bca4e3a36b51a9ce1d926c455b609438cbaa2/functions/test.kt#L45-L52

위 코드를 보면 temperature, dirty 매개변수는 기본값이 설정되어 있지만 day 매개변수는 호출시 무조건 값을 넣어야 합니다.

## 압축 함수 만들기
압축 함수(compact function)는 다음과 같이 만들 수 있습니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/c46bca4e3a36b51a9ce1d926c455b609438cbaa2/functions/test.kt#L55-L59

## filter
### filter 생성
필터링을 위한 리스트 생성합니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L4

리스트의 filter를 다음과 같이 호출할 수 있습니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L5

### eager and lazy filters 비교
eager 실행 방식은 표현식이 있다면 바로 처리하는 방식이고 lazy 실행 방식은 표현식이 필요한 경우에 그때서야 실행하는 방식입니다.

코틀린에서는 기본적으로 filter는 eager 방식입니다.

filter lazy 방식을 만들기 위해서는 **Sequence**를 사용하여야 합니다.

eager 방식으로 실행은 다음과 같이 할 수 있습니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L8-L9

asSequence 함수를 호출하여 lazy 방식으로 다음과 같이 표현할 수 있습니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L12-L13

코틀린에서 `filter` 함수는 컬렉션에서 특정 조건을 만족하는 요소들만을 추출하는 함수입니다.

`filter` 함수는 기본적으로 모든 요소를 한번에 검색해서 새로운 컬렉션을 반환하는데

`filter` 함수를 `filter lazy`로 변경하면 해당 컬렉션에서 요소를 검색할때 지연(lazy) 연산을 수행합니다.

이 때문에 모든 요소를 즉시 검색하지 않고 필요한 요소만 추출하기 때문에 메모리를 절약할 수 있습니다.

`filter lazy` 함수는 코틀린의 `Sequence` 인터페이스를 이용하여 지연 연산을 수행합니다.

`Sequence` 인터페이스는 컬렉션 요소의 시퀀스를 표현하는 인터페이스로, 요소에 대한 지연 연산을

수행할 수 있는 함수들을 제공합니다. 따라서 `filter lazy` 함수는 `Sequence` 인터페이스를 이용하면 지연 연산을

수행하게 됩니다.

---

지연 연산이 적용된 필터를 리스트로 만들어 출력합니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L15-L16

```shell
eager: [pagoda, plastic plant]
filtered: kotlin.sequences.FilteringSequence@386cc1c4
new list: [pagoda, plastic plant]
```

위와 같은 동일한 decorations 리스트를 사용하여 아무 작업도 하지 않은 map()을 사용하여

변환하고 전달된 요소만 반환하게 할 수 있습니다. 

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L18-L27

```text
lazy: kotlin.sequences.TransformingSequence@506c589e
---
access: rock
first: rock
---
access: rock
access: pagoda
access: plastic plant
access: alligator
access: flowerpot
all: [rock, pagoda, plastic plant, alligator, flowerpot]
```

map을 적용하기 전에 원본 필터를 사용하여 새로운 Sequence를 생성하고 출력합니다.

https://github.com/yonghwankim-dev/kotlin_lang/blob/6575b131064ad1795d0870638018e8c54f436bac/functions/filterEx.kt#L29-L35

```text
---
access: pagoda
access: plastic plant
filtered: [pagoda, plastic plant]
```


