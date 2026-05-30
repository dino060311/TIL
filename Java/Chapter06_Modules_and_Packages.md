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

#### java.lang

자바 프로그래밍에 필요한 **가장 기본적인 클래스와 인터페이스**를 제공하는 패키지이다.

대표적인 기능:

- 문자열 처리 (`String`)
- 시스템 관련 (`System`)
- 수학 연산 (`Math`)
- 기본 입출력 관련 클래스

`java.lang` 패키지는 **자동으로 import** 되므로 별도의 `import` 문이 필요하지 않다.

#### java.util

프로그램 개발에 자주 사용되는 **유틸리티 클래스와 인터페이스**를 제공한다.

대표적인 기능:

- 날짜와 시간
- 컬렉션 프레임워크
- 벡터(Vector)
- 해시맵(HashMap)

등 다양한 기능을 포함한다.

#### java.io

**입출력(Input/Output)** 과 관련된 클래스와 인터페이스를 제공한다.

예:

- 키보드 입력
- 모니터 출력
- 프린터 출력
- 파일 읽기/쓰기

#### java.awt와 javax.swing

**GUI(Graphical User Interface)** 프로그래밍을 위한 패키지이다.

- `java.awt` → AWT(Abstract Window Toolkit)
- `javax.swing` → Swing GUI 컴포넌트 제공

버튼, 창(Window), 텍스트 박스 등의 화면 요소를 만들 때 사용된다.
