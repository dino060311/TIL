# 📅 2026-06-08 (컬렉션과 제네릭)

## ✅ 배운 내용

### 1. 컬렉션의 개념

컬렉션(Collection)은 객체들을 저장하고 관리하기 위한 가변 크기의 컨테이너이다.  
배열은 여러 개의 데이터를 저장하는 데 편리하지만, 크기가 고정되어 있어 데이터의 삽입과 삭제가 빈번하거나 저장할 데이터의 개수를 미리 알 수 없는 경우 사용하기 불편하다.  
컬렉션은 이러한 배열의 단점을 보완하기 위해 만들어졌으며, 객체의 삽입, 삭제, 검색 등을 쉽게 수행할 수 있다.  
자바는 `java.util` 패키지를 통해 다양한 컬렉션 클래스를 제공한다.

### 2. 컬렉션을 위한 자바 인터페이스와 클래스

`java.util` 패키지는 다양한 컬렉션 인터페이스와 컬렉션 클래스를 제공한다.

주요 컬렉션 클래스는 다음과 같다.

| 클래스          | 설명                           |
| --------------- | ------------------------------ |
| `Vector<E>`     | 가변 크기의 배열 구현          |
| `ArrayList<E>`  | 가변 크기의 배열 구현          |
| `LinkedList<E>` | 링크 구조를 이용한 리스트 구현 |
| `Stack<E>`      | 스택(LIFO) 구현                |
| `HashSet<E>`    | 집합(Set) 구현                 |
| `HashMap<K, V>` | 키(Key)와 값(Value)의 쌍 저장  |

`Vector<E>`, `ArrayList<E>`, `LinkedList<E>`, `Stack<E>`, `HashSet<E>`는 모두 `Collection<E>` 인터페이스를 상속받는다.  
반면 `HashMap<K, V>`는 데이터를 **키(Key)-값(Value)** 형태로 저장하며, 키를 이용하여 값을 빠르게 검색할 수 있다.

### 3. 컬렉션의 특징

#### (1) 컬렉션은 제네릭(Generic)으로 구현된다.

컬렉션 클래스 이름에는 `<E>`, `<K>`, `<V>` 등의 타입 매개변수가 사용된다.

예시

```java
Vector<Integer> v = new Vector<Integer>();
Vector<String> s = new Vector<String>();
```

위 코드에서

- `Vector<Integer>` → 정수만 저장
- `Vector<String>` → 문자열만 저장

즉, 컬렉션은 다양한 타입으로 사용할 수 있도록 일반화되어 있다.

---

#### (2) 컬렉션에는 객체만 저장할 수 있다.

컬렉션은 객체만 저장할 수 있으므로 기본 타입은 사용할 수 없다.

잘못된 예

```java
Vector<int> v = new Vector<int>();
```

올바른 예

```java
Vector<Integer> v = new Vector<Integer>();
```

기본 타입의 값은 자동 박싱(Auto Boxing)에 의해 Wrapper 객체로 변환되어 저장된다.

예시

```java
Vector<Integer> v = new Vector<Integer>();

v.add(10);
```

실제로는

```java
v.add(Integer.valueOf(10));
```

과 같이 처리된다.

### 4. 제네릭의 기본 개념

제네릭(Generic)은 클래스나 메소드를 특정 타입에 종속시키지 않고 다양한 타입에 사용할 수 있도록 일반화하는 기법이다.  
자바의 제네릭은 C++의 템플릿(Template)과 유사한 개념이다.  
제네릭을 사용하면 하나의 클래스나 메소드로 여러 타입을 처리할 수 있으며, 컴파일 시 타입 검사가 이루어져 프로그램의 안정성을 높일 수 있다.

예시

```java
public class Box<T> {
    T value;
}
```

`T` 자리에 `Integer`, `String` 등의 타입을 지정하여 사용할 수 있다.

### 5. 제네릭 타입 매개변수

