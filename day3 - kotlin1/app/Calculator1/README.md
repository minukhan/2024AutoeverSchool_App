# 계산기 앱 만들기

<img src="https://github.com/user-attachments/assets/e5d3ca6f-39ed-4d9c-b4d1-6b31d12b50a4" width="200"/>

**공통명세**

- 두 값의 사칙연산을 수행하는 계산기
- 각 값은 4자리 수가 넘어가면 안된다.
- 초기화 기능 필요
- 사칙연산은 함수를 사용한다.

```swift
- hint1: 널 값 사용하는 방법 (처음의 두 변수 a, b에 값이 없을 때 null 값을 사용해야 편리함)
    - null 값 사용하기 전에 검사 필요. null일 때 아닐 때 if문으로 분기 필요
- hint2: 레이아웃 구현할 때 어떤 레이아웃을 사용하면 좋을까?
- hint3: 버튼 크기를 동일하게 배치하기 위해 layout_weight을 모두 1로 설정한다.
- hint4: “arithmetic(사칙연산)” Boolean 변수를 사용해 입력되고 있는 숫자 값이 A인지 B인지 분기할 수 있다.
- hint5: Int, String의 자료형 변환을 사용해야 한다. (a.toString(), text.toInt())**

// 사칙연산 버튼이 눌렸는지 판단
var arithmetic = false

// 어떤 사칙연산으로 수행 중인지
var add = false
var subtract = false
var multiply = false
var divide = false
```

**계산기 1**
- IF문 사용(when, 반복문 은 사용 불가)
