# Chapter 02. 자바 기본 프로그래밍

## 📅 2026-04-11 (자바 기본 구조 이해 및 개발 환경 설정)

### ✅ 배운 내용

- 자바는 무조건 `public class 파일명` 형식을 맞춰야 함 (이거 틀리면 에러남).
- 실행하려면 `main` 메서드(`public static void main(String[] args)`)가 꼭 있어야 함.
- `System.out.println()` : 콘솔에 글자 찍는 가장 기초 명령어.

### 💻 실습 코드

- 실습 파일 바로가기: [Hello.java](./.src/Hello.java)

### ⚠️ Troubleshooting

- **문제**: 터미널에 `git` 쳤는데 인식 안 됨.
- **원인**: 깃 설치 안 함..
- **해결**: Git 설치하고 바로 해결됨.

---

## 📅 2026-04-12 (Scanner & 산술 연산자)

### ✅ 배운 내용

- 변수 (Variable): 데이터를 저장하는 공간 (예: 'radius').
- 리터럴 (Literal): 프로그램에 직접 표현한 값 (예: '3.14', '10.0').
- 상수 (Constant): 'final' 키워드 사용하며, 변수와 달리 실행 중에 값을 바꿀 수 없음. (예: 'PI').

### 💻 실습 코드

- 실습 파일 바로가기: [CircleArea.java](./.src/CircleArea.java)

### ⚠️ Troubleshooting

- **문제**: 폴더 구조 변경 후 에러 발생.
- **원인**:
  1. 하위 폴더(`p02_Variables_DataTypes`)를 생성했으나 코드 내 패키지 선언이 폴더 경로와 일치하지 않음.
  2. 자바의 패키지 이름은 숫자로 시작할 수 없는데, 처음에 `02_...` 형태의 폴더명을 사용하여 문법 오류 발생.
- **해결**:
  1. 폴더 이름을 숫자가 아닌 문자로 시작하는 `p02_Variables_DataTypes`로 변경.
  2. 코드 최상단에 `package Java.p02_Variables_DataTypes;`를 명시하여 폴더 구조와 일치시킴.

  ***

## 📅 2026-04-13 (Scanner를 이용한 키 입력과 데이터 타입 활용)

### ✅ 배운 내용

1. **System.in의 역할**:
   - 자바의 **표준 입력 스트림**으로, 키보드로부터 들어오는 입력 값을 바이트 단위로 읽어들이는 역할을 함.
2. **Scanner와의 관계**:
   - `System.in`은 단순한 바이트 데이터만 다루기 때문에 사용이 까다로움.
   - 이를 `Scanner` 객체에 전달(new Scanner(System.in))함으로써, 우리가 읽기 쉬운 문자나 숫자로 변환하여 사용할 수 있음.
3. **데이터 타입별 입력**:
   - `next()`: 공백(스페이스) 전까지의 문자열을 읽음.
   - `nextInt()`, `nextDouble()`: 각각 정수와 실수를 읽음.
   - `nextBoolean()`: 논리값(true/false)을 읽음.
4. **Scanner 객체 닫기**:
   - 사용을 마친 뒤 `scanner.close()`를 호출해 시스템 자원을 정리함.

### 💻 실습 코드

- 실습 파일 바로가기: [ScannerEx.java](./.src/ScannerEx.java)

### ⚠️ Troubleshooting

- **문제**: `Resource leak: 'scanner' is never closed` 라는 경고 메시지가 나타남. 그러나 실행하는 데는 특별히 문제가 없음.
- **원인**: `scanner.close()`를 작성하지 않아서 경고 메시지가 뜸.
- **해결**: 소스 코드 마지막에 `scanner.close();`를 추가하여 해결함.

  ***

## 📅 2026-04-14 (산술 연산자를 활용한 시간 계산 및 나머지 연산 활용)

### ✅ 배운 내용

- 산술 연산자는 `+`(더하기), `*`(곱하기), `/`(나누기), `%`(나머지)
- `%` 연산자  
  정수 n이 홀수인지 짝수인지 구분할 때 유용하게 사용함.  
  `int r = n % 2; //n이 홀수이면 r은 1, 짝수이면 r은 0`  
  다음과 같이 n 값이 5의 배수인지 확인하기 위해서도 사용됨.  
  `int s = n % 5; //n이 5의 배수이면 s는 0`