제네릭에서는 타입을 일반화하기 위해 관례적으로 한 글자의 대문자를 사용한다.

| 타입 매개변수 | 의미          |
| ------------- | ------------- |
| `E`           | Element(요소) |
| `T`           | Type(자료형)  |
| `K`           | Key(키)       |
| `V`           | Value(값)     |
| `N`           | Number(숫자)  |

---

# 📅 2026-06-09 (제네릭 컬렉션 활용)

## ✅ 배운 내용

### 1. Vector<E>

`Vector<E>`(이하 Vector)는 배열을 가변 크기로 다룰 수 있게 하고, 객체의 삽입, 삭제, 이동을 쉽게 할 수 있도록 만든 컬렉션 클래스이다.  
벡터는 요소의 개수에 따라 자동으로 크기를 조절하며, 요소의 삽입과 삭제에 따라 내부 요소들의 위치도 자동으로 이동시킨다.

#### 벡터 생성

벡터를 생성할 때는 `Vector<E>`의 E에 저장할 요소의 타입을 지정한다.  
예를 들어 정수만 저장하는 벡터는 다음과 같이 생성한다.

```java
Vector<Integer> v = new Vector<Integer>();
```

벡터는 int, char, double 등의 기본 타입을 E에 사용할 수 없다.

잘못된 예

```java
Vector<int> v = new Vector<int>();
```

문자열만 저장하는 벡터는 다음과 같이 생성한다.

```java
Vector<String> stringVector;
stringVector = new Vector<String>();
```

타입을 지정하지 않고 사용할 수도 있지만 컴파일 경고가 발생한다.

```java
Vector v = new Vector();
```

초기 용량을 지정하여 생성할 수도 있다.

```java
Vector<Integer> v = new Vector<Integer>(5000);
```

초기 용량을 크게 설정하면 벡터가 크기를 늘리는 과정에서 발생하는 성능 저하를 줄일 수 있다.

### 2. Vector의 주요 메소드

| 메소드                                      | 설명                     |
| ------------------------------------------- | ------------------------ |
| `boolean add(E element)`                    | 벡터의 맨 뒤에 요소 추가 |
| `void add(int index, E element)`            | 지정한 위치에 요소 삽입  |
| `int capacity()`                            | 현재 용량 반환           |
| `boolean addAll(Collection<? extends E> c)` | 컬렉션의 모든 요소 추가  |
| `void clear()`                              | 모든 요소 삭제           |
| `boolean contains(Object o)`                | 특정 객체 포함 여부 확인 |
| `E elementAt(int index)`                    | 지정 위치의 요소 반환    |
| `E get(int index)`                          | 지정 위치의 요소 반환    |
| `int indexOf(Object o)`                     | 객체의 인덱스 반환       |
| `boolean isEmpty()`                         | 비어 있으면 true 반환    |
| `E remove(int index)`                       | 지정 위치의 요소 삭제    |
| `boolean remove(Object o)`                  | 특정 객체 삭제           |
| `void removeAllElements()`                  | 모든 요소 삭제           |
| `int size()`                                | 요소 개수 반환           |
| `Object[] toArray()`                        | 배열로 변환              |

#### 벡터에 요소 삽입

벡터의 끝에 요소를 추가할 수 있다.

```java
v.add(Integer.valueOf(5));
v.add(Integer.valueOf(4));
v.add(Integer.valueOf(-1));
```

자동 박싱을 이용하면 다음과 같이 간단하게 작성할 수 있다.

```java
v.add(5);
v.add(4);
v.add(-1);
```

벡터에는 지정한 타입의 객체만 저장할 수 있다.

오류 예시

```java
v.add("hello");
v.add(3.5);
v.add(new Person());
```

벡터에는 `null`도 저장할 수 있다.

```java
v.add(null);
```

`add(index, element)` 메소드를 이용하면 원하는 위치에 요소를 삽입할 수 있다.

