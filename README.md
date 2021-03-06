# oa-server
 oa系统的后台java代码
### 一、系统环境
## 1.java 环境 openjdk11
## 2.数据库 mysql 5.7.17
## 3.后台框架spring boot 2.2.1、mybatis-plus3.3.0、activiti6.0.0
## 4.前端框架采用angular2的NG-ALAIN的框架：https://ng-alain.com/zh
### 二、文件目录介绍
#### lvqibin-oa 项目更目录

>DB 存放数据库相关的文件

>>data 历史版本的数据

>>function mysql的function

>>mwb myql的建模文件

>>others 一些其他的文件

>>tables 系统库的建表语句

>doc 文档主要是数据库的设计文档

>lvqibin-oa-common 公共模块

>lvqibin-oa-dao mybatis-plus的xml和mapper文件

>lvqibin-oa-model 实体bean文件

>lvqibin-oa-service service文件

>lvqibin-oa-web 提供的服务接口

### 三、如何使用
#### 1.初始化数据库
工具的选择：建议使用mysql 官方提供的工具 MySQL Workbench <br> 
创建oa_app和oa_sys表空间 <br> 
导入数据：导入lvqibin-oa\DB\data\20200115的数据 <br> 
#### 2.引入项目
通过maven方式导入项目
#### 3.启动项目
#### 4.访问
通过：http://127.0.0.1:8089/oa即可访问<br> 
用户名：system或test密码都是1234456

### 四、初始化数据库
#### 创建表空间
##### 方式一： 在mysql中执行 <br> 
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/%E5%88%9B%E5%BB%BA%E8%A1%A8%E7%A9%BA%E9%97%B4%E6%96%87%E4%BB%B6.png) <br> 
中的sql语句
##### 方式二： 使用MySQL Workbench <br> 
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/创建表空间1.png) <br> 
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/创建表空间2.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/创建表空间3.png) <br>

#### 初始化数据
使用 MySQL Workbench <br> 
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/导入数据1.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/导入数据2.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/导入数据3.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/导入数据5.png) <br>


#### 查看表结构
使用 MySQL Workbench <br> 
可以通过 mwb 文件下的文件查看数据库表结构 <br> 
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/查看表结构1.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/查看表结构2.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/查看表结构3.png) <br>
![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/查看表结构4.png) <br>

### 五、接口api采用 apidoc

![Image text](https://github.com/lvqibin123/oa-server/blob/master/lvqibin-oa/gitImgs/接口api1.png) <br>
