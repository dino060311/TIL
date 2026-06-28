# 📅 2026-06-18 (자바의 입출력 스트림)

## ✅ 배운 내용

### 1. 스트림 입출력이란?

컴퓨터 공학에서 스트림(Stream)은 연속적인 데이터의 흐름 또는 데이터를 전송하는 소프트웨어 모듈을 의미한다.  
자바에서 입출력 스트림은 응용프로그램과 입출력 장치를 연결하는 소프트웨어 모듈이다.  
응용프로그램은 입력 스트림과 연결하여 키보드, 파일 등의 입력 장치로부터 데이터를 전달받고, 출력 스트림과 연결하여 모니터, 파일 등의 출력 장치로 데이터를 보낸다.  
스트림 입출력 방식에서는 자바 응용프로그램이 입출력 장치를 직접 제어하지 않고, 입출력 스트림 객체를 통해 데이터를 주고받는다.  
스트림을 사용하지 않고 응용프로그램이 직접 입출력 장치를 제어하려면 매우 복잡한 코드를 작성해야 하며, 다양한 하드웨어 환경을 지원하기도 어렵다.

#### 스트림의 특징

##### 스트림의 양끝에는 입출력 장치와 자바 응용프로그램이 연결된다.

자바 응용프로그램은 입력 스트림 또는 출력 스트림과 연결되며, 실제 입출력 장치 제어는 스트림이 담당한다.

##### 스트림은 단방향이다.

입력 스트림은 입력 장치에서 응용프로그램으로 데이터를 전달한다.  
출력 스트림은 응용프로그램에서 출력 장치로 데이터를 전달한다.  
하나의 스트림이 입력과 출력을 동시에 수행할 수는 없다.

##### 스트림을 통해 흘러가는 기본 단위는 바이트 또는 문자이다.

자바의 스트림은 크게 바이트 스트림과 문자 스트림으로 구분된다.

##### 스트림은 FIFO(First In First Out) 구조이다.

먼저 들어온 데이터가 먼저 처리된다.  
입력 스트림에서는 먼저 입력된 데이터가 먼저 전달되고, 출력 스트림에서는 먼저 출력한 데이터가 먼저 전송된다.

### 2. 바이트 스트림과 문자 스트림

자바의 입출력 스트림은 크게 문자 스트림과 바이트 스트림으로 나뉜다.

#### 문자 스트림

문자 단위로 데이터를 처리하는 스트림이다.  
문자 데이터만 처리할 수 있으며, 문자가 아닌 데이터를 처리하면 잘못된 결과가 발생할 수 있다.  
참고로 자바의 `char` 타입은 2바이트 크기를 가진다.

#### 바이트 스트림

바이트 단위로 데이터를 처리하는 스트림이다.  
문자뿐 아니라 이미지, 오디오, 동영상 등 모든 바이너리 데이터를 처리할 수 있다.  
자바는 `java.io` 패키지에서 다양한 스트림 클래스를 제공한다.

- 바이트 스트림 : 클래스 이름에 `Stream` 사용
- 문자 스트림 : 클래스 이름에 `Reader`, `Writer` 사용

텍스트 파일은 문자 스트림과 바이트 스트림 모두 사용할 수 있지만,  
이미지 파일, 오디오 파일, 동영상 파일과 같은 바이너리 데이터는 반드시 바이트 스트림을 사용해야 한다.

### 3. 스트림 연결

스트림은 서로 연결하여 사용할 수 있다.  
다음은 키보드 입력을 문자 단위로 처리하기 위해 표준 입력 스트림인 `System.in`과 `InputStreamReader`를 연결하는 코드이다.

```java
InputStreamReader rd = new InputStreamReader(System.in);
```

위 코드에서

- `System.in` : 바이트 입력 스트림
- `InputStreamReader` : 문자 입력 스트림

이다.

사용자가 키보드를 통해 입력한 데이터는 먼저 `System.in`으로 들어오고, `InputStreamReader`가 이를 문자로 변환하여 응용프로그램에 전달한다.

응용프로그램은 다음과 같이 문자를 읽을 수 있다.

```java
int c = rd.read();
```

예를 들어 사용자가 `a`, `?`를 입력하면, `System.in`은 입력된 데이터를 바이트 형태로 전달하고,  
`InputStreamReader`는 이를 문자로 변환하여 응용프로그램에 전달한다.  
스트림은 필요에 따라 여러 개를 연결하여 사용할 수 있다.

---

# 📅 2026-06-19 (자바의 입출력 스트림)

## ✅ 배운 내용

