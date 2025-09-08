---
name: "\U0001F41B Bug Fix"
about: 버그 발견 및 수정
title: "[BUG] "
labels: bug
assignees: ''

---

## 🐞 버그 설명
<!-- 어떤 문제가 발생했는지 -->
- 

## 📍 재현 방법
<!-- 문제가 재현되는 과정을 단계별로 -->
1.
2.
3.

## 💻 환경  
OS:  
Java Version:  
Spring Boot Version:  
DB/Redis 버전:  

## 📝 변경 파일
<!-- 실제 수정한 파일 경로/이름 나열 -->
- `path/to/FileA.java`
- `path/to/service/ExampleService.java`

## 🔧 변경 내역
<!-- 코드/로직 변경 요약 (가능하면 전/후 비교 한 줄씩) -->
- 예) NPE 방지: `obj.getX()` → `Optional.ofNullable(obj).map(X::get)...`
- 예) 쿼리 수정: `LEFT JOIN` → `INNER JOIN` (중복 제거)
- 예) 캐시 키 변경: `user:{id}` → `user:v2:{id}` (호환성 유지)


## 📌 추가 참고 사항
