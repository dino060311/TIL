# 📅 2026-05-25(패키지)

## ✅ 배운 내용

### 1. 패키지의 개념과 필요성

하나의 자바 응용프로그램을 여러 개발자가 함께 개발한다고 가정해보자.

예를 들어:

- 개발자 A → `FileIO` 기능 개발
- 개발자 B → `Graphic` 기능 개발
- 개발자 C → `UI` 기능 개발

이때 개발자 A와 C가 **동일한 이름의 `Tools` 클래스**를 만들 수 있다.

만약 모든 클래스 파일을 하나의 디렉터리에 저장하면:

```text
Tools.class
Tools.class
```

처럼 **클래스 이름 충돌 문제**가 발생한다.

이를 해결하기 위해 기능별 디렉터리를 구분하여 저장할 수 있다.

```text
Project/FileIO/Tools.class
Project/UI/Tools.class
```

이처럼 **관련된 클래스들을 그룹화하여 관리하는 디렉터리 구조를 자바에서는 `패키지(package)`라고 한다.**

패키지는 디렉터리 경로를 `점(.)`으로 표현한다.

```java
Project.FileIO.Tools
Project.UI.Tools
```

즉, 패키지를 사용하면 **같은 이름의 클래스도 서로 다른 경로에서 구분 가능**하다.

### 2. 자바의 모듈과 패키지, 클래스 경로명

자바에서 **패키지(package)** 란 **서로 관련 있는 클래스나 인터페이스의 컴파일된 `.class` 파일들을 하나로 묶어 놓은 단위**이다.

즉, 패키지는 **관련 클래스들이 들어 있는 디렉터리**라고 볼 수 있다.

자바 JDK는 많은 클래스들을 패키지 형태로 제공하며, **JDK 9부터는 패키지들을 모듈(module)** 이라는 단위로 묶어 관리한다.

모듈은:

- `JDK 설치 경로/jmods`
- `.jmod` 확장자
- 압축 파일(ZIP 형식)

형태로 제공된다.

#### `java.base` 모듈

가장 기본적인 모듈은 `java.base` 이며, 자바 프로그램에서 자주 사용하는 핵심 클래스들을 포함한다.

대표적인 패키지:

- `java.lang`
- `java.io`
- `java.util`

### 3. 클래스 경로명(Class Path Name)

자바에서 클래스를 사용할 때는 **모듈명이 아닌 패키지명을 포함한 전체 경로명**을 사용한다.

예를 들어 `Scanner` 클래스는:

```java
java.util.Scanner
```

와 같이 표현한다.

---

# 📅 2026-05-26 (import와 클래스 경로)

## ✅ 배운 내용

### 1. 패키지 사용하기와 import 문

자바에서 **다른 패키지에 있는 클래스를 사용하려면 패키지명을 포함한 경로명(클래스 경로명)** 을 사용해야 한다.  
이는 컴파일러가 **클래스 파일의 위치를 정확히 찾을 수 있도록 하기 위해서**이다.  
예를 들어 `Scanner` 클래스는 `java.util` 패키지에 포함되어 있으므로 다음과 같이 전체 경로명을 사용할 수 있다.

```java
public class ImportExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}
```

하지만 매번 긴 경로명을 작성하는 것은 번거롭기 때문에 `import` 문을 사용한다.

### 2. `import` 문 사용 방법

`import` 문은 **다른 패키지의 클래스를 사용할 때 컴파일러에게 클래스 경로명을 알려주는 역할**을 한다.  
`import` 문은 **반드시 소스 코드 상단에 작성**해야 한다.

#### 1) 특정 클래스만 import 하기

클래스마다 개별적으로 지정할 수 있다.

```java
import 패키지.클래스명;
```

예:

```java
import java.util.Scanner;
public class ImportExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}
```

#### 2) 같은 패키지의 여러 클래스 import 하기

한 패키지에 있는 여러 클래스를 사용할 경우 `*`(와일드카드)를 사용하여 한 번에 import 할 수 있다.

```java
import 패키지명.*;
```

예:

```java
import java.util.*;
public class ImportExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}
```

---

# 📅 2026-05-28 (패키지 만들기)

## ✅ 배운 내용

### 1. 패키지 선언