### 1. 문자 스트림 클래스

문자 스트림은 2바이트의 유니코드 문자를 단위로 입출력하는 스트림이다.  
문자화되지 않은 바이너리 바이트 값들은 문자 스트림 클래스에서 처리할 수 없으므로, 이미지나 동영상과 같은 바이너리 데이터는 다룰 수 없다.  
문자 입력 스트림은 입력된 바이트 데이터를 전달받아 현재 시스템의 문자 집합(Character Set)에 맞는 문자로 변환한다.  
만약 문자 집합에서 찾을 수 없는 데이터라면 문자가 아니거나, 다른 언어의 문자이거나, 문자 집합 설정이 잘못된 경우일 수 있다.

### 2. FileReader를 이용한 텍스트 파일 읽기

#### 파일 입력 스트림 생성

먼저 파일 입력 스트림을 생성하고 파일과 연결한다.

다음은 `FileReader`를 이용하여 `c:\test.txt` 파일과 연결하는 코드이다.

```java
FileReader fin = new FileReader("c:\\test.txt");
```

`FileReader` 생성자는 지정된 파일을 열고 스트림과 연결한다.  
`c:\test.txt`는 문자로만 구성된 텍스트 파일이다.

#### 파일 읽기

파일 입력 스트림(`fin`)을 이용하여 파일을 읽을 수 있다.  
`fin.read()`는 파일로부터 문자 하나를 읽어 정수형으로 리턴하며, 파일의 끝(EOF)을 만나면 `-1`을 리턴한다.

```java
int c;

while ((c = fin.read()) != -1) {
    System.out.print((char) c);
}
```

#### 버퍼를 이용한 파일 읽기

파일의 크기가 큰 경우 한 문자씩 읽으면 속도가 느려질 수 있다.  
이때는 버퍼를 이용하여 한 번에 여러 문자를 읽는다.

```java
char[] buf = new char[1024];
int n = fin.read(buf);
```

버퍼(Buffer)는 읽거나 쓸 데이터를 임시 저장하는 배열이다.  
`read(buf)`는 최대 1024개의 문자를 읽어 배열에 저장하고, 실제로 읽은 문자 수를 리턴한다.  
따라서 리턴값 `n`이 버퍼 크기보다 작다면 파일의 끝까지 읽은 것으로 판단할 수 있다.

#### 스트림 닫기

파일 읽기가 끝나면 반드시 스트림을 닫아야 한다.

```java
fin.close();
```

닫힌 스트림에서는 더 이상 데이터를 읽을 수 없다.

### FileReader 생성자

| 생성자                    | 설명                                        |
| ------------------------- | ------------------------------------------- |
| `FileReader(File file)`   | file로부터 읽는 FileReader 생성             |
| `FileReader(String name)` | name 이름의 파일로부터 읽는 FileReader 생성 |

### FileReader 주요 메소드

| 메소드                                    | 설명                                                                           |
| ----------------------------------------- | ------------------------------------------------------------------------------ |
| `int read()`                              | 한 개의 문자를 읽어 정수형으로 리턴                                            |
| `int read(char[] cbuf)`                   | 문자들을 읽어 cbuf 배열에 저장하고 읽은 개수 리턴                              |
| `int read(char[] cbuf, int off, int len)` | 최대 len개의 문자를 읽어 cbuf 배열의 off 위치부터 저장하고 실제 읽은 개수 리턴 |
| `String getEncoding()`                    | 스트림이 사용하는 문자 집합의 이름 리턴                                        |
| `void close()`                            | 입력 스트림을 닫고 관련된 시스템 자원 해제                                     |

### 3. 파일 입출력과 예외 처리

파일 입출력 과정에서는 여러 예외가 발생할 수 있다.

#### FileNotFoundException

파일 경로가 잘못되었거나 파일이 존재하지 않는 경우 발생한다.

```java
FileReader fin = new FileReader("c:\\test.txt");
```

#### IOException

파일 읽기, 쓰기, 닫기 과정에서 입출력 오류가 발생하면 발생한다.

```java
int c = fin.read();
```

따라서 파일 입출력 코드는 반드시 예외 처리가 필요하다.

```java
try {
    FileReader fin = new FileReader("c:\\test.txt");

    int c = fin.read();

    fin.close();
}
catch (FileNotFoundException e) {
    System.out.println("파일을 열 수 없음");
}
catch (IOException e) {
    System.out.println("입출력 오류");
}
```

## 💻 실습 코드

- 실습 파일 바로가기: [FileReaderEx.java](./.src/FileReaderEx.java)

