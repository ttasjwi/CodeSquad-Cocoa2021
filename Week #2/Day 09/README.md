# Day 09

Date : 2021.11.11 (Thu)  
학습 내용 : 리뷰 및 수업

---

# 복습

 
## 자바 변수의 기본 타입들

 
## 참조형

## 객체

## 함수/메서드

## 클래스

## 클래스의 상속


## 자바 컬렉션 라이브러리

1. 왜 필요한가?
    - 다량의 데이터들을 저장하여 표준화된 방법으로 다루기 위함.
2. 가장 많이 사용되는 컬렉션 라이브러리는?
   - List (대부분)
   - Map
3. 컬렉션별 용도들
   1. List : 저장 순서 존재, 중복을 허용한다.
   2. Set : 저장 순서 존재 x, 중복을 허용하지 않는다.
   3. Map : 저장 순서 존재 x, (Key, Value) 쌍으로 자료를 저장하며, Key의 중복을 허용하지 않는다.
4. List, Map, Set

## 컬렉션을 이용한 객체의 정렬
### 1. 객체에 인터페이스 Comparable<T>을 구현하여 정렬하는 방법
- 어떤 객체의 기본 정렬 기준을 구현하는데 사용
- java.lang 패키지에 존재하기 때문에 별도의 import 필요 없음.
- public int compareTo(T t) 을 완성하면 됨
  - 반환값 음수 : 작은 겂이 앞에 정렬됨.
  - 반환값 0 : 정렬 순위가 같다.
  - 반환값 양수 : 뒤에 정렬됨.
  - jdk 라이브러리에 포함된 대다수의 메서드들은 Comparable이 구현되어 있다.
    - 예) 래퍼클래스(Integer, Double, ...) , String, LocalDate, LocalTime, ...
### 2. 인터페이스 Comparator<T> 의 구현체를 통한 정렬
- 별도의 정렬기준을 구현하는데 사용.
- import java.util.Comparator;
- public int compare(T t1, T t2) 을 완성하면 됨.
  - 반환값이 음수 : 작은 값이 앞에 정렬됨
  - 반환값이 0 : 정렬 순위가 같다.
  - 반환값이 양수 : 뒤에 정렬됨.
### 3. List의 sort()메서드, Arrays.sort(), Collections.sort() 메서드
- 지정 배열, 컬렉션을 정렬함.
- List의 sort()
  - default void sort(Comparator<? super E> c) : List인터페이스의 디폴트 메서드. 1.8부터 사용 가능.
- Arrays.sort()
    - public static void sort(Object[] a) : Comparable 구현에 의한 정렬
    - public static <T> void sort(T[] a, Comparator<? super T> c) : Comparator 구현에 의한 정렬
- Collections.sort()
  - public static <T extends Comparable<? super T>> void sort(List<T> list) : Comparable 구현에 의한 정렬
  - public static <T> void sort(List<T> list, Comparator<? super T> c) : Comparator 구현에 의한 정렬


### 4. TreeSet, TreeMap
- 이진 탐색 트리(binary search tree) 자료구조의 형태로 데이터를 저장
- 생성 시, Comparator를 인자로 하여 정렬기준을 지정할 수 있음.
- 별도로 정렬기준을 지정하지 않았을 경우, Comparable 구현에 의한 정렬

### 5. Stream의 sorted() 메서드를 이용한 정렬
  - 배열을 정렬할 때는 Arrays.sort, 컬렉션을 정렬할 때는 Collections.sort()를 사용해야하는 등 각 저장방식에 따라 정렬 방식이 표준화되어 있지 않음.
  - Stream을 이용하여 표준화된 방식으로 데이터를 다룰 수 있음.
  - Stream<T> sorted() : Comparable 구현에 의한 정렬
  - Stream<T> sorted(Comparator<? super T> comparator) : Comparator 구현에 의한 정렬
    - Comparator 대신 int값을 반환하는 람다식을 사용하는 것도 가능

## 리뷰 및 피드백

## 더 공부할 주제들
- 자바 제네릭
- 자바 람다 문법
- 람다의 활용

