# 작동 원리

## Main
 - Prompt 객체 호출, run()메서드 실행

## Prompt
 - 실제 실행되는 메서드 run()을 정의
 - void run() : Dans 객체 생성, Dans 출력

## Dans
 - 전역변수 : 시작단 및 끝단을 지정한 변수 startDan, endDan
 - Dans(int startDan, int endDan) : 생성자
 - static Dans getDans() : 시작단, 끝단을 사용자 입력으로부터 받아 Dans 객체 반환
 - void toString() : 시작단부터 끝단까지의 문자열을 반환 (Object의 toString() 오버라이드)