자바 소스 파일(.java)이 컴파일되어 생기는 클래스 파일(.class 파일)은 **반드시 하나의 패키지에 소속되어야 한다.**  
클래스가 속할 패키지는 `package` 키워드를 사용하여 **소스 파일의 첫 줄에 선언**한다.

```java
package 패키지명;
```

예를 들어 `Tools` 클래스를 `UI` 패키지(UI 디렉터리)에 저장하려면 다음과 같이 작성한다.

```java
package UI;

public class Tools {
    ...
}
```

`Tools.java` 파일이 컴파일되면 `UI` 디렉터리에 `Tools.class` 파일이 생성된다.  
클래스 경로명은 다음과 같이 표현한다.

```java
UI.Tools
```

따라서 다른 패키지에서 `Tools` 클래스를 사용하려면 `import` 문이 필요하다.

```java
import UI.Tools;
```

예를 들어 `Graphic` 패키지의 `Line` 클래스에서 `Tools` 클래스를 사용하려면 다음과 같이 작성한다.

```java
package Graphic;

import UI.Tools;
```

### 2. 디폴트 패키지(default package)

package 선언문을 사용하지 않고 자바 클래스나 인터페이스를 작성하면, 자바 컴파일러는 이를 **디폴트 패키지(default package)** 에 소속시킨다.  
디폴트 패키지는 **현재 디렉터리**를 의미한다.

즉:

```java
public class Hello {
    ...
}
```

처럼 `package` 선언이 없으면 현재 폴더에 속하게 된다.

### 3. 패키지의 특징

#### 1) 패키지 계층 구조

상속 관계에 있는 클래스나 인터페이스를 **계층 구조로 패키지화**하면 관리가 쉬워진다.  
예를 들어, 서브 클래스를 슈퍼 클래스 패키지의 하위 디렉터리에 저장하면 구조를 체계적으로 관리할 수 있다.

#### 2) 패키지별 접근 제한

디폴트(default) 접근 지정으로 선언된 클래스나 멤버는 **같은 패키지 내에서만 접근 가능**하다.

즉:

- 같은 패키지 → 접근 가능
- 다른 패키지 → 접근 불가

이를 통해 패키지는 **접근 권한 범위** 역할도 수행한다.

#### 3) 동일한 이름의 클래스를 다른 패키지에 작성 가능

같은 패키지 내에서는 **동일한 이름의 클래스나 인터페이스를 만들 수 없다.**
하지만 **다른 패키지에서는 같은 이름 사용이 가능**하다.  
클래스 이름은 **패키지명을 포함한 전체 경로명으로 구분하기 때문**이다.

#### 4) 소프트웨어의 높은 재사용성

클래스와 인터페이스를 잘 분류하여 패키지로 관리하면, **같거나 유사한 기능을 재작성하지 않고 재사용**할 수 있다.  
대규모 프로젝트에서는 패키지가 **유지보수와 협업 효율을 높이는 중요한 자산**이 된다.

---

# 📅 2026-05-29 (모듈 개념)

## ✅ 배운 내용

### 1. 모듈(Module)

모듈(Module)은 **Java 9에서 처음 도입된 개념**이다.

패키지(package)는 **서로 관련 있는 클래스나 인터페이스의 컴파일된 클래스 파일들을 담는 컨테이너**이고,  
모듈(module)은 **이러한 여러 패키지를 담는 상위 컨테이너**이다.

즉:

```text
모듈 > 패키지 > 클래스
```

구조를 가진다.

모듈은 `.jmod` 파일 형태로 저장된다.

---

### 2. 자바 플랫폼의 모듈화

오라클은 **Java 9부터 자바 플랫폼 전체를 모듈화**하였다.

자바 플랫폼(Java Platform)이란:

- **개발 환경** → JDK(Java Development Kit)
- **실행 환경** → JRE(Java Runtime Environment)

를 포함하는 개념이다.

Java 9 이전에는 자바 API 클래스들이 패키지 구조로만 관리되었지만, Java 9부터는 **수십 개의 작은 모듈 단위로 재구성**되었다.

모듈들은 JDK 내부의 `jmods` 디렉터리에 저장되어 있다.

대표적인 기본 모듈은:

```text
java.base
```

이며, `java.base.jmod` 파일에 포함되어 있다.

