# 📅 2026-06-29 (자바의 GUI)

## ✅ 배운 내용

### 1. GUI 응용프로그램이란?

GUI는 **Graphical User Interface**의 약자로, 이미지나 그래픽을 이용하여 메뉴 등을 포함한 화면을 구성하고, 키보드뿐 아니라 마우스 등의 입력 장치를 이용해 사용자가 편리하게 프로그램을 사용할 수 있도록 만든 사용자 인터페이스이다.  
소프트웨어 개발자는 프로그래밍 언어를 선택할 때 GUI를 얼마나 쉽게 작성할 수 있는지와 다양한 GUI 기능을 제공하는지를 중요한 기준으로 고려한다.  
자바는 **AWT**와 **Swing** 패키지를 제공하여 다양한 GUI를 쉽게 구성할 수 있도록 지원한다.  
일반적으로 GUI 응용프로그램과 콘솔 기반 응용프로그램은 작성 방식이 서로 다르다.

### 2. AWT와 Swing 패키지

자바는 GUI 응용프로그램을 쉽게 작성할 수 있도록 다양한 GUI 컴포넌트(GUI Component)를 제공한다.  
자바의 GUI 컴포넌트는 **AWT 컴포넌트**와 **Swing 컴포넌트**로 구분되며, 각각 `java.awt` 패키지와 `javax.swing` 패키지에서 제공된다.

#### AWT

AWT(Abstract Window Toolkit)는 자바가 처음 출시될 때부터 제공된 GUI 라이브러리이다.  
Frame, Window, Panel, Dialog, Button, Label, TextField, Checkbox, Choice 등의 다양한 GUI 컴포넌트를 제공한다.  
AWT 컴포넌트는 운영체제의 GUI 자원을 이용하여 화면에 출력되는 **중량 컴포넌트(Heavy Weight Component)** 이다.  
따라서 운영체제에 따라 컴포넌트의 모양이 달라질 수 있다.  
예를 들어 `Button` 컴포넌트는 Windows에서는 Windows 버튼 모양으로, macOS에서는 macOS 버튼 모양으로 출력된다.

#### Swing

Swing은 AWT와 달리 **순수 자바(Java)** 로 구현된 GUI 라이브러리이다.  
운영체제의 도움을 받지 않고 자체적으로 화면을 그리기 때문에 **경량 컴포넌트(Light Weight Component)** 라고 한다.  
따라서 운영체제와 관계없이 동일한 모양과 동일한 동작을 제공한다.  
Swing은 AWT의 모든 컴포넌트를 호환하도록 다시 구현하였으며, 컴포넌트 이름은 AWT와 구분하기 위해 모두 **J**로 시작한다.

대표적인 컴포넌트는 다음과 같다.

- `JFrame`
- `JWindow`
- `JPanel`
- `JButton`
- `JLabel`
- `JList`
- `JTree`
- `JScrollPane`

또한 AWT보다 다양한 고급 GUI 컴포넌트를 제공하여 보다 풍부한 GUI 응용프로그램을 개발할 수 있다.  
Swing은 AWT를 기반으로 구현되었기 때문에 Swing을 사용하기 위해서는 AWT 패키지도 함께 사용된다.

#### AWT보다 Swing 사용 권장

AWT와 Swing 모두 GUI 응용프로그램을 개발할 수 있지만, 최근에는 대부분의 GUI 응용프로그램이 **Swing 기반**으로 작성된다.  
Swing은 다양한 컴포넌트를 제공하고 운영체제에 관계없이 동일한 화면을 구성할 수 있기 때문에 일반적으로 AWT보다 많이 사용된다.

### 3. 스윙 기반의 GUI 응용프로그램 구성

Swing 응용프로그램은 여러 컴포넌트를 조합하여 하나의 화면을 구성한다.

대표적인 컴포넌트는 다음과 같다.

