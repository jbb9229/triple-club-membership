# triple-club-membership

## Required (Mac)

Gradle
```
brew install gradle
```

jdk version 11 ↑
```
brew install openjdk@11
```

Git
```
brew install git
```

## How To Run?
Git Clone Project : https://github.com/jbb9229/ShareYourTrip.git

```
{project path}/gradle build
```

![](https://velog.velcdn.com/images/jbb9229/post/06e7c689-47b5-4b5d-8cd2-c4233eae21c1/image.png)

```
java -jar {project path}/build/libs/Triple-0.0.1-SNAPSHOT.jar
```

## H2-console
해당 프로젝트는 H2 인메모리 DB를 사용중입니다.
프로젝트 실행 후 [H2-Console : http://localhost:8080/h2-console/](http://localhost:8080/h2-console/) 로 접속하여

![](https://velog.velcdn.com/images/jbb9229/post/92c7f5f7-30eb-4b1b-90c5-d0f4d2efaef5/image.png)

JDBC URL : jdbc:h2:mem:triple
User Name : admin
password : 1234
입력 후 샘플 데이터 확인 및 실시간 디비 조회가 가능합니다.

## REST API
### Point 적립 API
```
POST /events
Host: localhost:8080
```
|Name|Type|Description|required
|----|:----:|:----:|:----:
|type|String|이벤트의 타입입니다.|O
|action|String|이벤트 타입에 대한 행위입니다.|O
|reviewId|String|작성한 리뷰의 Id 값입니다.|O
|content|String|작성한 리뷰의 내용입니다.|X
|attachedPhotoIds|List|리뷰의 사진 배열 입니다.|X
|userId|String|작성한 리뷰의 작성자 Id값 입니다.|O
|placeId|String|작성한 리뷰의 장소 Id값 입니다.|O

### User Point 조회 API
```
GET /point
Host: localhost:8080
```
|Name|Type|Description|required
|----|:----:|:----:|:----:
|userId|String|조회할 사용자의 Id값 입니다.|O