---

# 📅 2026-06-20 (자바의 입출력 스트림)

## ✅ 배운 내용

### 1. 문자 집합과 InputStreamReader를 이용한 텍스트 파일 읽기

`InputStreamReader`는 입력되는 바이트 데이터를 문자 집합(Character Set)을 이용해 문자로 변환하는 문자 입력 스트림이다.  
따라서 `InputStreamReader`를 생성할 때는 바이트 데이터를 어떤 문자 집합으로 해석할 것인지 지정해야 한다.  
만약 파일의 실제 인코딩과 지정한 문자 집합이 다르면 한글이 깨지거나 올바르게 해석되지 않을 수 있다.

### InputStreamReader 생성자

| 생성자                                                  | 설명                                                           |
| ------------------------------------------------------- | -------------------------------------------------------------- |
| `InputStreamReader(InputStream in)`                     | in으로부터 읽는 기본 문자 집합의 InputStreamReader 생성        |
| `InputStreamReader(InputStream in, Charset cs)`         | in으로부터 읽는 cs 문자 집합의 InputStreamReader 생성          |
| `InputStreamReader(InputStream in, String charsetName)` | in으로부터 읽는 charsetName 문자 집합의 InputStreamReader 생성 |

### 2. InputStreamReader로 문자 입력 스트림 생성

`InputStreamReader`는 바이트 스트림을 전달받아 문자 정보로 변환하는 스트림 객체이다.  
그러므로 텍스트 파일을 읽기 위해서는 먼저 바이트 파일 입력 스트림을 생성한다.

```java
FileInputStream fin = new FileInputStream("c:\\Temp\\hangul.txt");
```

`c:\Temp\hangul.txt`는 한글이 저장된 텍스트 파일이다.  
그 다음 `InputStreamReader` 객체를 생성한다.

```java
InputStreamReader in = new InputStreamReader(fin, "MS949");
```

생성자의 두 번째 매개변수에는 파일의 문자 집합을 지정한다.  
윈도우 메모장에서 저장한 한글 텍스트 파일은 기본적으로 MS949(CP949) 문자 집합을 사용하는 경우가 많다.  
따라서 파일이 MS949로 저장되어 있다면 위와 같이 `"MS949"`를 지정하여 읽을 수 있다.  
반면 UTF-8로 저장된 파일이라면 다음과 같이 UTF-8을 지정해야 한다.

```java
InputStreamReader in = new InputStreamReader(fin, "UTF-8");
```

### 3. 파일 읽기

`in.read()`는 문자 집합의 인코딩 규칙에 따라 필요한 바이트를 읽고, 이를 문자로 변환하여 리턴한다.

```java
int c;

while((c = in.read()) != -1) {
    System.out.print((char)c);
}
```

파일의 끝(EOF)에 도달하면 `-1`을 리턴한다.  
만약 파일의 실제 인코딩과 `InputStreamReader`에 지정한 문자 집합이 다르면 한글이 깨져 출력될 수 있다.

### 💻 실습 코드

- 실습 파일 바로가기: [FileReadHangulSuccess.java](./.src/FileReadHangulSuccess.java)

---

# 📅 2026-06-21 (자바의 입출력 스트림)

## ✅ 배운 내용

### 1. FileWriter를 이용한 텍스트 파일 쓰기

`FileWriter`는 문자 단위로 데이터를 파일에 저장하는 문자 출력 스트림 클래스이다.  
텍스트 파일에 문자열이나 문자를 저장할 때 사용하며, `java.io` 패키지에 포함되어 있다.

#### 파일 출력 스트림 생성

텍스트 파일에 데이터를 저장하기 위해 먼저 `FileWriter` 객체를 생성해야 한다.  
다음 코드는 `c:\Temp\test.txt` 파일과 연결된 출력 스트림을 생성한다.

```java
FileWriter fout = new FileWriter("c:\\Temp\\test.txt");
```

`FileWriter` 생성자는 지정한 파일을 열고 스트림과 연결한다.

- 파일이 존재하지 않으면 새로 생성한다.
- 파일이 이미 존재하면 기존 내용을 삭제한 후 처음부터 다시 쓴다.

#### 파일 쓰기

`write()` 메소드를 사용하면 문자나 문자열을 파일에 저장할 수 있다.

##### 문자 하나 저장

```java
fout.write('A');
```

문자 `'A'`를 파일에 저장한다.

##### 문자열 저장

```java
fout.write("Hello Java");
```

문자열 전체를 파일에 저장한다.

