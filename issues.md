# issues

## 2022-12-09

### 詳細画面をつくってみる

一覧画面の１行データごとに「編集」ボタンを表示する  
一覧画面の「編集」ボタンから、詳細画面へ遷移する  
詳細画面の「戻る」ボタンから、一覧画面へ遷移する  
詳細画面では、下記の項目が確認できる  

- ID: 一覧画面で指定したID  
- 名前、住所、電話番号、更新日時、登録日時  
- ※これらは、Controllerでmodelに値をセットする  

Thymeleafを使って、modelの情報をHTMLに表示する  
Bootstrapを使って、わかり易く表現する  
GitHubにソースコードをpushする  

- ディレクトリ構成

```plaintext
training.web-app
  |
  |___src.main
       |
       |___java.com.example.web
       |    |
       |    |___controller
       |    |    |
       |    |    |__UserController.java
       |    |
       |    |___entity
       |    |    |
       |    |    |___User.java
       |    |
       |    |___repository
       |    |    |
       |    |    |___UserRepository.java
       |    |
       |    |___service
       |         |
       |         |___UserService.java
       |
       |___resources
            |
            |___templates
            |    |
            |    |___common
            |    |    |
            |    |    |___head.html
            |    |
            |    |___user
            |         |
            |         |___add.html
            |         |
            |         |___list.html
            |         |
            |         |___view.html
            |
            |___application.properties
```

ユーザー情報一覧

- <https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e4%b8%80%e8%a6%a7%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/#viewhtml>

ユーザー情報詳細

- <https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e8%a9%b3%e7%b4%b0%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/>

thymeleaf-extras-java8time

- <https://www.early2home.com/blog/programming/java/post-3162.html>

- <https://blog.beaglesoft.net/entry/2016/11/16/163000>

- <https://ryoichi0102.hatenablog.com/entry/2017/08/21/191055>
