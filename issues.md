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

```plaintext
springSample
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

- controller/UserController.java

```java
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public String displayList(Model model) {
        var userlist = userService.searchAll();
        model.addAtribute("userlist", userlist);
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String displayDetails(Model model) {
        var user = userService.findById(id);
        model.addAtribute("userData", user)
        return "user/details";
    }

}
```

- entity/User.java

```java
@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private Date updateDate;
    private Date createDate;
    private Date deleteDate;
}
```

- service/UserService.java

```java
@Service
public class UserService {

    // @Autowired
    
    private List<User> userlist;

    public ArrayList<User> searchAll() {
        // var userlist = new ArrayList();
        return userlist;
    }

    public User findById(Long id) {
        return userlist.get(id);
    }

}
```

- user/list.html

```html
<tr th:each="user: ${userlist}"></tr>
```

- user/details.html

```html
<div th:object="${userData}"></div>
```

<https://medium-company.com/spring-boot-thymeleaf%e3%81%a7%e8%a9%b3%e7%b4%b0%e7%94%bb%e9%9d%a2%e3%82%92%e4%bd%9c%e6%88%90%e3%81%99%e3%82%8b/>