- `JFrame` : 전체 GUI를 담는 메인 윈도우
- `JMenuBar` : 메뉴 바
- `JMenu` : 메뉴
- `JToolBar` : 도구 모음
- `JButton` : 버튼
- `JLabel` : 문자열이나 이미지 출력
- `JTextField` : 한 줄 문자열 입력
- `JComboBox` : 콤보 박스
- `JSplitPane` : 화면 분할
- `JList` : 목록 출력
- `JScrollPane` : 스크롤 기능 제공

---

# 📅 2026-06-30 (자바 GUI 패키지)

## ✅ 배운 내용

### 1. GUI 패키지 계층 구조

모든 GUI 컴포넌트는 `Component` 클래스를 상속받으며, **Swing 컴포넌트의 클래스 이름은 모두 `J`로 시작한다.**  
AWT 컴포넌트는 `Button`, `Label`처럼 `Component`를 직접 상속받는 클래스와 `Panel`, `Frame`처럼 `Container`를 상속받는 클래스로 나뉜다.  
Swing에서는 `JApplet`, `JFrame`, `JDialog`를 제외한 대부분의 컴포넌트가 `JComponent`를 상속받는다.  
또한 `Font`, `Dimension`, `Color`, `Graphics` 등은 GUI 컴포넌트는 아니지만, 글꼴 설정, 색상 지정, 도형 그리기 등 그래픽 작업에 필요한 클래스이다.

### 2. 컨테이너와 컴포넌트

자바 GUI 응용프로그램은 여러 GUI 컴포넌트로 구성된다.  
GUI 객체는 **다른 컴포넌트를 포함할 수 있는지 여부**에 따라 **컨테이너(Container)** 와 **컴포넌트(Component)** 로 구분된다.

#### 컨테이너

컨테이너는 **다른 GUI 컴포넌트를 포함할 수 있는 컴포넌트**이다.  
컨테이너가 되기 위해서는 `java.awt.Container` 클래스를 상속받아야 하며, `Container`는 `Component`를 상속받기 때문에 컨테이너 역시 하나의 컴포넌트이다.  
또한 컨테이너는 다른 컨테이너 안에 포함될 수도 있다.

대표적인 컨테이너는 다음과 같다.

```text
Frame, Panel, Applet, Dialog, Window
JFrame, JPanel, JApplet, JDialog, JWindow
```

#### 컴포넌트

컴포넌트는 **다른 컴포넌트를 포함할 수 없는 GUI 객체**이다.  
컴포넌트는 반드시 컨테이너에 포함되어야 화면에 출력된다.  
모든 AWT 및 Swing 컴포넌트는 `java.awt.Component`를 상속받으며, `Component` 클래스에는 크기, 위치, 색상, 폰트, 이벤트 처리 등 모든 컴포넌트의 공통 기능이 정의되어 있다.  
또한 대부분의 Swing 컴포넌트는 `javax.swing.JComponent`를 상속받으며, Swing 컴포넌트에서 공통적으로 사용하는 기능을 제공한다.

#### 최상위 컨테이너

최상위 컨테이너는 **다른 컨테이너에 포함되지 않고 독립적으로 화면에 출력될 수 있는 컨테이너**를 의미한다.

대표적인 최상위 컨테이너는 다음과 같다.

- `JFrame`
- `JDialog`
- `JApplet`

이들을 제외한 나머지 컨테이너와 컴포넌트는 반드시 다른 컨테이너에 포함되어야 하며, 최종적으로는 최상위 컨테이너에 포함되어야 화면에 출력된다.

#### 컨테이너와 컴포넌트의 포함 관계

Swing 응용프로그램은 `JFrame`과 같은 최상위 컨테이너를 기준으로 여러 컨테이너와 컴포넌트를 계층 구조로 배치하여 화면을 구성한다.  
예를 들어 `JFrame` 안에 `JPanel`을 배치하고, 그 안에 다시 여러 개의 `JPanel`과 `JButton` 등의 컴포넌트를 추가할 수 있다.  
이처럼 컨테이너와 컴포넌트는 **계층 구조**를 이루며, 컨테이너 안에 포함된 컴포넌트를 **자식 컴포넌트**라고 한다.

---

# 📅 2026-07-01 (스윙 GUI 프로그램 만들기)

