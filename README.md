# DeliveryAPP
🛵 Clean Architecture를 이용한 배달 앱 🛵

## 개발환경
* OS : windows 10 pro
* IDE : Android Studio
* Language : Kotlin

## 사용한 것
* Coroutine
* Koin
* retrofit2
* Glide
* google map
* Tmap POI
* room
* firebase (firestore, storage, auth)
* cameraX
* circle indicator
* unit test (Junit, mockito, koin-test)
* viewmodel, livedata, GOF state pattern

## 기능 상세
* 자동으로 사용자의 위치를 잡아준다.
* 사용자 임의로 지도에 위치를 지정할 수 있다. (현재위치와 다를 시 TOAST로 알림)
* 설정된 위치에 따른 카테고리별 음식점 리스트를 보여준다.
* 구글 로그인을 통해 로그인을 할 수 있다.
* 사용자가 주문한 음식을 FIREBASE에서 확인할 수 있다.
* 음식점에 전화를 걸거나, 찜 목록에 저장하거나, 공유할 수 있다.
* 주문한 음식점에 대해 리뷰를 남길 수 있다. (사진을 찍거나, 첨부가능)
* 한 음식점에서 주문할 음식을 장바구니에 담을 수 있다. (다른 음식점과 동시에 담아질 시 먼저담긴 음식점의 음식들은 장바구니에서 비워짐)

## 작동화면
![deli 1](https://user-images.githubusercontent.com/62370144/173217359-6a30f9ad-24b9-48e4-9223-f34600acbdeb.png)
![deli 2](https://user-images.githubusercontent.com/62370144/173217367-47f1dd2e-fad8-4fd7-9f99-aa00fd52f9aa.png)


