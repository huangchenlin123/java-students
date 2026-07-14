# 学生管理系统 Thymeleaf 页面设计

## 概述
为现有的 student-manager Spring Boot 项目添加 Thymeleaf 模板引擎，生成学生管理的 Web 页面。

## 技术选型
- Thymeleaf（服务端模板引擎）
- Bootstrap 5（前端 UI 框架 via WebJars）

## 改动清单

### 1. pom.xml
- 添加 `spring-boot-starter-thymeleaf`
- 添加 `org.webjars:bootstrap:5.3.3` 和 `org.webjars:webjars-locator-core`

### 2. application.properties（新增）
- Thymeleaf 缓存配置

### 3. StudentPageController（新增 @Controller）
- `GET /students/page` → 列表页
- `GET /students/page/add` → 新增表单页
- `GET /students/page/edit/{id}` → 编辑表单页（回显数据）
- `POST /students/page/save` → 保存（新增或更新）
- `GET /students/page/delete/{id}` → 删除后重定向

### 4. 模板文件
- `templates/student/list.html` — 学生列表页（表格 + 操作按钮）
- `templates/student/form.html` — 添加/编辑表单页

## 职责分离
- 现有 `StudentController`（@RestController）保持纯 REST API 不变
- 新增 `StudentPageController`（@Controller）处理页面跳转和数据传递
- 两者共用同一个 `StudentService`
