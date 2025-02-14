# hello-limbo-db

## 🎯 토이 프로젝트 목표

LimboDB Java 바인딩을 활용하여 데이터베이스와 상호 작용하는 작은 프로젝트를 진행하며, 

JDBC 기반의 기본 기능과 네이티브 코드(JNI) 기반 데이터베이스 사용법을 익히는 것이 목표한다.

---

## 📌 목표

- Java 애플리케이션에서 LimboDB를 활용하여 `데이터 저장 및 조회` 실습

- LimboDB `바인딩의 내부 동작`을 이해하고 직접 적용해보기

- LimboDB 인스턴스 관리 및 데이터베이스 파일 사용법 연습
- 트랜잭션`(commit, rollback)`과 SQL 예외 처리 경험
- `네이티브 코드(JNI)`와 `JDBC 드라이버`의 동작 방식 익히기

---

## 📝 프로젝트 개요: "LimboDB를 활용한 간단한 회원 관리 시스템"

```
스타트업의 회원 관리 시스템을 LimboDB를 활용하여 구축하는 연습을 합니다.
```

- 데이터베이스: LimboDB (파일 기반 데이터 저장)

- JDBC 드라이버: `LimboConnection`, `LimboStatement`, `LimboResultSet` 활용

- 파일 기반 데이터베이스: members.db라는 파일을 사용하여 데이터 저장
- SQL 사용: `CREATE TABLE`, `INSERT`, `SELECT`, `UPDATE`, `DELETE` 실행

---


## 시운전



https://github.com/user-attachments/assets/a642f329-2e8b-4e7f-ab81-6bbeb7d65213





## 1️⃣ 프로젝트 기능 목록

| 기능          | 설명 |
|-------------|------------------------------------------------|
| 1. 회원 추가 | 새로운 회원 정보를 데이터베이스에 추가 |
| 2. 회원 목록 조회 | 현재 저장된 모든 회원 정보를 확인 |
| 3. 특정 회원 조회 | 특정 ID를 가진 회원의 정보를 검색 |
| 4. 회원 정보 수정 | 특정 회원의 정보를 변경 |
| 5. 회원 삭제 | 특정 회원을 데이터베이스에서 삭제 |
| 6. 트랜잭션 처리 | 여러 회원 데이터를 한 번에 저장 후 commit / rollback 실습 |
| 7. SQL 예외 처리 | SQL 실행 중 오류 발생 시 SQLException 처리 |


## 2️⃣ 프로젝트 기술 구성

| 기술               | 설명 |
|------------------|------------------------------------------------|
| Java 17         | 최신 Java 문법을 활용하여 구현 |
| Gradle          | 프로젝트 빌드                |
| LimboDB (JDBC 사용) | `LimboConnection`, `LimboStatement`, `LimboResultSet` 사용 |
| 파일 기반 DB 사용 | `members.db` 생성하여 데이터 저장 |
| SQL 활용        | `CREATE TABLE`, `INSERT`, `SELECT`, `UPDATE`, `DELETE` 활용 |


## 3️⃣ 디렉토리 구조 예시

```markdown
hello-limbo-db
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── hello
│   │   │   │   ├── core
│   │   │   │   │   ├── LimboDatabaseManager.java  // DB 연결 관리
│   │   │   │   │   ├── Member.java  // 회원 데이터 객체
│   │   │   │   │   ├── MemberRepository.java  // JDBC를 통한 데이터 관리
│   │   │   │   │   ├── MemberService.java  // 비즈니스 로직
│   │   │   │   │   ├── Main.java  // 실행 진입점
│   │   ├── resources
│   │   │   ├── application.properties
├── members.db  // SQLite 기반 데이터 파일 (자동 생성)
├── build.gradle
├── settings.gradle
├── README.md
```