##### 문자열 일부 저장

```java
fout.write("Hello Java", 0, 5);
```

인덱스 0부터 5개의 문자만 저장한다.

##### 문자 배열 저장

```java
char[] buf = new char[1024];
fout.write(buf, 0, buf.length);
```

배열의 데이터를 한 번에 저장할 수 있다.  
버퍼를 이용하면 문자 하나씩 저장하는 것보다 효율적으로 파일을 기록할 수 있다.

#### 스트림 닫기

파일 저장이 끝나면 반드시 `close()`를 호출하여 스트림을 닫아야 한다.

```java
fout.close();
```

스트림을 닫으면 연결된 파일도 함께 닫히며, 남아 있는 데이터가 모두 저장된다.

#### FileWriter 생성자

| 생성자                                                     | 설명                                                    |
| ---------------------------------------------------------- | ------------------------------------------------------- |
| `OutputStreamWriter(OutputStream out)`                     | out에 출력하는 기본 문자 집합의 OutputStreamWriter 생성 |
| `OutputStreamWriter(OutputStream out, Charset cs)`         | out에 출력하는 cs 문자 집합의 OutputStreamWriter 생성   |
| `OutputStreamWriter(OutputStream out, String charsetName)` | charsetName 문자 집합의 OutputStreamWriter 생성         |
| `FileWriter(File file)`                                    | file에 데이터를 저장할 FileWriter 생성                  |
| `FileWriter(String name)`                                  | name 파일에 데이터를 저장할 FileWriter 생성             |
| `FileWriter(File file, boolean append)`                    | append가 true이면 파일 끝에 이어서 저장                 |
| `FileWriter(String name, boolean append)`                  | append가 true이면 파일 끝에 이어서 저장                 |

#### FileWriter 주요 메소드

| 메소드                                      | 설명                                  |
| ------------------------------------------- | ------------------------------------- |
| `void write(int c)`                         | c를 char로 변환하여 한 개의 문자 출력 |
| `void write(String str)`                    | 문자열 출력                           |
| `void write(String str, int off, int len)`  | 문자열의 일부 출력                    |
| `void write(char[] cbuf, int off, int len)` | 문자 배열의 일부 출력                 |
| `void flush()`                              | 버퍼에 남아 있는 데이터를 모두 출력   |
| `String getEncoding()`                      | 스트림이 사용하는 문자 집합 이름 반환 |
| `void close()`                              | 스트림을 닫고 관련 시스템 자원 해제   |

### 💻 실습 코드

- 실습 파일 바로가기: [FileWriterEx.java](./.src/FileWriterEx.java)

---

# 📅 2026-06-23 (바이트 스트림과 파일 입출력)

## ✅ 배운 내용

### 1. 바이트 스트림 클래스

바이트 스트림은 바이트 단위로 바이너리 데이터가 흐르는 스트림이다.  
바이트 스트림은 바이너리 데이터를 있는 그대로 입출력하기 때문에 이미지, 오디오, 동영상과 같은 파일을 처리할 때 필수적으로 사용된다. 또한 문자들로 구성된 텍스트 파일도 입출력할 수 있다.  
대표적인 바이트 스트림 클래스는 다음과 같다.

#### InputStream/OutputStream

추상 클래스이며, 바이트 입출력을 위한 공통 기능을 제공하는 슈퍼 클래스이다.

#### FileInputStream/FileOutputStream

파일 입출력을 위한 클래스로서, 파일로부터 바이너리 데이터를 읽거나 파일에 바이너리 데이터를 저장할 수 있다.

#### DataInputStream/DataOutputStream

`boolean`, `char`, `byte`, `short`, `int`, `long`, `float`, `double` 타입의 값을 바이너리 형태로 입출력할 수 있다.  
문자열도 바이너리 형태로 저장하고 읽을 수 있다.

### 2. FileOutputStream을 이용한 바이너리 파일 쓰기

프로그램 내의 변수나 배열에 들어 있는 바이너리 값을 그대로 파일에 저장해야 하는 경우가 있다.  
예를 들어 메모리에 있는 이미지 데이터를 이미지 파일로 저장하거나, 프로그램에서 생성한 바이트 배열을 그대로 파일에 저장할 때 사용한다.  
바이너리 파일은 사람이 직접 읽고 해석하기 어렵다.  
바이너리 데이터를 파일에 저장할 때는 `FileOutputStream` 클래스를 사용한다.

### FileOutputStream 생성자

