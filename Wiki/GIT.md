# Git과 GitHub에 대해 알아보자

## 1. Git, GitHub은 뭔데?
- Git : 소스코드 버전관리 시스템
- Git을 개인 컴퓨터에서만 사용하면 그것만으로도 개인 버전관리가 가능 (로컬저장소)
- Git으로 관리하는 프로젝트를 원격저장소에 업로드하여, 다수의 사람들이 협업할 수도 있음
    - 원격 저장소의 종류 : 자체 서버, GitHub, GitLab, BitButcket.org, ...

## 2. 버전관리 시작하기
- [Git 설치](https://git-scm.com/downloads) : 제일 최신 버전으로, 자신의 OS에 맞게 설치
- Git Bash나 Terminal에서 git을 입력했을 때 각종 명령어에 대한 안내가 출력될 경우, 정상적으로 설치가 완료된 것.
- [GitHub 가입](https://github.com/https://github.com/) : 인증 이메일 확인하여 가입절차 마쳐야하는 것에 주의

## 3. Git의 기능 학습
Pro git : [링크](https://git-scm.com/book/ko/v2)

## 4. 변경자 정보 설정
- 버전 변경(commit)을 할 때마다 변경자의 정보를 기입해야함.
- 매번 버전 변경을 할 때마다 변경자 정보 기입을 수동으로 하긴 번거로우니 글로벌 설정을 한 번에 해두자.
```
git config --global user.email 메일주소
git config --global user.name "유저명"
```
- 이 때, 유저명과 메일주소는 github 계정정보를 따라가도록 할 것.

## 5. 로컬 저장소 생성
- 로컬 저장소 : Git으로 관리되는 디렉토리, 실제로 내 컴퓨터에 존재하는 폴더.
- init : 지정 디렉토리를 Git 으로 관리하겠다고 선언하는 것.
- init 방법
  1. 디렉토리에 마우스를 두고 우클릭 > Git Bash Here을 통해 현재 경로로 Git Bash를 이끌어 오기
     (cf : 터미널에서 cd 명령어를 통해 해당 경로까지 이동해도 됨)
  2. git init을 입력하여 현재 경로를 로컬 저장소로 선언
  ```
  git init
  ```
  3. 이 시점에서, .git 폴더가 생성됨.이 폴더는 Git으로 생성된 버전 정보와, 원격 저장소 정보 등의 정보가 저장됨.
  4. 실제 .git 폴더를 통해 버전 관리가 되므로 .git 폴더를 로컬저장소라 칭하기도 함.(팀개발을 위한 Git, GitHub 시작하기 p.15)


## 6. Commit

- 버전관리의 의미에서 commit이란 단어의 정의 : [위키백과](https://ko.wikipedia.org/wiki/%EC%BB%A4%EB%B0%8B_(%EB%B2%84%EC%A0%84_%EA%B4%80%EB%A6%AC))


## 7. .gitgnore

**<center> 설정파일로 더럽혀진 repository를 보아라. 이 얼마나 끔찍한가? </center>**
- git으로 소스파일들을 관리할 때, 올리면 안 될 것들(로그파일, ide 설정파일 등)은 올리지 않도록 해야함. (배포받는 측 고려)
- 버전관리의 대상이 되는 디렉토리(.git 폴더가 위치한 경로)에 .gitignore 파일을 생성 후, 제외할 파일들을 지정해야함
- 이미 잘못 커밋한 파일을, .ignore에 작성하면 제거되지 않으므로 수동으로 이를 정리할 필요가 있음
- 자동 .ignore 생성 사이트 : <a href="https://www.toptal.com/developers/gitignore" target="_blank">gitignore.io</a>
- .ignore 작성법 : <a href ="https://git-scm.com/docs/gitignore" target="_blank">git 공식 문서</a>
- 예시
  ```
  # User-specific stuff
  .idea/**/workspace.xml
  .idea/**/tasks.xml
  .idea/**/usage.statistics.xml
  .idea/**/dictionaries
  .idea/**/shelf
  
  # AWS User-specific
  .idea/**/aws.xml
  
  # Generated files
  .idea/**/contentModel.xml
  
  # Sensitive or high-churn files
  .idea/**/dataSources/
  .idea/**/dataSources.ids
  .idea/**/dataSources.local.xml
  .idea/**/sqlDataSources.xml
  .idea/**/dynamic.xml
  .idea/**/uiDesigner.xml
  .idea/**/dbnavigator.xml
  
  # Gradle
  .idea/**/gradle.xml
  .idea/**/libraries
  ```