
## 1. Thymeleaf 基本语法
Thymeleaf 模板语言的语法通常用 `th:*` 形式的属性来实现，`*` 表示具体的功能，例如文本替换、条件判断等。
### 1.1 表达式语法
- **变量表达式**: `${...}` 用于访问对象的属性或调用方法。
- **选择表达式**: `*{...}` 相对当前选择对象的表达式。
- **消息表达式**: `#{...}` 用于国际化支持，引用消息文件中的键。
- **链接表达式**: `@{...}` 用于生成相对或绝对URL。
- **片段表达式**: `~{...}` 引用模板片段。
### 1.2 读取 List 的值
### 1.2 读取 Map 的值
### 1.2 读取 Object 的属性
### 1.2 4. 读取字符串的值

```html
<p>欢迎, ${user.name}!</p>
<a href="@{/login}">登录</a>

<ul>
  <li th:each="user : ${users}">
    用户ID: <span th:text="${user.id}">1</span>, 用户名: <span th:text="${user.name}">Alice</span>
  </li>
</ul>

<p>键为 key1 的值: <span th:text="${myMap['key1']}">value1</span></p>

<p>用户ID: <span th:text="${user.id}">1</span></p>
<p>用户名: <span th:text="${user.name}">Alice</span></p>

<p>消息: <span th:text="${message}">Hello, Thymeleaf!</span></p>
```

## 2. 标签
### 2.1 `th:text` - 文本替换，用来替换 HTML 元素的内容，并自动进行 HTML 转义。
### 2.2 `th:utext` - 不进行转义的文本，与 `th:text` 类似，但不进行 HTML 转义。
### 2.3 `th:href` - 链接替换，替换链接元素的 `href` 属性。
### 2.4 `th:src` - 图片路径替换，替换图片的 `src` 属性。
### 2.5 `th:if` / `th:unless` - 条件判断 `th:if` 用于条件渲染，如果条件为真则渲染元素，`th:unless` 则相反。
### 2.6 `th:each` - 循环 用于循环集合，并为每次迭代创建新作用域。

```html
<p th:text="${user.name}">用户名称</p>

<p th:utext="${user.htmlContent}">HTML内容</p>

<a th:href="@{/profile/{id}(id=${user.id})}">查看详情</a>

<img th:src="@{/images/logo.png}" alt="Logo"/>

<p th:if="${user.age > 18}">成年用户</p>
<p th:unless="${user.age > 18}">未成年用户</p>

<ul>
  <li th:each="user : ${userList}" th:text="${user.name}"></li>
</ul>
```

## 3. 片段与布局
Thymeleaf 支持通过 `th:replace` 和 `th:include` 进行模板片段的复用。

### 3.1 `th:replace` - 替换片段 将指定的模板片段完全替换到当前位置。
### 3.2 `th:include` - 包含片段 将片段的内容包含到当前元素中。
### 3.3 片段参数 在引用片段时可以传递参数。

```html
<div th:replace="fragments/header :: header"></div>

<div th:include="fragments/footer :: footer"></div>

<div th:replace="fragments/menu :: menu(menuTitle='首页')"></div>


```

## 4. 表单处理

### 4.1 `th:action` - 表单提交 替换表单的 `action` 属性。
### 4.2 `th:field` - 表单字段绑定 用于自动绑定表单字段到模型对象。
### 4.3 `th:action` - 在表单中通过 th:action 指定目标 URL，默认表单的提交方法是 POST。
### 4.4 `th:action` - GET 请求可以通过链接或表单的 method="get" 来实现。

```html
<form th:action="@{/submit}" th:object="${user}" method="post">
    <input type="text" th:field="*{name}"/>
</form>

<input type="text" th:field="*{name}"/>

<form th:action="@{/submit}" method="post">
  <input type="text" th:field="*{name}" placeholder="Name"/>
  <button type="submit">提交</button>
</form>

<a th:href="@{/profile/{id}(id=${user.id})}">查看详情</a>
<form th:action="@{/search}" method="get">
  <input type="text" name="query" placeholder="搜索"/>
  <button type="submit">搜索</button>
</form>
```

## 5. 内置对象
Thymeleaf 提供了几个内置对象，便于操作：

- `#dates` - 处理日期和时间
- `#numbers` - 处理数字格式化
- `#strings` - 字符串操作
- `#bools` - 布尔值处理
- `#lists` - 列表操作
- `#maps` - 映射操作
- `#arrays` - 数组操作
- `#calendars` - 日历操作
- `#httpServletRequest` 和 `#httpSession` - Servlet 相关对象

```html
<p th:text="${#dates.format(user.birthday, 'yyyy-MM-dd')}">生日</p>
```

## 6. 国际化支持 Thymeleaf 
通过 `th:text` 和 `#{}` 来实现国际化文本的替换。

```html
<p th:text="#{welcome.message}">欢迎</p>
```
需要在 `messages.properties` 文件中定义对应的键值对：
```properties
welcome.message=欢迎来到我们的网站！
```

## 7. 错误处理与验证
在表单提交时，Thymeleaf 可以显示校验错误。
```html
<p th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name Error</p>
```

## 8. 安全属性
Thymeleaf 提供了一些属性来处理安全问题，如防止跨站点脚本（XSS）攻击。

- `th:onclick`、`th:onmouseover` 等用于事件绑定
- `th:attr` 动态添加属性
```html
<a th:attr="onclick=${'alert(' + user.id + ')'}">点击我</a>
```

## 9. Thymeleaf 调试

- `th:debug` 可以在页面中插入调试信息。

```html
<div th:debug="all"></div>
```