| 생성자                                          | 설명                                                            |
| ----------------------------------------------- | --------------------------------------------------------------- |
| `FileOutputStream(File file)`                   | file이 지정하는 파일에 출력하는 FileOutputStream 생성           |
| `FileOutputStream(String name)`                 | name이 지정하는 파일에 출력하는 FileOutputStream 생성           |
| `FileOutputStream(File file, boolean append)`   | append가 true이면 file이 지정하는 파일의 마지막부터 데이터 저장 |
| `FileOutputStream(String name, boolean append)` | append가 true이면 name이 지정하는 파일의 마지막부터 데이터 저장 |

### FileOutputStream 주요 메소드

| 메소드                                   | 설명                                                |
| ---------------------------------------- | --------------------------------------------------- |
| `void write(int b)`                      | int 형으로 전달된 한 바이트를 출력 스트림으로 출력  |
| `void write(byte[] b)`                   | 배열 b의 바이트를 모두 출력 스트림으로 출력         |
| `void write(byte[] b, int off, int len)` | 배열 b의 off 위치부터 len개의 바이트 출력           |
| `void flush()`                           | 출력 스트림에 남아 있는 바이너리 데이터를 모두 출력 |
| `void close()`                           | 출력 스트림을 닫고 관련된 시스템 자원 해제          |

### 3. 파일 출력 스트림 생성

`c:\Temp\test.out` 파일에 바이너리 데이터를 저장하는 출력 스트림은 다음과 같이 생성한다.

```java
FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
```

`FileOutputStream` 생성자는 파일과 출력 스트림을 연결한다.

- 파일이 없으면 새로 생성한다.
- 파일이 이미 존재하면 기존 내용을 삭제하고 처음부터 데이터를 기록한다.

### 4. 파일 쓰기

배열에 저장된 바이트 데이터를 파일에 기록할 수 있다.

```java
byte b[] = {7, 51, 3, 4, -1, 24};
for(int i = 0; i < b.length; i++)
    fout.write(b[i]);
```

위 코드는 배열의 각 바이트를 하나씩 파일에 저장한다.  
반복문 없이 배열 전체를 한 번에 저장할 수도 있다.

```java
fout.write(b);
```

`write(byte[])` 메소드를 사용하면 배열의 모든 데이터를 한 번에 파일에 기록할 수 있다.

### 💻 실습 코드

- 실습 파일 바로가기: [FileOutputStreamEx.java](./.src/FileOutputStreamEx.java)

---

# 📅 2026-06-24 (바이트 스트림과 파일 입출력)

## ✅ 배운 내용

### 1. FileInputStream을 이용한 바이너리 파일 읽기

`FileInputStream`은 파일로부터 바이트 단위의 데이터를 읽어오는 입력 스트림 클래스이다.  
바이너리 파일을 읽을 때 사용하며, 이미지, 오디오, 동영상 파일뿐만 아니라 텍스트 파일도 읽을 수 있다.

### FileInputStream 생성자 및 주요 메소드

| 생성자 및 메소드                       | 설명                                                                                         |
| -------------------------------------- | -------------------------------------------------------------------------------------------- |
| `FileInputStream(File file)`           | file이 지정하는 파일로부터 읽는 FileInputStream 생성                                         |
| `FileInputStream(String name)`         | name이 지정하는 파일로부터 읽는 FileInputStream 생성                                         |
| `int read()`                           | 입력 스트림에서 한 바이트를 읽어 int형으로 리턴                                              |
| `int read(byte[] b)`                   | 최대 배열 b의 크기만큼 바이트를 읽음. EOF를 만나면 실제 읽은 바이트 수 리턴                  |
| `int read(byte[] b, int off, int len)` | 최대 len개의 바이트를 읽어 b 배열의 off 위치부터 저장, EOF를 만나면 실제 읽은 바이트 수 리턴 |
| `int available()`                      | 현재 읽을 수 있는 바이트 수 리턴                                                             |
| `void close()`                         | 입력 스트림을 닫고 관련된 시스템 자원 해제                                                   |

### 2. 파일 입력 스트림 생성

FileInputStream 클래스는 파일과 연결된 바이트 입력 스트림을 생성한다.  
다음은 `c:\Temp\test.out` 파일로부터 바이너리 데이터를 읽기 위한 스트림 생성 코드이다.

```java
FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
```

이 코드를 실행하면 `c:\Temp\test.out` 파일을 찾아 열고, 해당 파일과 연결된 입력 스트림 객체를 생성한다.

#### 파일 읽기