`java.base` 모듈에는 자바 응용프로그램에서 자주 사용하는 핵심 패키지와 클래스들이 포함된다.

`.jmod` 파일은 ZIP 형식으로 압축되어 있으며, `jmod` 명령어를 이용해 압축을 해제할 수 있다.

예:

```bash
jmod extract "C:\Program Files\Microsoft\jdk-21.0.2.13-hotspot\jmods\java.base.jmod"
```

압축을 해제하면 `classes` 디렉터리 안에서 여러 패키지를 확인할 수 있다.

대표적인 패키지:

```text
java.io
java.lang
java.math
java.util
```

---

### 3. 모듈 기반의 자바 실행 환경

자바 실행 환경(Java Runtime Environment)이란 **자바 응용프로그램 실행에 필요한 환경 전체**를 의미한다.

예:

- 자바 API 클래스
- JVM(Java Virtual Machine)

#### Java 9 이전

Java 9 이전에는 자바 API 클래스들이 **`rt.jar`라는 하나의 파일**에 포함되어 있었다.

JVM은 프로그램 실행 시 필요한 클래스를 `rt.jar`에서 불러와 실행하였다.

#### Java 9 이후

Java 9부터는 `rt.jar`가 제거되었고, 대신 **필요한 모듈만 조립하여 실행 환경을 구성하는 방식**으로 변경되었다.

즉, 응용프로그램 실행에 필요한 모듈만 불러오기 때문에 **불필요한 자원 사용을 줄일 수 있다.**

---

### 4. 자바 모듈화의 목적

자바 모듈화의 가장 큰 목적은 **필요한 컴포넌트만 선택적으로 조립하여 사용하기 위함**이다.

모듈화를 통해:

- 필요 없는 모듈 로드 방지
- 메모리 및 시스템 자원 절약
- 실행 성능 향상

이 가능하다.

특히 **하드웨어 성능이 낮은 IoT(사물인터넷) 장치**에서도 자바 응용프로그램을 효율적으로 실행할 수 있도록 돕는다.

---

# 📅 2026-05-30 (자바 JDK에서 제공하는 패키지)

## ✅ 배운 내용

### 1. 주요 패키지

자바를 설치하면 **자바 개발 도구(JDK, Java Development Kit)** 가 함께 설치된다.  
JDK에는 개발자가 사용할 수 있는 다양한 클래스와 인터페이스가 **패키지(package)** 형태로 제공되며, 다시 **모듈(module)** 안에 포함되어 관리된다.  
자바에서 기본적으로 제공하는 이러한 클래스 라이브러리를 **자바 API(Java API)** 라고 한다.  
JDK의 표준 패키지들은 **모듈 단위로 구성**되어 있으며, JDK 설치 경로의 `jmods` 디렉터리 안에 저장되어 있다.

#### `java.lang`

자바 프로그래밍에 필요한 **가장 기본적인 클래스와 인터페이스**를 제공하는 패키지이다.

대표적인 기능:

- 문자열 처리 (`String`)
- 시스템 관련 (`System`)
- 수학 연산 (`Math`)
- 기본 입출력 관련 클래스

`java.lang` 패키지는 **자동으로 import** 되므로 별도의 `import` 문이 필요하지 않다.

#### `java.util`

프로그램 개발에 자주 사용되는 **유틸리티 클래스와 인터페이스**를 제공한다.

대표적인 기능:

- 날짜와 시간
- 컬렉션 프레임워크
- 벡터(Vector)
- 해시맵(HashMap)

등 다양한 기능을 포함한다.

#### `java.io`

**입출력(Input/Output)** 과 관련된 클래스와 인터페이스를 제공한다.

예:

- 키보드 입력
- 모니터 출력
- 프린터 출력
- 파일 읽기/쓰기

#### `java.awt`와 `javax.swing`

**GUI(Graphical User Interface)** 프로그래밍을 위한 패키지이다.

- `java.awt` → AWT(Abstract Window Toolkit)
- `javax.swing` → Swing GUI 컴포넌트 제공

버튼, 창(Window), 텍스트 박스 등의 화면 요소를 만들 때 사용된다.

---

# 📅 2026-05-31 (Object 클래스)

## ✅ 배운 내용

