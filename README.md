# Coding-Test-Study

- 백준 : 실버 3 이상
- 프로그래머스 : Lv2 이상

<br>

## 📎 참여방법

1. "깃허브아이디/algorithm"으로 된 branch를 새로 만든다.
   
   ```
   // branch 생성과 변경을 함꼐
   git checkout -b "브랜치명"

   // branch 변경
   git checkout "브랜치명"
   ```  
2. 만들어진 branch에 본인 `깃ID`로 된 폴더를 생성한다.
3. 생성된 폴더에 자신의 소스코드를 업로드 한다. (폴더명에 콜론":" 안됩니다!)
4. 이때 commit 규칙을 지키도록한다!
5. "main" branch로 `Pull Request`를 한다. (매주 주말에 Merge예정)
6. 다른 사람들의 PR을 보고 자유롭게 코드리뷰를 한다.
7. *주의!! 기존 폴더를 지우면 안됩니다!! 개인 폴더 내부만 수정해주세요 :)*

<br>

## ❗️ 소스코드 파일 이름 규칙

- 자유롭게 작성
- 폴더명 또는 소스코드 파일명에 콜론 ":", "?", "!" 등 특수문자 안됩니다 :D

<br>

## 🙏 commit 규칙

- commit 메세지: [문제 출처(플랫폼)] 문제이름 / 난이도 / 걸린시간
- description: 문제 주소 (option)
- 터미널에서 작성법: <br>
`git commit -m "[BOJ] Hello World / 브론즈5 / 1분" -m "https://www.acmicpc.net/problem/2557"`
- 만약, 시도했지만 해결하지 못한 경우 커밋에 표기 <br>
`git commit -m "[BOJ] Hello World / 브론즈5 / 1분 (시도 중)" -m "https://www.acmicpc.net/problem/2557"`
> 플랫폼 작성법 통일
   > - [BOJ] - 백준
   > - [PGS] - 프로그래머스
   > - [LTC] - 리트코드
   > - [CFS] - 코드포스
   > - [SEA] - 삼성SW Expert Academy
   > - [ETC] - 그외


<br>

## 🙏 pr 규칙

### ⭐️ pr 생성 방법

- 풀이하신 코드는 본인 브랜치에 커밋 후 pr을 생성해서 올려주세요 (매주 일요일 merge)
  - pr 제목 <br>
    `[2024년 3월 넷째주]브랜치명`
- 시도했지만 해결하지 못한 문제가 있는 경우 풀이 흔적 또는 틀린 코드를 함께 올려주세요.
- pr 생성하실 때는 **언어 라벨**을 추가해주세요. (필요 시, **상태 라벨** 추가)
> 상태 라벨
> - I'm trying 🔥: 시도했지만 해결하지 못한 문제가 있는 경우
> - Question ❓: 질문이 있는 경우
> - Flag 🏳️: 나중에 다시 풀어볼 문제가 있는 경우

<br>

### ⭐️ pr merge 후 할 일

- main 브랜치의 변경사항을 본인 브랜치에 업데이트해주세요
```
$git fetch --all
$git merge origin/main
// 커밋 생략 가능
$git push [브랜치명]
```

<br>


## 💗 하면 좋은 것들

### 💬 코드 리뷰

- 매주 일요일 pr merge 전까지 다른 사람들의 pr에 코드 리뷰를 할 수 있어요.
- 칭찬, 질문, 다른 풀이방법 공유 등 자유롭게 남겨요. (무조건 비판 X)

<br>

### 🙋🏻‍♂️ 질문

- Issue를 생성하여 자유롭게 질문해요.
- Issue 생성하실 때는 **라벨**을 추가해주세요.