`read()` 메소드는 파일로부터 한 바이트를 읽어 리턴한다.  
다음 코드는 파일에 저장된 바이트 데이터를 배열에 저장하는 예제이다.

```java
byte b[] = new byte[6];
int n = 0, c;
while((c = fin.read()) != -1) {
    b[n] = (byte)c;
    n++;
}
```

파일의 끝(EOF)에 도달하면 `read()` 메소드는 `-1`을 리턴한다.  
반복문을 사용하지 않고 배열 전체를 한 번에 읽어올 수도 있다.

```java
fin.read(b);
```

이 코드는 배열 `b`의 크기만큼 데이터를 읽어 배열에 저장한다.

#### 스트림 닫기

파일 읽기가 끝나면 `close()` 메소드를 호출하여 스트림을 닫는다.

```java
fin.close();
```

스트림을 닫으면 관련된 시스템 자원이 해제된다.

### 💻 실습 코드

- 실습 파일 바로가기: [FileInputStreamEx.java](./.src/FileInputStreamEx.java)

---

# 📅 2026-06-25 (버퍼 입출력과 파일 입출력)

## ✅ 배운 내용

### 1. 버퍼 입출력의 필요성

입출력 스트림은 운영체제 API를 호출하여 입출력 장치와 프로그램 사이에서 데이터를 전송한다.  
파일에 데이터를 한 번 쓸 때마다 운영체제 API가 호출되면 하드 디스크나 네트워크 장치가 자주 동작하게 되어 시스템의 효율이 떨어지고 프로그램의 실행 속도도 느려질 수 있다.  
이를 해결하기 위해 사용하는 것이 **버퍼(Buffer)** 이다.  
버퍼는 데이터를 일시적으로 저장하는 메모리 공간으로, 데이터를 일정량 모은 후 한 번에 입출력을 수행하여 운영체제의 부담을 줄이고 입출력 성능을 향상시킨다.  
이처럼 버퍼를 이용하여 데이터를 효율적으로 입출력하는 방식을 **버퍼 입출력(Buffer I/O)** 이라고 한다.

버퍼 스트림은 데이터의 종류에 따라 다음과 같이 구분된다.

- **바이트 버퍼 스트림**
  - `BufferedInputStream`
  - `BufferedOutputStream`
- **문자 버퍼 스트림**
  - `BufferedReader`
  - `BufferedWriter`

### 2. 버퍼 스트림 생성 및 활용

버퍼 스트림은 일반 입출력 스트림과 사용 방법은 거의 동일하지만 내부에 버퍼를 가지고 있다는 차이가 있다.  
버퍼 스트림은 반드시 기존의 입력 또는 출력 스트림과 연결하여 사용하며, 생성자에서 버퍼의 크기를 지정할 수 있다.

### BufferedInputStream / BufferedOutputStream 생성자

| 생성자                                             | 설명                                             |
| -------------------------------------------------- | ------------------------------------------------ |
| `BufferedInputStream(InputStream in)`              | in을 연결하는 기본 크기의 입력 버퍼 스트림 생성  |
| `BufferedInputStream(InputStream in, int size)`    | in을 연결하는 size 크기의 입력 버퍼 스트림 생성  |
| `BufferedOutputStream(OutputStream out)`           | out을 연결하는 기본 크기의 출력 버퍼 스트림 생성 |
| `BufferedOutputStream(OutputStream out, int size)` | out을 연결하는 size 크기의 출력 버퍼 스트림 생성 |

### BufferedReader / BufferedWriter 생성자

| 생성자                               | 설명                                                  |
| ------------------------------------ | ----------------------------------------------------- |
| `BufferedReader(Reader in)`          | in을 연결하는 기본 크기의 문자 입력 버퍼 스트림 생성  |
| `BufferedReader(Reader in, int sz)`  | in을 연결하는 sz 크기의 문자 입력 버퍼 스트림 생성    |
| `BufferedWriter(Writer out)`         | out을 연결하는 기본 크기의 문자 출력 버퍼 스트림 생성 |
| `BufferedWriter(Writer out, int sz)` | out을 연결하는 sz 크기의 문자 출력 버퍼 스트림 생성   |

#### 버퍼 출력 스트림 생성

다음 코드는 버퍼 크기가 20바이트인 `BufferedOutputStream`을 생성하여 표준 출력 스트림(`System.out`)과 연결하는 예제이다.

```java
BufferedOutputStream bout = new BufferedOutputStream(System.out, 20);
```

버퍼가 가득 차면 데이터를 한 번에 화면으로 출력한다.

#### 스트림 출력