```java
v.add(2, 100);
```

이 코드는 인덱스 2의 위치에 정수 100을 삽입하고 기존의 인덱스 2와 그 뒤에 있는 요소들을 모두 한 자리씩 뒤로 이동시킨다.  
하지만, 벡터에 1개의 요소(인덱스 0의 위치)만 들어있는 상태라면 이 코드가 실행될 때 예외가 발생한다.  
인덱스 1이 빈 공간이 되기 때문이다.

#### 벡터 내의 요소 알아내기

벡터의 요소를 읽기 위해 `get()` 또는 `elementAt()` 메소드를 사용한다.

```java
Vector<Integer> v = new Vector<Integer>();
v.add(5);
v.add(4);
v.add(-1);
```

다음은 인덱스 1에 있는 값을 읽는 코드이다.

```java
Integer obj = v.get(1);
int i = obj.intValue();
```

자동 언박싱 덕분에 다음과 같이 사용할 수 있다.

```java
int i = v.get(1);
```

#### 벡터의 크기와 용량 알아내기

#### size()

벡터에 저장된 요소의 개수를 반환한다.

```java
int len = v.size();
```

#### capacity()

벡터의 현재 용량을 반환한다.

```java
int cap = v.capacity();
```

크기(size)와 용량(capacity)은 서로 다르다.

예를 들어 벡터의 용량이 20이고 실제 저장된 요소가 5개라면

- size() = 5
- capacity() = 20

이다.

#### 벡터에서 요소 삭제

특정 위치의 요소를 삭제할 수 있다.

```java
v.remove(1);
```

실행 결과 인덱스 1의 요소가 삭제되고 뒤의 요소들은 한 칸씩 앞으로 이동한다.

객체를 이용하여 삭제할 수도 있다.

```java
Integer m = Integer.valueOf(100);

v.add(m);

v.remove(m);
```

모든 요소를 삭제하려면 다음과 같이 사용한다.

```java
v.removeAllElements();
```

또는

```java
v.clear();
```

두 메소드 모두 벡터의 모든 요소를 삭제한다.

### 3. 컬렉션과 자동 박싱/언박싱

컬렉션은 객체만 저장할 수 있기 때문에 기본 타입은 Wrapper 클래스로 변환하여 저장한다.  
예를 들어 다음 코드는 Integer 객체를 생성하여 저장하는 방법이다.

```java
Vector<Integer> v = new Vector<Integer>();
v.add(Integer.valueOf(4));
v.add(Integer.valueOf(-1));
```

하지만 자동 박싱 기능을 이용하면 다음과 같이 작성할 수 있다.

```java
v.add(4);
v.add(-1);
```

컴파일러가 자동으로 다음 코드로 변환한다.

```java
v.add(Integer.valueOf(4));
v.add(Integer.valueOf(-1));
```

반대로 컬렉션에서 값을 꺼낼 때는 자동 언박싱이 일어난다.

```java
int k = v.get(0);
```

위 코드는 실제로 다음과 같이 처리된다.

```java
int k = v.get(0).intValue();
```

자동 박싱과 자동 언박싱은 모든 컬렉션 클래스에서 동일하게 적용된다.

## 💻 실습 코드

- 실습 파일 바로가기:
  - [VectorEx.java](./.src/VectorEx.java)
  - [PointVectorEx.java](./.src/PointVectorEx.java)

---

# 📅 2026-06-10 (제네릭 컬렉션 활용)

## ✅ 배운 내용

### 1. 컬렉션을 매개변수로 받는 메소드 만들기

컬렉션 객체는 일반 객체와 마찬가지로 메소드의 매개변수로 전달할 수 있다.  
예를 들어 `Vector<Integer>`를 매개변수로 받아 벡터에 저장된 모든 요소를 출력하는 메소드는 다음과 같이 작성할 수 있다.

