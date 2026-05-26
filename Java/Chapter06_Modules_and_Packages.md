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