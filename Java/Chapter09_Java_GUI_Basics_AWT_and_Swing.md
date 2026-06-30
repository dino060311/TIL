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