```java
public void printVector(Vector<Integer> v) {
    for(int i = 0; i < v.size(); i++) {
        int n = v.get(i);
        System.out.println(n);
    }
}
```

이 메소드는 다음과 같이 호출할 수 있다.

```java
Vector<Integer> v = new Vector<Integer>();
printVector(v);
```

매개변수의 타입을 `Vector<Integer>`로 지정하였기 때문에 정수만 저장하는 벡터만 전달할 수 있다.

### 2. 자바의 타입 추론 기능의 진화, Jaava 7, Java 10

다음은 제네릭 컬렉션 객체를 생성하는 전형적인 문법이다.

```java
Vector<Integer> v = new Vector<Integer>();
```

#### Java 7의 다이어몬드 연산자(<>) 도입

Java 7부터는 객체 생성부의 타입 매개변수를 생략할 수 있도록 다이어몬드 연산자(`<>`)를 지원한다.

```java
Vector<Integer> v = new Vector<>();
```

컴파일러가 왼쪽 선언부를 보고 타입을 자동으로 추론한다.

#### Java 10의 var 키워드

Java 10부터는 `var` 키워드를 이용하여 변수 타입 자체를 컴파일러가 추론하도록 할 수 있다.

```java
var v = new Vector<Integer>();
```

컴파일러는 위 코드를 다음과 같이 해석한다.

```java
Vector<Integer> v = new Vector<Integer>();
```

타입 추론 기능은 코드 작성량을 줄여주고 가독성을 높여준다.

### 3. ArrayList<E>

`ArrayList<E>`는 가변 크기의 배열을 구현한 컬렉션 클래스이며, `java.util.ArrayList` 패키지에 포함되어 있다.  
ArrayList는 Vector와 거의 동일한 기능을 제공하지만 중요한 차이점이 있다.

| 구분                    | Vector          | ArrayList       |
| ----------------------- | --------------- | --------------- |
| 동기화(Synchronization) | 지원            | 지원하지 않음   |
| 멀티스레드 환경         | 안전            | 주의 필요       |
| 실행 속도               | 상대적으로 느림 | 상대적으로 빠름 |

ArrayList는 동기화를 지원하지 않기 때문에 멀티스레드 환경에서는 데이터가 손상될 수 있다.  
하지만 동기화 처리에 따른 오버헤드가 없기 때문에 단일 스레드 환경에서는 Vector보다 더 빠르게 동작한다.  
ArrayList 역시 내부적으로 배열을 사용하며 인덱스를 통해 요소에 접근한다.  
인덱스는 0부터 시작한다.

#### ArrayList의 생성

문자열만 저장하는 ArrayList는 다음과 같이 생성한다.

```java
ArrayList<String> a = new ArrayList<String>();
```

Java 7 이후에는 다음과 같이 작성할 수도 있다.

```java
ArrayList<String> a = new ArrayList<>();
```

ArrayList는 내부 용량을 자동으로 조절하므로 일반적으로 용량을 직접 관리할 필요가 없다.

#### ArrayList에 요소 삽입

`add()` 메소드를 사용하여 요소를 추가할 수 있다.

```java
a.add("Hello");
a.add("Hi");
a.add("Java");
```

제네릭 타입을 `String`으로 지정했기 때문에 문자열만 저장할 수 있다.

다음 코드는 오류가 발생한다.

```java
a.add(5);
a.add(new Point(3, 5));
```

ArrayList에도 `null`을 저장할 수 있다.

```java
a.add(null);
```

중간 위치에 요소를 삽입할 수도 있다.

```java
a.add(2, "Sahni");
```

이 경우 기존 인덱스 2 이후의 요소들은 한 칸씩 뒤로 이동한다.  
주의할 점은 존재하지 않는 위치에 삽입하면 예외가 발생한다는 것이다.

#### ArrayList 내의 요소 알아내기

ArrayList의 요소는 `get()` 메소드를 이용해 읽는다.

