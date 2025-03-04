## 1. 프로젝트 소개
**사용자로부터 수를 입력받아 사칙연산을 수행하는 `Java` 기반의 계산기 프로그램**

<br>

### 2. 기능
✅ 사칙연산 (덧셈, 뺄셈, 곱셈, 나눗셈)<br>
✅ 현재 연산 결과값 보다 큰 이전의 연산 결과값들 출력<br>
✅ 예외 처리 (사용자 입력, 나눗셈 etc.)<br>
✅ 실행 종료<br>
<br><br>

### 3. 실행 화면
<img width="50%" alt="image" src="https://github.com/user-attachments/assets/5c9abf55-e701-4bae-bcd3-3a3aa3e1cb27" />

<img width="50%" alt="image" src="https://github.com/user-attachments/assets/e1b97b6b-2a2e-4183-97e0-b354a4413ad0" />
<br><br>

### 4. 트러블 슈팅
### Git 사용 관련
#### README.md 생성 후 충돌
**⛔ 문제**
```bash
! [rejected]        main -> main (non-fast-forward)
error: failed to push some refs to 'https://github.com/.../'
```
- github 원격 레포지토리에 README.md 생성 후, 로컬에서 main으로 push 시도 시 다음과 같은 에러가 발생하며 push 거부
- git pull 도 동작하지 않음
<br>

**❓ 원인**
- **non-fast-forward**: 로컬과 원격 브랜치가 서로 다른 커밋을 포함함.
--> 원격의 README.md 생성 커밋이 로컬 브랜치 커밋 기록에는 존재 X

- **git pull 거부**: pull 명령어는 fetch+merge 으로, merge는 공통된 commit 지점이 존재해야 그 지점부터 병합함.
--> 첫 커밋이므로 공통된 commit 지점이 없었음
<br>


**❗ 해결**

**1. 강제 push**
```bash
git push origin main --force
```
- `--forece` 옵션으로 강제 push
- 로컬 브랜치의 내용을 원격 브랜치에 덮어쓰게 되니 **주의**
<br>

**2. 연관 없는 저장소 병합 옵션**

```bash
git pull origin master --allow-unrelated-histories
```
- `--allow-unrelated-histories`  옵션으로 연관 없는 저장소끼리 병합
<br>

**3. 충돌 파일 직접 수정**
- 충돌 파일을 로컬에서 직접 수정한 후 다시 커밋 시도
--> 충돌난 파일이 로컬에 존재하지 않으므로 시도는 하지 않음
<br>

- 초기 프로젝트 설정이므로 **1번 방법**을 사용하여 **강제 push** 하였음
- 그 후 원격에서 다시 README.md 생성 후 `git pull`을 통해 받아오는 것으로 충돌 해결
<br><br>

### 예외 처리
**⛔ 문제**
`ArithmeticCalculator` 클래스에서 예외 발생 시 `App` 클래스까지 예외 전달되지 않는 상황
- 예외 발생 시 다시 App 클래스의 피연산자 입력 부분으로 돌아가야 하지만 의도대로 동작하지 않음
<br>

**❓ 원인**
- `ArithmeticCalculator` 클래스 내부에서 `throws`를 사용하지 않아 예외 전달이 되지 않음
<br>

**❗ 해결**
- 프로그램의 실행 흐름을 파악하여, `App` 클래스까지 예외 전달을 하여 예외 발생 시 프로그램이 다시 입력받는 부분으로 돌아갈 수 있게끔 변경
<br><br>

### 제네릭
#### 제네릭 타입 한정 (extends Number)
**⛔ 문제**
```bash
'ClassName'은(는) abstract로 선언되거나 'Number'에서 추상 메서드 'intValue()'을(를) 구현해야 합니다
```
- 제네릭 클래스에 Number 타입 한정 시 위와 같은 에러 메세지 발생
<br>

**❓ 원인**
```java
public class ClassName <T> extends Number {
	...
}
```
- 제네릭 클래스 선언 시, 꺽쇠 밖에 `extends` 키워드 사용
---> 클래스 상속 키워드 `extends`와 혼동
<br>

**❗ 해결**
```java
public class ClassName <T extends Number> {
	...
}
```
- 꺽쇠 안에 `extends`를 선언하여 올바르게 제네릭 타입 한정 사용

<br><br>

#### 프로젝트 TIL
https://velog.io/@yoon17710/TIL-%EA%B3%84%EC%82%B0%EA%B8%B0-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8 
