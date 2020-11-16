## 若依项目阅读记录

### 前言

[项目源码地址](https://gitee.com/y_project/RuoYi)

### 2020/11/16

#### 创建订单模块CRUD

##### 1. 创建数据库表`gok_order`

```sql
create table gok_order
(
    id                int auto_increment comment 'id'
        primary key,
    order_id          varchar(64)  not null comment '订单号',
    order_content     varchar(255) not null comment '订单内容',
    order_amount      varchar(20)  not null comment '订单金额',
    order_create_time date         not null comment '订单创建时间',
    order_paid_time   date         not null comment '订单支付时间',
    user_id           int          not null comment '订单消费人',
    order_status      int          not null comment '订单状态',
    constraint gok_order_order_id_uindex
        unique (order_id)
)
    comment '订单表';
```

##### 2. 利用若依提供的代码生成工具生成对应代码

- 导入表及结构

![生成代码](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201116161123.png)

- 编辑配置相关信息，生成代码
- 解压并添加文件到对应项目结构
  - 将生成的`controller`放到`ruoyi-admin`的`controller`文件夹下
  - 将生成的`domain、service、mapper`放到`ruoyi-system`的对应文件夹下
  - 将生成的`resources`放到`ruoyi-admin`的`resources`文件夹下
- 重启项目，查看是否嵌入进去
  - 失败，发现没有显示
  - 失败原因：只生成了业务代码，前端没有展示
  - 解决方案：菜单管理--系统管理--添加新的菜单管理项（“gok订单管理”）

![image-20201116163903814](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201116163905.png)

- 检测功能是否完成

  - 失败，发现页面报错

  > `org.thymeleaf.exceptions.TemplateInputException:` Error resolving template [system/order/order], template might not exist or might not be accessible by any of the configured Template Resolvers

  - 失败原因：渲染路径错误，多了一个order
  - 解决方案：检查路径（无错误）；检查`target`发现没有对应文件，`rebulid`重新构建项目

- 功能测试

  ![image-20201116192202280](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201116192204.png)

#### 前端页面阅读笔记（`user.html`）

- 引入`thymeleaf`
- 引入`shiro`

```html
<html lang="zh" xmlns:th="http://www.thymeleaf.org" xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
```

- `th:include`：只插入片段的内容

```html
<th:block th:include="include :: header('用户列表')" />
<!--往当前页面插入include.html中的一个叫做header的片段th:fragment -->
```

#### 半程自我总结

##### 1. 项目整体认知

- 还处于比较模糊的理解阶段
- 模块有点多，理解起来比较吃力
  - `mybaits`中的`mapper`
  - `template`中的渲染
  - 导入、导出、字典等功能整合起来不知如何下手
  
  ### 2020/11/15
  
  #### 略读“前端手册”模块
  
  - 前端比较看不懂
  
  #### 找到用户管理的CRUD实现
  
  ##### 定位
  
  - 全局搜索`user`，定位到`ruoyi-admin`模块`web.controller.system`下的`SysUserController`
  
  ##### 简单分析
  
  - 与之关联的`service`：用户、角色、岗位、密码
  - `@RequiresPermissions("system:user:view")`：`shiro`注解
  - `@Log(title = "用户管理", businessType = BusinessType.EXPORT)`：自定义的日志
  - `.stream().filter(r -> !r.isAdmin())`：java8新特性
  
  #### 理清CRUD实现逻辑
  
  - 添加用户
    - 弹出新增用户页面，填充信息，跳转新增页面
    - 参数校验，`shiro`加盐，存入数据库
  - 删除用户
    - 按照`id`删除（假删）
  - 修改用户
    - 类似添加用户
  - 查找用户


### 2020/11/14

#### 略读若依"后台手册"

- 分页：`pagehelper`
- 导入导出：自定义注解`@Excel`
- 权限注解
- 事务处理
- 异常处理`@ControllerAdvice`

#### 理清项目结构模块

后台服务主要在`ruoyi-admin`模块下

对照昨天的项目模块分析即可

#### 寻找项目入口，debug调试

#####  1. 页面入口

![image-20201114203711403](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201114203714.png)

![image-20201114203533385](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201114203536.png)

##### 2. 登陆成功后，会根据权限初始化主页内容

![image-20201114203815616](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201114204158.png)

### 2020/11/13

#### 目标分解

##### 搭建项目本地运行环境

- maven环境
- jdk环境
- 大多都是`maven`依赖，配置难度较小

##### 部署运行本地项目

- 从码云下载项目压缩包，本地解压导入
- 根据sql文件创建本地数据库`ry`
- 修改项目数据库配置信息

```yml
master:
    url: jdbc:mysql://localhost:3306/ry?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
    username: root
    password: ****
```

- 运行项目（本地成功部署）

<img src="https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201113213047.png" alt="image-20201113212933323" style="zoom: 80%;" />

##### 阅读若依系统官方手册"项目模块介绍"

- 文件结构（模块化）

```xml
com.ruoyi     
├── common            // 工具类
│       └── annotation                    // 自定义注解
│       └── config                        // 全局配置
│       └── constant                      // 通用常量
│       └── core                          // 核心控制
│       └── enums                         // 通用枚举
│       └── exception                     // 通用异常
│       └── json                          // JSON数据处理
│       └── utils                         // 通用类处理
│       └── xss                           // XSS过滤处理
├── framework         // 框架核心
│       └── aspectj                       // 注解实现
│       └── config                        // 系统配置
│       └── datasource                    // 数据权限
│       └── interceptor                   // 拦截器
│       └── manager                       // 异步处理
│       └── shiro                         // 权限控制
│       └── util                          // 通用工具
│       └── web                           // 前端控制
├── ruoyi-generator   // 代码生成（可移除）
├── ruoyi-quartz      // 定时任务（可移除）
├── ruoyi-system      // 系统代码
├── ruoyi-admin       // 后台服务
├── ruoyi-xxxxxx      // 其他模块
```

![image-20201113213433645](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201113213435.png)

- 核心技术
  - springboot框架
  - shiro安全控制
  - thymeleaf模板

##### 总结反馈

- 部署较顺利
- 项目属于父子多模块工程，之前没有接触过，理解起来有点吃力
- 虽然能看见一些`controller-service-dao`的痕迹，不过模块化的设计还不理解为什么要这么设计，得研究一下。
- 项目内容庞大，一时半会还消化不了。模块有点多，很多都没接触过。
- 前端也有点看不懂，好像是动态读取的。。。

- 计划：
  - 先找点`shiro`的资料看一下
  - 接下来以登陆账户为引，找到项目入口，`debug`看一下执行流程



