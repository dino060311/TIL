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
  [VectorEx.java](./.src/VectorEx.java)
  [PointVectorEx.java](./.src/PointVectorEx.java)