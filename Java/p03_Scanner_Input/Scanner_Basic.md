# Scanner를 이용한 키 입력과 데이터 타입 활용

### ✅ 오늘 배운 내용
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

### 💻 오늘 작성한 코드
- 실습 파일 바로가기: [ScannerEx.java](./ScannerEx.java)

### ⚠️ Troubleshooting
- **문제**: `Resource leak: 'scanner' is never closed` 라는 경고 메시지가 나타남. 그러나 실행하는 데는 특별히 문제가 없음.
- **원인**: `scanner.close()`를 작성하지 않아서 경고 메시지가 뜸.
- **해결**: 소스 코드 마지막에 `scanner.close();`를 추가하여 해결함.