### 1. Object 생성과 특징

`Object` 클래스는 `java.lang` 패키지에 속한 클래스로, **모든 클래스의 최상위 슈퍼 클래스**이다.  
자바의 모든 클래스는 명시적으로 상속하지 않더라도 자동으로 `Object` 클래스를 상속받는다.  
`Object` 클래스만이 유일하게 다른 클래스를 상속받지 않는다.  
따라서 `Object` 클래스에는 모든 객체가 공통적으로 사용할 수 있는 기능들이 구현되어 있다.

객체 생성 예:

```java
Object obj = new Object();
```

#### Object의 주요 메소드

| 메소드                       | 설명                                         |
| ---------------------------- | -------------------------------------------- |
| `boolean equals(Object obj)` | 두 객체의 내용을 비교하여 같으면 `true` 반환 |
| `Class getClass()`           | 현재 객체의 런타임 클래스 정보 반환          |
| `int hashCode()`             | 객체의 해시 코드 값 반환                     |
| `String toString()`          | 객체를 문자열 형태로 반환                    |
| `void notify()`              | 대기 중인 스레드 하나를 깨움                 |
| `void notifyAll()`           | 대기 중인 모든 스레드를 깨움                 |
| `void wait()`                | 다른 스레드가 깨울 때까지 대기               |

### 2. 객체 속성

`Object` 클래스는 모든 객체가 공통적으로 가져야 할 메소드를 제공한다.  
Class 클래스는 주어진 객체의 클래스에 관한 정보를 담는 클래스이다.  
Object의 getClass() 메소드를 호출하면 바로 이 Class 객체를 리턴하는데, 다음과 같이 Class 객체의 getName() 메소드를 이용하면 obj 레퍼런스가 가리키는 객체의 클래스 타입을 알아낼 수 있다.

```java
System.out.println(obj.getClass().getName());
```

객체는 생성될 때 객체를 구분하기 위한 고유한 식별자(id)를 가진다.  
이 값을 해시코드라고 부르고, Object의 hashCode() 메소드는 객체 안에 담겨진 해시코드 값을 리턴한다.  
Object의 toString()은 객체를 문자열로 변환하여 리턴하는 메소드이다.

### 3. 객체를 문자열로 변환, toString() 메소드

객체를 문자열로 변환할 때 사용하는 메소드가 `toString()`이다.

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

Object의 toString() 메소드는 객체의 클래스 이름을 얻어 와서 ' @ '를 연결하고 다시 객체의 해시코드 값을 16 진수로 변환하여 연결한 문자열을 리턴한다.  
또한 '객체 + 문자열' 연산이나 객체를 출력하는 경우, toString()이 자동으로 호출된다.

### 4. 클래스에 toString() 만들기

개발자는 `Object`의 `toString()` 메소드를 **오버라이딩**하여 객체 정보를 원하는 형태로 출력할 수 있다.

```java
public String toString();
```

### 5. 객체 비교와 equals() 메소드

기본 자료형은 `==` 연산자로 값을 비교할 수 있다.  
하지만 객체는 `equals()` 메소드를 이용하여 비교하는 것이 일반적이다.

#### `==` 연산자

`==`는 두 객체의 내용이 같은지를 비교하는 것이 아니라, **두 레퍼런스가 같은 객체를 가리키는지 비교**한다.

#### `boolean equals(Object obj)`

`equals()`는 인자로 전달된 객체와 현재 객체를 비교하여 **내용이 같은지 판단하는 메소드**이다.  
필요에 따라 개발자가 직접 오버라이딩하여 사용할 수 있다.

## 💻 실습 코드

- 실습 파일 바로가기: [RectEqualsEx.java](./.src/RectEqualsEx.java)

---

# 📅 2026-06-02 (Wrapper 클래스)

## ✅ 배운 내용

### 1. Wrapper 클래스 개념

Wrapper 클래스는 기본 타입(byte, int, double 등)을 객체로 다루기 위해 제공되는 클래스이다.  
자바에서는 일부 기능이 객체만을 다루기 때문에 기본 타입 값을 객체로 변환할 필요가 있으며, 이를 위해 Wrapper 클래스를 사용한다.
Wrapper 클래스는 java.lang 패키지에서 제공된다.

