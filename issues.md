# issues

## ディレクトリ構成

```plaintext
├─java
│  └─com
│      └─example
│          └─web
│              │  WebAppApplication.java
│              │
│              ├─controller
│              │      UserController.java
│              │      WebController.java
│              │
│              ├─entity
│              │      User.java
│              │
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
│              ├─repository
│              │      UserRepository.java
│              │
=======
>>>>>>> 271803c (organize my thoughts)
=======
│              ├─repository
│              │      UserRepository.java
│              │
>>>>>>> b795492 (organize my thoughts)
=======
>>>>>>> 5e5556d (organize my thoughts)
│              └─service
│                      UserService.java
│
└─resources
    │  application.properties
    │
    ├─sql
    │      01_create_database.sql
    │      02_create_tables.sql
    │      03_insert_data.sql
    │
    ├─static
    │  └─css
    │          style.css
    │
    └─templates
        │  index.html
        │
        ├─common
        │      common.html
        │
        └─user
                details.html
                list.html
```

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

<<<<<<< HEAD
ユーザー情報一覧

- <https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e4%b8%80%e8%a6%a7%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/>

<<<<<<< HEAD
- <https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e8%a9%b3%e7%b4%b0%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/>
=======
=======
>>>>>>> 5e5556d (organize my thoughts)
ユーザー情報一覧

- <https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e4%b8%80%e8%a6%a7%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/>

ユーザー情報詳細

- <https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e8%a9%b3%e7%b4%b0%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/>

thymeleaf-extras-java8time
<<<<<<< HEAD
<https://www.early2home.com/blog/programming/java/post-3162.html>
<https://blog.beaglesoft.net/entry/2016/11/16/163000>
<https://ryoichi0102.hatenablog.com/entry/2017/08/21/191055>
>>>>>>> 486f0e6 (organize my thoughts)
=======

- <https://www.early2home.com/blog/programming/java/post-3162.html>

- <https://blog.beaglesoft.net/entry/2016/11/16/163000>

- <https://ryoichi0102.hatenablog.com/entry/2017/08/21/191055>
>>>>>>> a5eb1ed (organize my thoughts)