```java
String str = a.get(1);
```

위 코드는 인덱스 1에 있는 문자열을 반환한다.

#### ArrayList의 크기 알아내기

현재 저장된 요소의 개수는 `size()` 메소드로 알 수 있다.

```java
int len = a.size();
```

ArrayList는 Vector와 달리 현재 용량을 반환하는 `capacity()` 메소드를 제공하지 않는다.

#### ArrayList에서 요소 삭제

특정 위치의 요소를 삭제하려면 `remove()` 메소드를 사용한다.

```java
a.remove(1);
```

실행 결과 인덱스 1의 요소가 삭제되고 뒤에 있는 요소들은 한 칸씩 앞으로 이동한다.  
객체를 이용하여 삭제할 수도 있다.

```java
String s = new String("bye");
a.add(s);
a.remove(s);
```

ArrayList의 모든 요소를 삭제하려면 다음과 같이 사용한다.

```java
a.clear();
```

## 💻 실습 코드

- 실습 파일 바로가기: [ArrayListEx.java](./.src/ArrayListEx.java)

---

# 📅 2026-06-11 (제네릭 컬렉션 활용)

## ✅ 배운 내용

### 1. 컬렉션의 순차 검색을 위한 Iterator

Vector, ArrayList, LinkedList, HashSet과 같이 여러 요소를 저장하는 컬렉션에서는 요소를 순차적으로 검색해야 하는 경우가 많다.  
이때 `java.util.Iterator<E>` 인터페이스를 사용하면 컬렉션의 종류와 상관없이 동일한 방법으로 요소를 순차적으로 탐색할 수 있다.

예를 들어 `Vector<Integer>` 컬렉션이 있을 때 다음과 같이 Iterator 객체를 생성한다.

```java
Vector<Integer> v = new Vector<Integer>();
```

다음과 같이 벡터 v의 `iterator()`를 호출하여 벡터 v의 각 요소를 순차적으로 검색할 수 있는 Iterator 객체를 얻어낸다.  
Iterator 객체를 **반복자(iterator)** 라고 부른다.

```java
Iterator<Integer> it = v.iterator();
```

벡터 v의 요소 타입에 맞추어 Iterator<E>의 E에 Integer를 지정하였다.  
이제 it 객체를 이용하면 벡터의 각 요소를 순차적으로 검색할 수 있다.

다음은 it를 이용하여 v의 각 요소를 순차 방문하는 코드이다.  
처음 `it.next()`는 v의 첫 번째 요소를 반환하고, Iterator는 다음 요소를 가리킨다.

```java
while(it.hasNext()) {
    int n = it.next();
    ....
}
```

### 2. Iterator의 주요 메소드

| 메소드              | 설명                                |
| ------------------- | ----------------------------------- |
| `boolean hasNext()` | 방문할 요소가 남아 있으면 true 반환 |
| `E next()`          | 다음 요소 반환                      |
| `void remove()`     | 마지막으로 반환된 요소 제거         |

## 💻 실습 코드

- 실습 파일 바로가기: [IteratorEx.java](./.src/IteratorEx.java)

---

# 📅 2026-06-13 (제네릭 컬렉션 활용)

## ✅ 배운 내용

### 1. HashMap<K, V>

`HashMap<K, V>` 컬렉션은 `java.util.HashMap` 클래스이며, **키(Key)** 와 **값(Value)** 의 쌍으로 구성되는 요소를 저장한다.

- K : 키(Key)로 사용할 데이터 타입
- V : 값(Value)으로 사용할 데이터 타입

해시맵은 내부적으로 해시(Hash) 기법을 이용하여 데이터를 저장하고 관리한다.

다음은 해시맵을 생성하고 요소를 저장 및 검색하는 예시이다.

```java
HashMap<String, String> h = new HashMap<String, String>();
h.put("apple", "사과");
String kor = h.get("apple");
```