다음은 `c:\windows\system.ini` 파일을 읽어 버퍼 출력 스트림을 통해 화면에 출력하는 코드이다.

```java
FileReader fin = new FileReader("c:\\windows\\system.ini");
int c;
while((c = fin.read()) != -1) {
    bout.write((char)c);
}
```

`FileReader`가 파일을 읽고, `BufferedOutputStream`이 데이터를 버퍼에 저장한 후 일정량이 모이면 한 번에 출력한다.

#### 버퍼에 남아 있는 데이터 출력

버퍼 스트림은 버퍼가 가득 찼을 때 자동으로 출력한다.  
따라서 버퍼가 가득 차지 않은 상태에서는 출력되지 않은 데이터가 버퍼에 남아 있을 수 있다.  
이때 `flush()` 메소드를 호출하면 버퍼에 남아 있는 데이터를 강제로 출력할 수 있다.

```java
bout.flush();
```

#### 스트림 닫기

버퍼 스트림 사용이 끝나면 `close()`를 호출하여 스트림을 닫는다.

```java
bout.close();
fin.close();
```

스트림을 닫으면 관련된 시스템 자원이 함께 해제된다.

### 💻 실습 코드

- 실습 파일 바로가기: [BufferedIOEx.java](./.src/BufferedIOEx.java)

---

# 📅 2026-06-27 (File 클래스)

## ✅ 배운 내용

### 1. File 클래스란?

`File` 클래스는 파일이나 디렉터리의 **경로명, 크기, 타입, 수정 날짜** 등의 속성 정보를 제공하며, 파일 삭제, 디렉터리 생성, 파일 이름 변경, 디렉터리 내의 파일 목록 조회 등 다양한 파일 관리 작업을 지원한다.  
`File` 클래스의 경로명은 `java.io.File`이다.  
이름과는 달리 `File` 클래스에는 **파일 입출력 기능은 없다.**  
파일을 읽고 쓰는 작업은 앞에서 배운 `FileInputStream`, `FileOutputStream`, `FileReader`, `FileWriter` 등의 입출력 스트림 클래스를 사용해야 한다.

### 2. File 객체 생성

`File` 객체는 다음과 같은 생성자를 이용하여 생성한다.  
예를 들어 `c:\Temp\test.txt` 파일을 나타내는 `File` 객체는 다음과 같이 생성할 수 있다.

```java
File f = new File("c:\\Temp\\test.txt");
File f = new File("c:\\Temp", "test.txt");
```

| 생성자                              | 설명                                      |
| ----------------------------------- | ----------------------------------------- |
| `File(File parent, String child)`   | parent 디렉터리 아래 child 파일 객체 생성 |
| `File(String pathname)`             | pathname 경로의 File 객체 생성            |
| `File(String parent, String child)` | parent 경로 아래 child 파일 객체 생성     |
| `File(URI uri)`                     | URI가 지정하는 File 객체 생성             |

### 3. File 클래스를 이용한 파일 및 디렉터리 관리

`File` 클래스의 메소드를 이용하면 파일 크기와 타입을 확인하고, 파일 삭제, 이름 변경, 디렉터리 생성, 디렉터리의 파일 목록 조회 등 다양한 파일 관리 작업을 수행할 수 있다.

#### File 클래스의 주요 메소드

| 메소드                        | 설명                                                         |
| ----------------------------- | ------------------------------------------------------------ |
| `boolean mkdir()`             | 새로운 디렉터리 생성                                         |
| `String[] list()`             | 디렉터리 내의 파일과 서브 디렉터리 목록을 문자열 배열로 반환 |
| `File[] listFiles()`          | 디렉터리 내의 파일과 서브 디렉터리 목록을 File 배열로 반환   |
| `boolean renameTo(File dest)` | dest가 지정하는 경로명으로 파일 또는 디렉터리 이름 변경      |
| `boolean delete()`            | 파일 또는 디렉터리 삭제                                      |
| `long length()`               | 파일의 크기 반환                                             |
| `String getPath()`            | 전체 경로명을 문자열로 반환                                  |
| `String getParent()`          | 부모 디렉터리의 경로 반환                                    |
| `String getName()`            | 파일 또는 디렉터리 이름 반환                                 |
| `boolean isFile()`            | 일반 파일이면 true 반환                                      |
| `boolean isDirectory()`       | 디렉터리이면 true 반환                                       |
| `long lastModified()`         | 마지막 수정 시간을 반환                                      |
| `boolean exists()`            | 파일 또는 디렉터리가 존재하면 true 반환                      |

