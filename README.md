## 项目介绍
`erosion-watch` 项目是一套土壤侵蚀程度调查分析系统，包括数据监测和数据分析两部分。在数据分析模块，分为专业的土壤数据分析以及通用数据分析两部分。首先可导入 excel 表格到后台，后台结合 Apache Common Math 和 TableSaw 数据进行例如线性回归分析，描述性分析，相关性分析等操作。针对专业数据分析，结合专业公式得出相关因子，并给出治理建议。除此之外，该项目还支持文献检索功能，可识别上传的 PDF 文件并存入 ES 中，实现全文搜索。同时，本系统还支持邮箱验证码登录功能，统计每日访问量和点击量等数据。 

### 项目结构

```
erosion-watch
├── eroison-watch-common -- 工具类及通用代码
├── eroison-watch-mbg -- MyBatisGenerator生成的数据库操作代码
├── eroison-watch-security -- SpringSecurity封装公用模块
└── eroison-watch-portal -- 前台商城系统接口
```

### 技术选型

#### 后端技术

| 技术             | 说明                | 官网                                                |
| ---------------- | ------------------- | --------------------------------------------------- |
| SpringBoot       | Web应用开发框架     | https://spring.io/projects/spring-boot              |
| SpringSecurity   | 认证和授权框架      | https://spring.io/projects/spring-security          |
| MyBatis          | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html      |
| MyBatisGenerator | 数据层代码生成器    | http://www.mybatis.org/generator/index.html         |
| Elasticsearch    | 搜索引擎            | https://github.com/elastic/elasticsearch            |
| RabbitMQ         | 消息队列            | https://www.rabbitmq.com/                           |
| Redis            | 内存数据存储        | https://redis.io/                                   |
| MongoDB          | NoSql数据库         | [https://www.mongodb.com](https://www.mongodb.com/) |
| Druid            | 数据库连接池        | https://github.com/alibaba/druid                    |
| MinIO            | 对象存储            | https://github.com/minio/minio                      |
| Easy Excel       | Excel数据处理       | https://easyexcel.opensource.alibaba.com/           |
| Common Math      | 数据分析处理        | https://commons.apache.org/proper/commons-math/     |
| TableSaw         | 数据可视化          | https://github.com/jtablesaw/tablesaw               |
| JWT              | JWT登录支持         | https://github.com/jwtk/jjwt                        |
| Lombok           | Java语言增强库      | https://github.com/rzwitserloot/lombok              |
| Hutool           | Java工具类库        | https://github.com/looly/hutool                     |
| PageHelper       | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper      |
| Knife4j          | API文档生成工具     | https://doc.xiaominfo.com/                          |

#### 前端技术

| 技术         | 说明                  | 官网                                                  |
| ------------ | --------------------- | ----------------------------------------------------- |
| Vue          | 前端框架              | https://vuejs.org/                                    |
| Vue-router   | 路由框架              | https://router.vuejs.org/                             |
| Vuex         | 全局状态管理框架      | https://vuex.vuejs.org/                               |
| Element      | 前端UI框架            | [https://element.eleme.io](https://element.eleme.io/) |
| Axios        | 前端HTTP框架          | https://github.com/axios/axios                        |
| v-charts     | 基于Echarts的图表框架 | https://v-charts.js.org/                              |
| Js-cookie    | cookie管理工具        | https://github.com/js-cookie/js-cookie                |
| nprogress    | 进度条控件            | https://github.com/rstacruz/nprogress                 |
| Handsontable | Excel 表格            | https://handsontable.com/                             |

### 架构图

![image-20240403173412162](images/image-20240403173412162.png)

### 项目演示

在线分析输入界面

![img](images/1710678012808-65483c7c-561f-4c0a-b0d7-5842d9bdc210.png)



在线分析结果界面
![img](images/1710677903735-4987aeaf-8cba-4a42-8f2d-3757bd797b64.png)



我的数据界面

![img](images/1710678040450-b3de9cef-4db9-48c8-917b-c80c5f9a704f.png)



文件重命名
![img](images/1710678069337-f8df0bb3-33ab-4105-8093-516b20c0134e.png)



文件上传界面
![img](images/1710678134762-cf83daa9-19f4-4bbf-bb2b-47a6640e3c29.png)



上传成功提示
![img](images/1710678161356-ee56e37f-c84e-4429-9ed8-5718cfb4ac99.png)



excel 数据展示
![img](images/1710678188714-a547a99c-b7ac-4185-a37b-bbbcb4128778.png)



基于表格数据分析
![img](images/1710678230010-6ecb925a-6a04-4ad5-a40a-fdb7fd00f025.png)



监测管理

区域信息
![img](images/1710678261374-55c0e00e-4333-45ab-94ec-1af4b2bf1cf6.png)



新增区域信息
![img](images/1710678297656-aa165d02-0bff-4542-a506-052388620940.png)



土壤类型
![img](images/1710678297656-aa165d02-0bff-4542-a506-052388620940-171213747369314.png)



新增土壤类型
![img](images/1710678311689-f2302398-0ab4-496e-b9ed-42c4dcc380cc.png)![img](images/1710678311689-f2302398-0ab4-496e-b9ed-42c4dcc380cc-171213751364017.png)



植被覆盖

![img](images/1710678337520-ca8fd62c-1ed4-46d4-b83e-380ca4031a3e.png)



新增植被覆盖

![img](images/1710678358370-ebaf3b71-cf27-48ca-a347-ed663e721ab4.png)



地形地貌

![img](images/1710678374682-e4f540d0-eea7-4756-9dbc-39554deec0f1.png)



新增地形地貌

![img](images/1710678379630-7c9ad70f-f249-4f62-b39f-a6953b82714d.png)



侵蚀等级

![img](images/1710678393355-7d568ecf-5206-4c4c-a62b-b5ff56c5d1c5.png)



新增侵蚀等级

![img](images/1710678408045-94575688-ec58-4b6b-9093-c4c6be2389a6.png)



监测数据

![img](images/1710678423236-ae3c0d68-c8cb-4718-8e3b-6f8601245f94.png)



新增监测数据

![img](images/1710678435725-17e5a4a9-63c4-46d3-8f12-ea2d731dc561.png)



土地使用历史

![img](images/1710678455231-6622fde0-0260-4c34-ba27-959f86f97b07.png)



新增土地使用历史

![img](images/1710678471210-d50b11cc-3c5b-4aaf-a6e1-0e649a4c96be.png)



土地规划

![img](images/1710678491154-93530683-0301-46fd-bd77-cdcf792b113d.png)



新增土地规划

![img](images/1710678504765-02a68188-79fc-4e53-a645-63beb03af2e9.png)



文献资源查看

![img](images/1710678543398-47f9d125-05e7-481d-964f-97ea50e5146b.png)



地图资源

![img](images/1710678595626-6f59f359-e826-462e-9fa0-135cfc530e5d.jpeg)



用户登录

![img](images/1710678603713-70078cc6-2009-48af-b764-4b300c066cdb.png)



用户注册

![img](images/1710678614175-b6f3557a-4cc3-4493-b698-608a3ed3ec98.png)



用户信息查看

![img](images/1710678626693-6d6abb82-6e7e-4f48-aabf-9386fa32f1eb.png)



用户信息编辑

![img](images/1710678639213-fdad019e-b521-4674-be67-3e6d1f507129.png)



## 数据库表结构

数据库表结构概览

![image-20240403174948206](images/image-20240403174948206.png)

**soil_type 表**

| **列名**      | **数据类型** | **说明**       |
| ------------- | ------------ | -------------- |
| id            | bigint       | 主键           |
| parent_id     | bigint       | 上级分类的编号 |
| name          | varchar(64)  | 土壤类型名称   |
| level         | int(1)       | 分类级别       |
| soil_quality  | varchar(64)  | 土壤质地       |
| soil_moisture | varchar(64)  | 土壤含水量     |
| description   | text         | 描述           |

**vegetation_coverage 表**

| **列名**            | **数据类型** | **说明**   |
| ------------------- | ------------ | ---------- |
| id                  | bigint       | 主键       |
| area_id             | bigint       | 地区ID     |
| vegetation_type     | varchar(100) | 植被类型   |
| coverage_percentage | decimal(5,2) | 覆盖百分比 |
| density             | varchar(50)  | 植被密度   |
| status              | int(1)       | 植被状态   |
| remarks             | text         | 备注       |

**area_info 表**

| **列名**            | **数据类型**   | **说明**     |
| ------------------- | -------------- | ------------ |
| id                  | bigint         | 主键         |
| area_name           | varchar(100)   | 地区名称     |
| administrative_code | varchar(20)    | 行政区划代码 |
| latitude            | decimal(9, 6)  | 纬度         |
| longitude           | decimal(9, 6)  | 经度         |
| area                | decimal(10, 2) | 面积         |
| population          | int            | 人口         |
| climate_type        | varchar(50)    | 气候类型     |
| terrain_feature     | varchar(50)    | 地形特征     |
| landform_feature    | varchar(50)    | 地貌特征     |
| land_use            | varchar(50)    | 土地利用情况 |

**member 表**

| **列名**          | **数据类型** | **说明**     |
| ----------------- | ------------ | ------------ |
| id                | bigint       | 主键         |
| username          | varchar(50)  | 用户名       |
| password          | varchar(100) | 密码         |
| nickname          | varchar(100) | 昵称         |
| email             | varchar(100) | 邮箱         |
| registration_date | datetime     | 注册日期     |
| last_login        | datetime     | 上次登录时间 |
| first_name        | varchar(50)  | 用户的名     |
| last_name         | varchar(50)  | 用户的姓     |
| gender            | enum         | 性别         |
| date_of_birth     | date         | 出生日期     |
| address           | varchar(255) | 地址         |
| phone_number      | varchar(20)  | 电话号码     |
| profile_picture   | varchar(255) | 个人头像路径 |
| biography         | text         | 个人简介     |
| organization      | varchar(100) | 所属单位     |
| real_name         | varchar(100) | 真实姓名     |

**terrain_landform 表**

| **列名**        | **数据类型**   | **说明**             |
| --------------- | -------------- | -------------------- |
| id              | bigint         | 主键                 |
| area_id         | bigint         | 地区ID               |
| terrain_type    | varchar(50)    | 地形类型             |
| landform_type   | varchar(50)    | 地貌类型             |
| elevation       | decimal(10, 2) | 海拔高度（单位：米） |
| slope           | decimal(10, 2) | 坡度（单位：度）     |
| soil_type       | varchar(100)   | 土壤类型             |
| vegetation_type | varchar(100)   | 植被类型             |
| water_system    | varchar(100)   | 水系类型             |

**soil_erosion_grade 表**

| **列名**               | **数据类型** | **说明**             |
| ---------------------- | ------------ | -------------------- |
| id                     | bigint       | 主键                 |
| area_id                | bigint       | 地区ID               |
| erosion_type           | varchar(50)  | 侵蚀类型             |
| erosion_grade          | varchar(20)  | 侵蚀等级             |
| erosion_years          | int          | 抗蚀年限（单位：年） |
| erosion_description    | text         | 侵蚀描述             |
| risk_level             | varchar(20)  | 风险等级             |
| risk_assessment_result | text         | 风险评估结果         |
| management_practice    | text         | 管理措施             |

**monitoring_data 表**

| **列名**                 | **数据类型**  | **说明**             |
| ------------------------ | ------------- | -------------------- |
| id                       | bigint        | 主键                 |
| area_id                  | bigint        | 地区ID               |
| monitoring_date          | date          | 监测日期             |
| soil_erosion_rate        | decimal(5,2)  | 土壤侵蚀率           |
| vegetation_coverage_rate | decimal(5,2)  | 植被覆盖率           |
| rainfall_amount          | decimal(10,2) | 降雨量（单位：毫米） |

**land_use_change_history 表**

| **列名**          | **数据类型** | **说明**           |
| ----------------- | ------------ | ------------------ |
| id                | bigint       | 主键               |
| area_id           | bigint       | 地区ID             |
| change_date       | date         | 变更日期           |
| previous_land_use | varchar(50)  | 之前的土地利用情况 |
| current_land_use  | varchar(50)  | 当前的土地利用情况 |
| change_reason     | text         | 变更原因           |

**land_management_plans 表**

| **列名**            | **数据类型** | **说明**              |
| ------------------- | ------------ | --------------------- |
| id                  | bigint       | 主键                  |
| area_id             | bigint       | 地区ID                |
| plan_date           | date         | 计划日期              |
| plan_type           | varchar(50)  | 计划类型（规划/项目） |
| plan_content        | text         | 计划内容              |
| responsible_unit    | varchar(100) | 责任单位              |
| implementation_date | date         | 实施日期              |