| 기본 타입      | byte | short | int     | long | char      | float | double | boolean |
| -------------- | ---- | ----- | ------- | ---- | --------- | ----- | ------ | ------- |
| Wrapper 클래스 | Byte | Short | Integer | Long | Character | Float | Double | Boolean |

### 2. Wrapper 클래스의 객체 생성

Wrapper 객체는 기본 타입의 값을 인자로 하여 다음 예와 같이 정적 메소드인 valueOf()를 호출하여 생성한다.

```java
Integer i = Integer.valueOf(10);
Character c = Character.valueOf('c');
Double d = Double.valueOf(3.14);
Boolean b = Boolean.valueOf(true);
```

대부분의 Wrapper 클래스는 문자열을 이용해 객체를 생성할 수 있다.

```java
Integer i = Integer.valueOf("10");
Double d = Double.valueOf("3.14");
```

### 3. Wrapper 클래스의 활용

Wrapper 클래스는 문자열과 기본 타입 사이의 변환 기능을 많이 제공한다.
그중 Integer 클래스는 가장 자주 사용되며 다양한 static 메소드를 제공한다.

| 메소드                                     | 설명                                                   |
| ------------------------------------------ | ------------------------------------------------------ |
| `static int bitCount(int i)`               | 정수 i의 이진수 표현에서 1의 개수 리턴                 |
| `float floatValue()`                       | float 타입으로 값 리턴                                 |
| `int intValue()`                           | int 타입으로 값 리턴                                   |
| `long longValue()`                         | long 타입으로 값 리턴                                  |
| `short shortValue()`                       | short 타입으로 값 리턴                                 |
| `static int parseInt(String s)`            | 문자열 s를 10진 정수로 변환한 값 리턴                  |
| `static int parseInt(String s, int radix)` | 문자열 s를 지정된 진법의 정수로 변환한 값 리턴         |
| `static String toBinaryString(int i)`      | 정수 i를 이진수 표현으로 변환한 문자열 리턴            |
| `static String toHexString(int i)`         | 정수 i를 16진수 표현으로 변환한 문자열 리턴            |
| `static String toOctalString(int i)`       | 정수 i를 8진수 표현으로 변환한 문자열 리턴             |
| `static String toString(int i)`            | 정수 i를 문자열로 변환하여 리턴                        |
| `static Integer valueOf(int i)`            | 정수 i를 담은 Integer 객체 리턴                        |
| `static Integer valueOf(String s)`         | 문자열 s를 정수로 변환하여 담고 있는 Integer 객체 리턴 |

#### Wrapper 객체에 들어 있는 기본 타입 값 알아내기

Wrapper 객체에 들어 있는 기본 타입의 값을 알아내기 위해 다음 코드를 이용한다.

```java
Integer i = Integer.valueOf(10);
int ii = i.intValue();

Double d = Double.valueOf(3.14);
double dd = d.doubleValue();

Boolean b = Boolean.valueOf(true);
boolean bb = b.booleanValue();
```

#### 문자열을 기본 타입으로 변환

Wrapper 클래스는 다음과 같이 문자열을 기본 타입의 값으로 변환하는 메소드를 제공한다.

```java
int i = Integer.parseInt("123");
boolean b = Boolean.parseBoolean("true");
double d = Double.parseDouble("3.14");
```

parseInt(), parseBoolean(), parseDouble() 메소드는 모두 static 타입이므로 Wrapper 클래스의 이름으로 바로 메소드를 호출한다.  
Wrapper 클래스는 해당 타입으로 변환하는 메소드만을 제공한다.

#### 기본 타입 값을 문자열로 변환

Wrapper 클래스는 다음 예와 같이 기본 타입 값을 문자열로 변환하는 메소드를 제공한다.

```java
String s1 = Integer.toString(123);
String s2 = Integer.toHexString(123);
String s3 = Double.toString(3.14);
String s4 = Character.toString('a');
String s5 = Boolean.toString(true);
```

### 4. 박싱(boxing)과 언박싱(unboxing)

기본 타입의 값을 Wrapper 객체로 변환하는 것을 박싱이라고 하고, 반대의 경우를 언박싱이라고 한다.  
박싱과 언박싱은 자동으로 이루어지며, 이를 자동 박싱, 자동 언박싱이라고 부른다.