### 💻 실습 코드

- 실습 파일 바로가기: [ArithmeticOperator.java](./.src/ArithmeticOperator.java)

  ***

## 📅 2026-04-15 (다양한 연산자 활용)

### ✅ 배운 내용

`증감 연산자`는 피연산자 앞 또는 뒤에 붙어 값을 1증가시키거나 1 감소시킴.  
| 연산자 | 내용 | 연산자 | 내용 |
|:---:|:---:|:---:|:---:|
| a++ | a를 1 증가하고 증가 전의 값 반환 | ++a | a를 1 증가하고 증가된 값 반환 |
| a-- | a를 1 감소하고 감소 전의 값 반환 | --a | a를 감소하고 감소된 값 반환 |

`대입 연산자`는 연산자의 오른쪽 식의 결과를 왼쪽에 있는 변수에 대입함.
| 대입 연산자 | 내용 |
|:---:|:---:|
| a = b | b의 값을 a에 대입 |
| a += b | a = a + b와 동일 |

`비교 연산자`는 두 개의 피연산자를 비교하여 `true` 또는 `false`의 논리 값을 냄.
| 연산자 | 내용 |
|:---:|:---:|
| a < b | a가 b보다 작으면 true |
| a >= b | a가 b보다 크거나 같으면 true |
| a == b | a와 b가 같으면 true |
| a != b | a와 b가 같지 않으면 true |

`논리 연산자`는 논리 값을 대상으로 AND, OR, XOR, NOT의 논리 연산을 하여 논리 값을 냄.
| 연산자 | 내용 | 설명 |
|:---:|:---:|:---|
| a && b | AND | a와 b 모두 true여야 true |
| a \|\| b | OR | a와 b 중 하나라도 true이면 true |
| a ^ b | XOR | a와 b가 서로 다를 때 true |
| !a | NOT | a가 true이면 false, false이면 true |

`조건 연산자`는 조건문이 true이면 값이 opr2, false이면 값이 opr3가 됨.

```bash
condition ? opr2 : opr3
```

### 💻 실습 코드

- 실습 파일 바로가기:  
  [TernaryOperator.java](./.src/TernaryOperator.java)  
  [AssignmentIncDecOperator.java](./.src/AssignmentIncDecOperator.java)

  ***

## 📅 2026-04-16 (if 문, if-else 문 활용)

### ✅ 배운 내용

조건문을 이용하면 조건의 참, 거짓에 따라 서로 다른 작업을 수행할 수 있음.

**단순 if 문**

- if 문의 조건식이 true이면 if 내부의 '실행 문장'이 실행되며, false이면 if 문을 벗어남.

  if 문을 사용하여 정수 n이 짝수인지 판별하는 코드

  ```bash
  if(n % 2 == 0) {
  System.out.println(n + "은 짝수입니다.");
  }
  ```

  if의 실행문이 한 문장인 경우 {}를 생략해도 됨.

  ```bash
  if((score >= 80) && (score <= 89))
    System.out.println("학점은 B입니다");
  ```

**if-else 문**

- if-else 문은 if의 조건식이 참인 경우와 거짓인 경우에 각각 실행할 문장을 지시할 수 있음.
- 조건식이 true이면 실행 문장1을 실행한 후 if-else 문을 벗어남.
- 조건식이 false이면 실행 문장2를 실행한 후 if-else 문을 벗어남.

  ```bash
  if (n % 2 == 0) {
   System.out.println(n + "은 짝수입니다.");
  }
  else {
   System.out.println(n + "은 홀수입니다.");
  }
  ```

### 💻 실습 코드

- 실습 파일 바로가기:  
  [SuccessOrFail.java](./.src/SuccessOrFail.java)  
  [MultipleOfThree.java](./.src/MultipleOfThree.java)

  ***

## 📅 2026-04-17 (다중 if-else, 중첩 if-else 문 활용)

### 💻 실습 코드

- 실습 파일 바로가기:  
  [Grading.java](./.src/Grading.java)  
  [NestedIf.java](./.src/NestedIf.java)