## ✅ 배운 내용

### 1. 스윙 패키지 사용을 위한 import 문

Swing 패키지를 사용하려면 스윙 컴포넌트 클래스가 포함된 `javax.swing` 패키지를 import해야 한다.

```java
import javax.swing.*;
```

대부분의 Swing 응용프로그램은 이벤트 처리와 그래픽 작업을 함께 사용하므로 다음과 같은 패키지도 자주 import한다.

```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
```

### 2. 스윙 프레임과 컨텐트팬

스윙 프레임은 모든 Swing 컴포넌트를 담는 **최상위 컨테이너**이다.  
스윙 프레임이 화면에 출력되면 프레임에 포함된 모든 컴포넌트도 함께 출력된다.  
반대로 프레임이 종료되면 내부의 모든 컴포넌트도 함께 사라진다.  
Swing에서 프레임 역할을 하는 클래스는 `JFrame`이다.  
`JFrame` 객체는 크게 다음과 같은 영역으로 구성된다.

- Frame(`java.awt.Frame`)
- 메뉴바(Menu Bar)
- 컨텐트팬(Content Pane)

메뉴바는 메뉴를 배치하는 공간이며, **컨텐트팬은 메뉴를 제외한 모든 GUI 컴포넌트를 배치하는 공간**이다.  
따라서 Swing 응용프로그램에서 화면에 표시할 버튼, 레이블 등의 컴포넌트는 모두 컨텐트팬에 추가해야 한다.

### 3. 프레임 만들기, JFrame 클래스 상속

스윙 응용프로그램의 프레임은 `JFrame` 클래스를 상속받아 만들 수 있다.

```java
public class MyFrame extends JFrame {
    ...
}
```

`MyFrame` 객체가 생성되면 하나의 스윙 프레임이 생성된다.  
`main()` 메소드에서 객체를 생성하면 프레임이 화면에 출력된다.

```java
new MyFrame();
```

프레임의 제목과 크기, 화면 표시 여부는 생성자에서 설정한다.

```java
setTitle("300x300 스윙 프레임 만들기");
setSize(300, 300);
setVisible(true);
```

- `setTitle()` : 프레임 제목 설정
- `setSize()` : 프레임 크기 설정
- `setVisible(true)` : 프레임을 화면에 표시

`setSize()`를 호출하지 않으면 프레임의 크기가 **0 × 0**이 되어 화면에 보이지 않는다.  
또한 `setVisible(true)`를 호출하지 않으면 기본값이 `false`이므로 프레임이 화면에 출력되지 않는다.

### 💻 실습 코드

- 실습 파일 바로가기: [MyFrame.java](./.src/MyFrame.java)

---

# 📅 2026-07-03 (스윙 GUI 프로그램 만들기)

## ✅ 배운 내용

### 1. 스윙 응용프로그램에서 main() 메소드의 기능과 위치

스윙 응용프로그램에서 `main()` 메소드의 역할은 **최소한으로 유지하는 것이 좋다.**  
`main()`에는 응용프로그램의 시작점으로서 프레임 객체를 생성하는 정도의 코드만 작성하고, 나머지 기능은 `JFrame`을 상속받은 프레임 클래스에서 구현하는 것이 일반적이다.  
`main()` 메소드는 프레임 클래스 내부에 작성할 수도 있고, `main()`만을 담당하는 별도의 클래스를 만들어 작성할 수도 있다.  
어떤 방법을 사용해도 기능상의 차이는 없으며, 규모가 작은 프로그램에서는 프레임 클래스 안에 `main()`을 작성하는 경우가 많다.

### 2. 프레임에 컴포넌트 붙이기

프레임은 GUI 응용프로그램을 구성하는 가장 바깥쪽 컨테이너이다.  
Swing에서는 버튼, 레이블 등의 GUI 컴포넌트를 프레임의 **컨텐트팬(Content Pane)** 에 추가하여 화면을 구성한다.

#### 타이틀 달기

프레임의 제목은 `JFrame` 생성자나 `setTitle()` 메소드를 이용하여 설정할 수 있다.