```java
Integer ten = 10; // 자동 박싱
int n = ten; // 자동 언박싱
```

## 💻 실습 코드

- 실습 파일 바로가기:
  [WrapperEx.java](./.src/WrapperEx.java)
  [AutoBoxingUnBoxingEx.java](./.src/AutoBoxingUnBoxingEx.java)

---

# 📅 2026-06-03 (String 클래스)

## ✅ 배운 내용

### 1. String의 특징과 객체 생성

String 클래스는 문자열(String)을 표현하는 클래스이다.  
자바에서 문자열 리터럴은 모두 String 객체로 처리되며, 문자열을 저장하고 다양한 문자열 처리 기능을 제공한다.  
String 객체는 여러 생성자를 이용하여 생성할 수 있다.

| 생성자                        | 설명                            |
| ----------------------------- | ------------------------------- |
| `string()`                    | 빈 문자열 생성                  |
| `string(char[] value)`        | 문자 배열로 문자열 생성         |
| `String(String original)`     | 기존 문자열을 복사하여 생성     |
| `String(StringBuffer buffer)` | StringBuffer 객체로 문자열 생성 |

#### 스트링 리터럴과 new String()

String 객체는 다음과 같이 생성할 수 있다.

```java
String s1 = "Java";
String s2 = new String("Java");
```

스트링 리터럴은 자바 내부의 String Pool(리터럴 테이블)에 저장되어 같은 문자열을 공유한다.  
반면 `new String()`은 새로운 객체를 힙 메모리에 생성하므로 같은 문자열이라도 별도의 객체가 된다.

#### 스트링 객체는 수정이 불가능하다

String 객체는 다음과 같이 생성할 수 있다.

```java
String s1 = "Java";
String s2 = new String("Java");
```

스트링 리터럴은 자바 내부의 String Pool(리터럴 테이블)에 저장되어 같은 문자열을 공유한다.  
반면 `new String()`은 새로운 객체를 힙 메모리에 생성하므로 같은 문자열이라도 별도의 객체가 된다.

#### String 객체는 수정이 불가능하다

String 객체는 한 번 생성되면 내용을 변경할 수 없는 불변(Immutable) 객체이다.

```java
String s = new String("Hello");
String t = s.concat("Java");
```

위 코드에서 `concat()`은 `"HelloJava"`라는 새로운 문자열을 생성하여 반환한다.

결과:

```java
s = "Hello"
t = "HelloJava"
```

원래 문자열인 `s`는 변경되지 않는다.  
문자열을 변경하려면 새로 생성된 문자열을 다시 저장해야 한다.

```java
s = s.concat("Java");
```

### 2. String 활용

String 클래스는 문자열 처리를 위해 다양한 메소드를 제공한다.

| 메소드                                                          | 설정                                                                                                        |
| --------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `char charAt(int index)`                                        | index 인덱스에 있는 문자 값 리턴                                                                            |
| `int codePointAt(int index)`                                    | index 인덱스에 있는 유니코드 값 리턴                                                                        |
| `int compareTo(String anotherString)`                           | 두 스트링을 사전 순으로 비교하여 같으면 0, 현 스트링이 anotherString보다 먼저 나오면 음수, 아니면 양수 리턴 |
| `String concat(String str)`                                     | 현재 스트링 뒤에 str 스트링을 덧붙인 새로운 스트링 리턴                                                     |
| `boolean contains(CharSequence s)`                              | s에 지정된 문자들을 포함하고 있으면 true 리턴                                                               |
| `int length()`                                                  | 스트링의 길이(문자 개수) 리턴                                                                               |
| `String replace(Charsequence target, Charsequence replacement)` | target이 지정하는 일련의 문자들을 replacement가 지정하는 문자들로 변경한 스트링 리턴                        |
| `String[] split(String regex)`                                  | 정규식 regex에 일치하는 부분을 중심으로 스트링을 분리하고, 분리된 스트링들을 배열로 저장하여 리턴           |
| `String subString(int beginIndex)`                              | beginIndex 인덱스부터 시작하는 서브 스트링 리턴                                                             |
| `String toLowerCase()`                                          | 소문자로 변경한 스트링 리턴                                                                                 |
| `String toUpperCase()`                                          | 대문자로 변경한 스트링 리턴                                                                                 |
| `String trim()`                                                 | 스트링 앞뒤의 공백 문자들을 제거한 스트링 리턴                                                              |
| `char[] toCharArray()`                                          | 스트링의 문자들을 배열로 만들어 리턴                                                                        |

