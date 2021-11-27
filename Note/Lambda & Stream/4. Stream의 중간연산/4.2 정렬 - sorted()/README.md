---

## <a href = "../../README.md" target="_blank">Lambda & Stream</a>

### 4. Stream의 중간연산
#### 4.2 정렬 - sorted()
1) 정렬의 필요조건
2) Stream의 정렬 - sorted()
3) Comparator<T> 재학습

---

# 4.2 정렬 - sorted()

기본적으로 Stream 클래스는 다음과 같은 정렬 메서드를 제공하고 있다.

1. Stream<T> sorted() : 기본정렬기준에 의한 정렬
2. Stream<T> sorted​(Comparator<? super T> comparator) : 사용자 정의 기준에 의한 정렬

결국 sorted안에 어떤 Comparator를 넣느냐가 문제가 된다.

---

## 1) 정렬의 필요조건
- 정렬대상 및 정렬대상들의 데이터군
  - 정렬대상 : T
  - 정렬대상들의 데이터군 : `Stream<T>`을 통해 데이터소스를 수정하지 않고 데이터처리
- 정렬 기준
  - 기본정렬기준 : T의 `Comparable` 구현
  - 사용자 정의 정렬기준 : `Comparator<T>` 구현체

---

## 2) Stream의 정렬 - sorted()
1. Stream<T> sorted() : 기본정렬기준에 의한 정렬
2. Stream<T> sorted​(Comparator<? super T> comparator) : 사용자 정의 기준에 의한 정렬

---

## 3) Comparator<T> 재학습
앞에서 람다식, 함수형 인터페이스를 학습한 지식을 기반으로 interface Comparator를 다시 학습해 추가 지식을 확보한다.

interface `Comparator<T>` : <a href="../../../Collection Framework/6. 정렬/6.2 interface Comparator/README.md" target="_blank">문서 참고</a>

---