`put(key, value)` 메소드는 키와 값을 해시맵에 저장한다.

```java
h.put("apple", "사과");
```

`get(key)` 메소드는 키에 대응하는 값을 반환한다.

```java
String kor = h.get("apple");
```

해시맵은 해시 함수를 이용하여 저장 위치를 자동으로 결정하므로, 사용자는 데이터가 실제로 어디에 저장되는지 알 필요가 없다.  
또한 요소가 삽입된 순서와 실제 저장 위치는 서로 관계가 없다.

### 2. HashMap의 장단점

#### 장점

- 요소의 삽입 속도가 빠르다.
- 요소의 삭제 속도가 빠르다.
- 키를 이용한 검색 속도가 매우 빠르다.
- 데이터 개수가 많아도 효율적으로 검색할 수 있다.

#### 단점

- 인덱스를 이용하여 접근할 수 없다.
- 반드시 키(Key)를 이용해야 값을 검색할 수 있다.
- 저장 순서가 유지되지 않는다.

따라서 HashMap은 **빠른 삽입과 검색이 필요한 응용 프로그램**에 적합하다.

### 3. HashMap의 주요 메소드

| 메소드                                | 설명                           |
| ------------------------------------- | ------------------------------ |
| `void clear()`                        | 해시맵의 모든 요소 삭제        |
| `boolean containsKey(Object key)`     | 지정한 키가 존재하면 true 반환 |
| `boolean containsValue(Object value)` | 지정한 값이 존재하면 true 반환 |
| `V get(Object key)`                   | 키에 대응하는 값 반환          |
| `boolean isEmpty()`                   | 비어 있으면 true 반환          |
| `Set<K> keySet()`                     | 모든 키를 Set 컬렉션으로 반환  |
| `V put(K key, V value)`               | 키와 값 저장                   |
| `V remove(Object key)`                | 키와 값 삭제                   |
| `int size()`                          | 저장된 요소 개수 반환          |

### 4. HashMap 생성

HashMap은 키와 값의 타입을 지정하여 생성한다.  
다음은 영어 단어와 한글 뜻을 저장하는 해시맵이다.

```java
HashMap<String, String> h = new HashMap<String, String>();
```

### 5. HashMap에 요소 삽입

`put()` 메소드를 사용하여 키와 값을 저장한다.

```java
h.put("baby", "아기");
h.put("love", "사랑");
h.put("apple", "사과");
```

### 6. 키(Key)로 값(Value) 검색

`get()` 메소드에 키를 전달하면 해당 값을 얻을 수 있다.

```java
String kor = h.get("love");
```

실행 결과

```text
사랑
```

존재하지 않는 키를 검색하면 `null`이 반환된다.

```java
String kor = h.get("babo");
```

### 7. 키(Key)로 요소 삭제

`remove()` 메소드를 사용하여 요소를 삭제할 수 있다.

```java
h.remove("apple");
```

이 코드는 키가 `"apple"`인 요소를 삭제한다.

### 8. 요소 개수 알아내기

해시맵에 저장된 요소의 개수는 `size()` 메소드로 확인한다.

```java
int n = h.size();
```

### 9. HashMap 전체 검색

해시맵에 저장된 모든 데이터를 출력하려면 먼저 `keySet()`을 이용해 모든 키를 얻은 후, Iterator를 사용하여 순차적으로 접근한다.

```java
Set<String> keys = h.keySet();
Iterator<String> it = keys.iterator();
while(it.hasNext()) {
    String key = it.next();
    String value = h.get(key);
    System.out.println("(" + key + ", " + value + ")");
}
```

## 💻 실습 코드

- 실습 파일 바로가기:
  - [HashMapDicEx.java](./.src/HashMapDicEx.java)
  - [HashMapScoreEx.java](./.src/HashMapScoreEx.java)
  - [HashMapStudentInfoEx.java](./.src/HashMapStudentInfoEx.java)