#### 문자열 비교: int compareTo(String anotherString)

`compareTo()` 메소드는 두 문자열을 사전 순으로 비교한다.

```java
String java = "Java";
String cpp = "C++";

int result = java.compareTo(cpp);
```

반환값

| 값   | 의미                         |
| ---- | ---------------------------- |
| 0    | 두 문자열이 같음             |
| 음수 | 현재 문자열이 사전 순으로 앞 |
| 양수 | 현재 문자열이 사전 순으로 뒤 |

예시

```java
String java = "Java";
String cpp = "C++";

int result = java.compareTo(cpp);

if(result == 0)
    System.out.println("the same");
else if(result < 0)
    System.out.println(java + " < " + cpp);
else
    System.out.println(java + " > " + cpp);
```

출력

```java
Java > C++
```

문자열이 완전히 같은지만 비교할 경우에는 `equals()` 메소드를 사용하는 것이 일반적이다.

#### 문자열 연결: String concat(String str)

문자열은 `+` 연산자 또는 `concat()` 메소드를 이용하여 연결할 수 있다.

```java
System.out.print("abcd" + 1 + true + 3.13e-2 + 'E' + "fgh");
```

출력

```java
abcd1true0.0313Efgh
```

객체가 포함된 경우에는 `toString()`이 자동 호출되어 문자열로 변환된 후 연결된다.
또한 `concat()` 메소드를 이용해서도 문자열을 연결할 수 있다.

```java
"I love ".concat("Java.");
```

결과

```java
I love Java.
```

#### 공백 제거 : String trim()

`trim()` 메소드는 문자열 앞뒤의 공백 문자를 제거한다.

```java
String a = "    avcd    def    ";
String b = "    xyz\t";
String c = a.trime();
String d = b.trim();
```

결과

```java
c = "abcd    def"
d = "xyz"
```

문자열 중간의 공백은 제거되지 않는다.

#### 문자열의 문자: char charAt(int index)

`charAt()` 메소드는 문자열의 특정 위치 문자를 반환한다.

```java
String a = "class";
char c = a.charAt(2);
```

결과

```java
c = 'a'
```

## 💻 실습 코드

- 실습 파일 바로가기: [StringEx.java](./.src/StringEx.java)

---

# 📅 2026-06-04 (StringBuffer 클래스)

## ✅ 배운 내용

### 1. StringBuffer의 생성과 특징

StringBuffer 클래스는 `java.lang` 패키지에 포함되어 있으며, String 클래스와 같이 문자열을 다루는 클래스이다.  
String 객체는 한 번 생성되면 내부 문자열을 변경할 수 없는 불변(Immutable) 객체이지만, StringBuffer 객체는 문자열을 저장하는 가변 버퍼(Buffer)를 가지고 있어 문자열의 수정이 가능하다.  
또한 문자열의 길이가 증가하면 내부 버퍼의 크기를 자동으로 조절한다.

StringBuffer 객체 생성 예

```java
StringBuffer sb = new StringBuffer("Java");
```

StringBuffer 클래스의 주요 생성자는 다음과 같다.

| 생성자                           | 설명                                                    |
| -------------------------------- | ------------------------------------------------------- |
| `StringBuffer()`                 | 초기 크기가 16인 StringBuffer 객체 생성                 |
| `StringBuffer(CharSequence seq)` | seq가 지정하는 문자들을 포함하는 StringBuffer 객체 생성 |
| `StringBuffer(int capacity)`     | 지정된 초기 크기를 갖는 StringBuffer 객체 생성          |
| `StringBuffer(String str)`       | 지정된 문자열로 초기화된 StringBuffer 객체 생성         |

#### 2. StringBuffer 활용

StringBuffer 클래스는 문자열을 수정하거나 조작할 수 있는 다양한 메소드를 제공한다.