#### 파일 크기, length()

`length()`는 파일이나 디렉터리의 크기를 반환한다.

```java
File f = new File("c:\\windows\\system.ini");
long size = f.length();
```

파일이 존재하지 않거나 디렉터리 또는 운영체제 종속적인 장치 파일인 경우에는 운영체제에 따라 `0`을 반환하기도 한다.

#### 파일의 경로명, getName(), getPath(), getParent()

- `getName()` : 파일명만 반환
- `getPath()` : 전체 경로명 반환
- `getParent()` : 부모 디렉터리 경로 반환

```java
String filename = f.getName();
String path = f.getPath();
String parent = f.getParent();
```

#### 파일 타입 판별, isFile()과 isDirectory()

`isFile()`과 `isDirectory()`를 이용하여 파일인지 디렉터리인지 확인할 수 있다.

```java
if(f.isFile())
    System.out.println(f.getPath() + "는 파일입니다.");
else if(f.isDirectory())
    System.out.println(f.getPath() + "는 디렉터리입니다.");
```

예를 들어 `system.ini`는 일반 파일이므로 다음과 같이 출력된다.

```text
c:\windows\system.ini는 파일입니다.
```

#### 디렉터리에 있는 파일 리스트 얻기, listFiles()

`File` 객체가 디렉터리를 가리키는 경우 `listFiles()`를 이용하여 디렉터리 안에 있는 파일과 서브 디렉터리 목록을 가져올 수 있다.

- `list()` : 파일 및 디렉터리 이름을 `String[]`으로 반환
- `listFiles()` : 파일 및 디렉터리 정보를 `File[]`으로 반환

다음은 `c:\Temp` 디렉터리의 모든 파일과 디렉터리 정보를 출력하는 예제이다.

```java
File f = new File("c:\\Temp");
File[] subFiles = f.listFiles();
for(int i = 0; i < subFiles.length; i++) {
    System.out.print(subFiles[i].getName());
    System.out.println("\t파일 크기: " + subFiles[i].length());
}
```

### 💻 실습 코드

- 실습 파일 바로가기: [FileEx.java](./.src/FileEx.java)

---

# 📅 2026-06-28 (파일 입출력 응용: 파일 복사)

## ✅ 배운 내용

파일은 **텍스트 파일(Text File)** 과 **바이너리 파일(Binary File)** 로 나눌 수 있다.

- **텍스트 파일**은 문자로 이루어진 파일이며, 문자 스트림이나 바이트 스트림을 모두 사용할 수 있다.
- **바이너리 파일**은 이미지, 오디오, 동영상 등 바이너리 데이터로 이루어진 파일이므로 반드시 바이트 스트림을 사용해야 한다.

### 1. 텍스트 파일 복사

문자 스트림을 이용하여 텍스트 파일을 복사할 수 있다.  
`FileReader`를 이용하여 원본 파일을 읽고, `FileWriter`를 이용하여 새로운 파일에 내용을 그대로 저장한다.  
파일의 경로는 `File` 객체를 이용하여 관리한다.  
이 방법은 **텍스트 파일 복사에 적합**하며, 이미지 파일이나 실행 파일(`.exe`), 한글(`.hwp`), PPT 등의 바이너리 파일은 정상적으로 복사할 수 없다.

### 2. 바이너리 파일 복사

바이트 스트림을 이용하면 바이너리 파일을 그대로 복사할 수 있다.  
`FileInputStream`으로 파일을 읽고, `FileOutputStream`으로 데이터를 그대로 저장한다.

```java
FileInputStream fi = new FileInputStream(src);
FileOutputStream fo = new FileOutputStream(dest);
```

이 방법은 바이트 단위로 데이터를 복사하므로 이미지, 동영상, 실행 파일뿐 아니라 텍스트 파일도 복사할 수 있다.

### 3. 블록 단위로 파일 고속 복사

파일을 한 바이트씩 읽고 쓰면 입출력 횟수가 많아져 복사 시간이 오래 걸린다.  
복사 속도를 높이기 위해서는 `BufferedInputStream`, `BufferedOutputStream`을 사용하거나, 바이트 배열(버퍼)을 이용하여 **블록 단위**로 읽고 쓰는 방법을 사용할 수 있다.

## 💻 실습 코드

- 실습 파일 바로가기:
  - [TextCopyEx.java](./.src/TextCopyEx.java)
  - [BinaryCopyEx.java](./.src/BinaryCopyEx.java)
  - [BlockBinaryCopyEx.java](./.src/BlockBinaryCopyEx.java)
