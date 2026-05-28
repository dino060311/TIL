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
