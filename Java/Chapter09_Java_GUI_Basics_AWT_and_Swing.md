# 📅 2026-06-29 (자바의 GUI)

## ✅ 배운 내용

### 1. GUI 응용프로그램이란?

GUI는 **Graphical User Interface**의 약자로, 이미지나 그래픽을 이용하여 메뉴 등을 포함한 화면을 구성하고, 키보드뿐 아니라 마우스 등의 입력 장치를 이용해 사용자가 편리하게 프로그램을 사용할 수 있도록 만든 사용자 인터페이스이다.  
소프트웨어 개발자는 프로그래밍 언어를 선택할 때 GUI를 얼마나 쉽게 작성할 수 있는지와 다양한 GUI 기능을 제공하는지를 중요한 기준으로 고려한다.  
자바는 **AWT**와 **Swing** 패키지를 제공하여 다양한 GUI를 쉽게 구성할 수 있도록 지원한다.  
일반적으로 GUI 응용프로그램과 콘솔 기반 응용프로그램은 작성 방식이 서로 다르다.

---

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

---

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

### 💻 실습 코드

- 실습 파일 바로가기: [FileInputStreamEx.java](./.src/FileInputStreamEx.java)
