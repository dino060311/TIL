# 📅 2026-05-16 (상속의 개념, 클래스 상속과 객체)

## ✅ 배운 내용

### 1. 상속(Inheritance)

객체 지향에서 **상속**은 부모 클래스에 만들어진 필드와 메소드를 자식 클래스가 물려받는 개념이다.
상속을 사용하면 코드 중복을 줄이고, 클래스 재사용과 확장이 쉬워진다.

#### 상속의 장점

- 클래스의 간결화 → 중복 코드 감소
- 클래스 관리 용이 → 계층적 구조 구성 가능
- 생산성 향상 → 재사용 및 확장 쉬움

### 2. 클래스 상속과 객체

자바에서는 부모 클래스를 `슈퍼 클래스`(super class), 상속받는 자식 클래스를 `서브 클래스`(sub class)라고 한다.

상속은 `extends` 키워드를 사용하여 선언한다.

#### 예제

```java
public class Person {
    ...
}
public class Student extends Person { // Person을 상속받는 클래스 Student 선언
    ...
}
public class StudentWorker extends Student {
    // Student를 상속받는 클래스 StudentWorker 선언
    ...
}
```

`Student`는 `Person`을 상속받고, `StudentWorker`는 `Student`를 상속받기 때문에 `Person`의 멤버도 함께 상속받는다.

#### 상속과 객체

- 상속 선언
  Point를 상속받는 ColorPoint 클래스의 상속 선언은 다음과 같다.

```java
class ColorPoint extends Point {
    ...
}
```

- 서브 클래스 객체 생성  
  Point 클래스의 객체와 ColorPoint 클래스의 객체를 생성하는 코드이다.

```java
Point p = new Point();
ColorPoint cp = new ColorPoint(); // 서브 클래스 객체 생성
```

- `p` 객체 → `Point` 클래스의 멤버만 가짐
- `cp` 객체 → `Point`와 `ColorPoint` 클래스의 멤버를 모두 가짐

즉, 상속을 통해 서브 클래스 객체는 슈퍼 클래스의 기능과 자신만의 기능을 함께 사용할 수 있다.

#### 서브 클래스 객체 활용

`ColorPointEx` 클래스의 `main()` 메소드에서는 `cp` 객체를 통해 부모 클래스 `Point`의 public 멤버와 `ColorPoint`의 public 멤버를 모두 사용할 수 있다.

단, `x`, `y`, `color` 필드는 `private` 접근 제어자를 사용했기 때문에 외부에서 직접 접근할 수 없다.

#### 서브 클래스에서 슈퍼 클래스 멤버 접근

서브 클래스는 슈퍼 클래스의 `private` 멤버를 제외한 멤버를 접근할 수 있다.

예를 들어 `ColorPoint` 클래스는 `Point`의 `set()` 메소드와 `showPoint()` 메소드를 사용할 수 있다.

### 자바 상속의 특징

- 클래스의 다중 상속을 지원하지 않는다.
- 상속의 횟수에 제한을 두지 않는다.
- 계층 구조의 최상위에 java.lang.Object 클래스가 있다.

## 💻 실습 코드

- 실습 파일 바로가기: [ColorPointEx.java](./.src/ColorPointEx.java)

---

# 📅 2026-05-17 (상속과 protected 접근 지정자)

## ✅ 배운 내용

### 1. 슈퍼 클래스에 대한 접근 지정

슈퍼 클래스의 멤버는 접근 지정자(`private`, `default`, `protected`, `public`)에 따라 접근 가능한 범위가 달라진다.

| 슈퍼 클래스 멤버에 접근하는 클래스 종류 | private | default | protected | public |
| :-------------------------------------- | :-----: | :-----: | :-------: | :----: |
| 같은 패키지에 있는 클래스               |   ❌    |   ⭕    |    ⭕     |   ⭕   |
| 다른 패키지에 있는 클래스               |   ❌    |   ❌    |    ❌     |   ⭕   |
| 같은 패키지에 있는 서브 클래스          |   ❌    |   ⭕    |    ⭕     |   ⭕   |
| 다른 패키지에 있는 서브 클래스          |   ❌    |   ❌    |    ⭕     |   ⭕   |

#### 슈퍼 클래스의 private 멤버

슈퍼 클래스의 멤버가 `private`으로 선언되면, 서브 클래스를 포함하여 다른 어떤 클래스에서도 접근할 수 없다.  
private은 오직 **현재 클래스 내부에서만 접근 가능**함을 의미한다.

#### 슈퍼 클래스의 default 멤버

슈퍼 클래스의 멤버가 `default`로 선언되면, **같은 패키지에 있는 클래스들만 접근 가능**하다.    
서브 클래스라도 **다른 패키지에 있다면 접근할 수 없다.**  

#### 슈퍼 클래스의 public 멤버

슈퍼 클래스의 멤버가 `public`으로 선언되면, 같은 패키지에 있든 다른 패키지에 있든 모든 클래스에서 접근할 수 있다.

### 2. 슈퍼 클래스의 protected 멤버

슈퍼 클래스의 `protected` 멤버는 다음 두 가지 경우에 접근을 허용한다.

- 같은 패키지에 속한 모든 클래스
- 같은 패키지든 다른 패키지든 상속받는 서브 클래스

즉, `protected`는 `default`보다 접근 범위가 넓으며, **상속 관계를 고려한 접근 지정자**이다.

## 💻 실습 코드

- 실습 파일 바로가기: [InheritanceEx.java](./.src/InheritanceEx.java)