```java
public MyFrame() {
    super("타이틀문자열");
    setTitle("타이틀문자열");
}
```

설정한 제목은 프레임의 타이틀 바에 표시된다.

#### 메뉴 붙이기

메뉴를 만들기 위해서는 **메뉴바(MenuBar)** 를 생성한 후 메뉴(`JMenu`)와 메뉴 아이템(`JMenuItem`)을 추가한다.  
생성한 메뉴바를 `JFrame`의 메뉴바 영역에 부착하면 화면에 메뉴가 출력된다.

#### 컨텐트팬에 컴포넌트 달기

Swing에서는 **컨텐트팬에만 컴포넌트를 추가할 수 있다.**  
`JFrame` 객체가 생성될 때 컨텐트팬도 함께 생성되므로 `getContentPane()` 메소드를 이용하여 현재 컨텐트팬을 얻을 수 있다.  
컨텐트팬의 자료형은 `Container`이다.

```java
public class MyFrame extends JFrame {
    public MyFrame() {
        Container contentPane = getContentPane();
    }
}
```

컨텐트팬은 컨테이너이므로 `add()` 메소드를 이용하여 컴포넌트를 추가한다.

```java
JButton button = new JButton("Click");
contentPane.add(button);
```

컨텐트팬에 추가된 컴포넌트들은 프레임이 화면에 출력될 때 함께 표시된다.

#### 컨텐트팬의 변경

`JFrame`의 `setContentPane()` 메소드를 이용하면 기존 컨텐트팬을 새로운 컨테이너로 교체할 수 있다.  
컨텐트팬은 `Container`를 상속받은 객체라면 어떤 컨테이너도 사용할 수 있다.  
다음은 `JPanel`을 상속받은 `MyPanel`을 새로운 컨텐트팬으로 설정하는 예이다.

```java
class MyPanel extends JPanel {

}

frame.setContentPane(new MyPanel());
```

### 💻 실습 코드

- 실습 파일 바로가기: [ContentPaneEx.java](./.src/ContentPaneEx.java)

---

# 📅 2026-07-04 (스윙 GUI 프로그램 만들기)

## ✅ 배운 내용

### 1. 스윙 응용프로그램의 종류

자바에서 프로그램을 종료하려면 다음과 같이 `System.exit(0)`을 호출하면 된다.

```java
System.exit(0);
```

하지만 스윙 응용프로그램에서 프레임의 오른쪽 위에 있는 **닫기(X) 버튼**은 프레임을 닫는 기능만 수행하며, 프로그램 자체를 종료시키지는 않는다.  
따라서 프레임을 닫을 때 프로그램도 함께 종료하려면 `setDefaultCloseOperation()` 메소드를 사용해야 한다.

```java
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

`JFrame.EXIT_ON_CLOSE`를 지정하면 프레임이 닫힐 때 자바 프로그램도 함께 종료된다.

### 2. main() 메소드가 종료한 뒤에도 프레임이 살아 있는 이유는 무엇인가?

콘솔 응용프로그램에서는 `main()` 메소드가 종료되면 자바 응용프로그램도 함께 종료된다.  
자바 응용프로그램이 시작되면 JVM(Java Virtual Machine)은 **main 스레드(Main Thread)** 를 생성하여 `main()` 메소드를 실행한다.  
응용프로그램에서 새로운 스레드를 생성하지 않았다면 `main()` 메소드가 종료될 때 main 스레드도 종료되고, 실행 중인 스레드가 더 이상 없으므로 프로그램도 종료된다.  
하지만 Swing에서는 `JFrame` 객체가 생성되면 **이벤트 처리 스레드(Event Dispatch Thread, EDT)** 가 자동으로 생성된다.  
이 이벤트 처리 스레드는 키보드와 마우스 입력을 받아 각 컴포넌트에 이벤트를 전달하는 역할을 수행한다.  
따라서 `main()` 메소드가 종료되더라도 이벤트 처리 스레드가 계속 실행되고 있기 때문에 프레임은 화면에 남아 사용자 입력을 계속 처리할 수 있다.
