---

## <a href = "../../README.md" target="_blank">Lambda & Stream</a>

### 3. Stream
#### 3.2 Stream 생성
1) 컬렉션 기반 Stream
2) 가변인자, 배열 기반 Stream
3) 특정 범위의 정수
4) 난수 Stream
5) 람다식 기반 Stream : iterate(), generate()
6) 파일 기반
7) 빈 스트림
8) 두 스트림의 연결
---

# 3.2 Stream 생성

## 1) 컬렉션 기반 Stream
```
Stream<T> Collection.stream()
```

---

## 2) 가변인자, 배열 기반 Stream
```
Stream<T> Stream.of(T... values)
Stream<T> Stream.of(T[] tArr)
Stream<T> Arrays.stream(T[] tArr)
Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive) // start <= index < end
```

### (cf) 기본형 Stream을 취급하고 싶을 경우
```
IntStream IntStream.of(int ...values)
IntStream IntStream.of(int[] intArr)
IntStream Arrays.stream(int[] intArr)
IntStream Arrays.stream(int[] intArr, int startInclusive, int endExclusive) // start<= index < end
```

---

## 3) 특정 범위의 정수
IntStream, LongStream은
지정 범위의 연속된 정수를 Stream으로 생성해서 반환하는 static 메서드 range(), rangeClosed()를 가지고 있다.

1. range() : end 미포함
```
IntStream intStream = IntStream.range(int begin, int end)
LongStream longStream = LongStream.range(long begin, long end)
```

2. rangeClosed() : end 포함
```
IntStream intStream = IntStream.rangeClosed(int begin, int end)
LongStream longStream = LongStream.rangeClosed(long begin, long end)
```

---

## 4) 난수 Stream
java.util.Random 클래스에는 Stream으로 난수들을 반환하는 여러가지 인스턴스 메서드들이 정의되어 있다.

1. 무한 난수 Stream
```
IntStream ints() : Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
LongStream longs() : LONG.MIN_VALUE <= longs() <= LONG.MAX_VALUE
DoubleStream doubles() : 0.0 <= doubles() < 1.0
```

2. 난수의 갯수 제한
각 기본형 변수 Stream에 .limit(long streamSize)를 지정해주면, 지정 값만큼을 크기로 하는 Stream으로 만들어줌
```
IntStream intStream = new Random().ints().limit(5); // 유한 Stream (5개)
```

3. 난수의 범위 제한
   - end는 범위에 포함되지 않는다.
```
IntStream ints(int begin, int end)
LongStream longs(long begin, long end) 
DoubleStream doubles(double begin, double end)
```

4. 난수의 갯수, 범위 모두 제한
```
IntStream ints(long streamSize, int begin, int end)
LongStream longs(long streamSize, long begin, long end)
DoubleStream doubles(long streamSize, double begin, double end)
```

---

## 5) 람다식 기반 Stream : iterate(), generate()

Stream 클래스의 static 메서드인 iterate(), generate()는 인자로 한 람다식을 기반으로 무한 Stream을 반환한다.

1) iterate() : 초깃값(seed) 지정, 이전 요소에 종속적 (수학 : 수열의 점화식)  
   - 초깃값(seed)를 지정하여, 지정된 값부터 시작하여 람다식 f에 의해 계산된 결과를 다음 Seed값으로 하길 반복함.
```
static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
```

2) generate() : 초깃값 지정 x, 이전 요소에 독립적
   - 초깃값(seed) 없음. 람다식이 Supplier(입력이 없고 return만 있음)
```
static <T> Stream<T> generate(Supplier<T> s)
```

3) 주의점 : 기본형 Stream으로 생성할 수 없음.
   - 굳이 필요하다면 mapToInt()와 같은 메서드를 사용해야함. 
     - 예> IntStream evenStream = Stream.iterate(0, n->n+2).mapToInt(Integer::ValueOf)
   - (cf) IntStream을 Stream<Integer>로 변경시에는 boxed() 메서드를 쓰면 됨
     - 예> Stream<Integer> stream = evenStream.boxed();
---

## 6) 파일 기반
java.nio.files.Files : 파일을 다루는데 필요한 유용한 메서드들을 제공  

1. 지정 디렉토리의 파일들 기반
   
   ```
   Stream<Path> Files.list(Path dir)
   ```
   - 지정된 디렉토리에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.
   - Path는 하나의 파일 또는 경로를 다루는 클래스
     - Paths.get(String directory) : 지정 디렉토리에 속한 파일들에 관한 정볼르 가진 객체 반환

2. 지정 파일의 텍스트 기반
   ```
   Stream<String> Files.lines(Path path)
   Stream<String> Files.lines(Path path, Charset cs)
   ```
   - 지정 파일의 행단위(line)를 요소로 하는 Stream을 생성  

(cf) Stream<String> lines() // BuffereReader의 메서드 
   - 파일 뿐 아니라, 다른 입력대상으로부터 데이터를 행단위로 읽어올 수 있음
---
   
## 7) 빈 스트림
```
Stream emptyStream = Stream.empty()
```
- 비어있는 Stream을 생성해서 반환함.
- long count() 메서드를 사용해보면 0이 반환되는 것을 확인할 수 있다.

---

## 8) 두 스트림의 연결
```
Stream<T> concatStream = Stream.concat(Stream<T> stream1, Stream<T> stream2)
```
- 두 스트림을 하나로 연결함.
- stream1의 요소들 뒤에 stream2의 요소들이 병합됨
- 병합에 사용된 Straem들은 더 이상 사용할 수 없다.

---