| 메소드                                                 | 설명                                                                              |
| ------------------------------------------------------ | --------------------------------------------------------------------------------- |
| `StringBuffer append(String str)`                      | 문자열 str을 현재 StringBuffer의 끝에 추가                                        |
| `StringBuffer append(StringBuffer sb)`                 | 다른 StringBuffer 객체를 현재 StringBuffer의 끝에 추가                            |
| `int capacity()`                                       | 현재 버퍼의 크기 반환                                                             |
| `StringBuffer delete(int start, int end)`              | start 위치부터 end 위치 직전까지의 문자열 삭제                                    |
| `StringBuffer insert(int offset, String str)`          | offset 위치에 문자열 삽입                                                         |
| `StringBuffer replace(int start, int end, String str)` | start 위치부터 end 위치 직전까지의 문자열을 str로 변경                            |
| `StringBuffer reverse()`                               | 문자열 순서를 반대로 변경                                                         |
| `void setLength(int newLength)`                        | 문자열 길이를 newLength로 변경. 길이가 줄어들면 잘리고, 늘어나면 널 문자로 채워짐 |

### 3. StringBuffer와 String의 차이

| String                          | StringBuffer               |
| ------------------------------- | -------------------------- |
| 문자열 수정 불가 (Immutable)    | 문자열 수정 가능 (Mutable) |
| 문자열 변경 시 새로운 객체 생성 | 기존 객체의 내용 변경      |
| 문자열 변경이 적을 때 사용      | 문자열 변경이 많을 때 사용 |

예시

```java
String str = "Java";
str.concat(" Programming");
```

결과

```java
str = "Java"
```

원본 문자열은 변경되지 않는다.

반면 StringBuffer는 다음과 같이 기존 객체가 변경된다.

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" Programming");
System.out.println(sb);
```

출력

```java
Java Programming
```

## 💻 실습 코드

- 실습 파일 바로가기: [StringEx.java](./.src/StringEx.java)

---

# 📅 2026-06-05 (StringTokenizer 클래스)

## ✅ 배운 내용

### 1. StringTokenizer의 생성과 특징

StringTokenizer 클래스는 `java.util` 패키지에 포함되어 있으며, 하나의 문자열을 여러 개의 문자열로 분리하기 위해 사용된다.  
문자열을 분리할 때 사용되는 기준 문자를 **구분 문자(delimiter)** 라고 하며, 구분 문자에 의해 분리된 문자열을 **토큰(token)** 이라고 한다.  
StringTokenizer 객체는 생성과 동시에 문자열을 토큰으로 분리한다.

예를 들어, 다음은 '&' 문자를 기준으로 문자열 `"name=kitae&addr=seoul&age=21"` 을 여러 토큰으로 분리하는 코드이다.

```java
String query = "name=kitae&addr=seoul&age=21";
StringTokenizer st = new StringTokenizer(query, "&");
```

실행 결과

```text
name=kitae
addr=seoul
age=21
```

StringTokenizer 객체는 분리된 토큰을 내부에 저장한다.  
분리된 토큰의 개수는 `countTokens()` 메소드로 확인할 수 있으며, `nextToken()` 메소드를 이용하여 토큰을 하나씩 가져올 수 있다.

```java
int count = st.countTokens();
```

```java
String token = st.nextToken();
```

### 2. StringTokenizer 생성자

StringTokenizer 클래스의 주요 생성자는 다음과 같다.
| 생성자 | 설명 |
|---------|---------|
| `StringTokenizer(String str)` | 기본 구분 문자를 이용하여 문자열을 분리하는 StringTokenizer 생성 |
| `StringTokenizer(String str, String delim)` | delim을 구분 문자로 사용하여 문자열을 분리하는 StringTokenizer 생성 |
| `StringTokenizer(String str, String delim, boolean returnDelims)` | returnDelims가 true이면 구분 문자도 토큰으로 포함 |

### 3. StringTokenizer 주요 메소드

| 메소드                    | 설명                            |
| ------------------------- | ------------------------------- |
| `int countTokens()`       | 현재 남아 있는 토큰의 개수 반환 |
| `boolean hasMoreTokens()` | 다음 토큰이 존재하면 true 반환  |
| `String nextToken()`      | 다음 토큰 반환                  |

## 💻 실습 코드

- 실습 파일 바로가기: [StringTokenizerEx.java](./.src/StringTokenizerEx.java)
