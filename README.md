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
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678012808-65483c7c-561f-4c0a-b0d7-5842d9bdc210.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=670&id=uce0fee0c&originHeight=837&originWidth=1897&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=60525&status=done&style=none&taskId=u5f74c56b-c082-4b40-9b08-264429f89b8&title=&width=1517.6)
在线分析结果界面
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710677903735-4987aeaf-8cba-4a42-8f2d-3757bd797b64.png#averageHue=%23fefdfd&clientId=u21acd822-6933-4&from=paste&height=682&id=u5114a303&originHeight=852&originWidth=1910&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=118851&status=done&style=none&taskId=u3835edb8-5c4a-43d1-ab76-bcb4536d8d1&title=%E5%9C%A8%E7%BA%BF%E5%88%86%E6%9E%90%E7%BB%93%E6%9E%9C%E7%95%8C%E9%9D%A2&width=1528)
我的数据界面
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678040450-b3de9cef-4db9-48c8-917b-c80c5f9a704f.png#averageHue=%23fefefd&clientId=u21acd822-6933-4&from=paste&height=681&id=u5cd1d03d&originHeight=851&originWidth=1905&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=114297&status=done&style=none&taskId=uce31d68e-8e55-4cc4-a1cb-e68114a8fd1&title=&width=1524)
文件重命名
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678069337-f8df0bb3-33ab-4105-8093-516b20c0134e.png#averageHue=%239e9e9e&clientId=u21acd822-6933-4&from=paste&height=523&id=u71b386ac&originHeight=654&originWidth=1037&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=34073&status=done&style=none&taskId=u3ce876de-188e-4d6f-a833-022febd4ee4&title=&width=829.6)
文件上传界面
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678134762-cf83daa9-19f4-4bbf-bb2b-47a6640e3c29.png#averageHue=%23c1c1c0&clientId=u21acd822-6933-4&from=paste&height=641&id=ucc23922d&originHeight=801&originWidth=1328&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=97626&status=done&style=none&taskId=ubf88256a-e9eb-4096-9587-743a680e2e8&title=&width=1062.4)
上传成功提示
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678161356-ee56e37f-c84e-4429-9ed8-5718cfb4ac99.png#averageHue=%23dadada&clientId=u21acd822-6933-4&from=paste&height=319&id=u7127a697&originHeight=399&originWidth=849&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=16905&status=done&style=none&taskId=ue230ae2b-b567-472a-85c7-edb266610e5&title=&width=679.2)
excel 数据展示
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678188714-a547a99c-b7ac-4185-a37b-bbbcb4128778.png#averageHue=%23f9f8f7&clientId=u21acd822-6933-4&from=paste&height=661&id=u3545dfd2&originHeight=826&originWidth=1905&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=120381&status=done&style=none&taskId=u9ef0e4c6-3f39-409d-8e1b-6af9c3cff1b&title=&width=1524)
基于表格数据分析
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678230010-6ecb925a-6a04-4ad5-a40a-fdb7fd00f025.png#averageHue=%23e7cfa9&clientId=u21acd822-6933-4&from=paste&height=632&id=udb5c1882&originHeight=790&originWidth=1900&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=57093&status=done&style=none&taskId=ucf6d1d69-19be-437a-a899-f9e1e417d2b&title=&width=1520)
监测管理
区域信息
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678261374-55c0e00e-4333-45ab-94ec-1af4b2bf1cf6.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=490&id=u2ac8921e&originHeight=612&originWidth=1896&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=51071&status=done&style=none&taskId=ub73a61d4-0c43-4ad0-8048-c11ec94b07a&title=&width=1516.8)
新增区域信息
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678278862-55aff430-9e82-4fa2-88bb-bd868e6c96f2.png#averageHue=%23dbdbdb&clientId=u21acd822-6933-4&from=paste&height=557&id=uae4d90e9&originHeight=696&originWidth=922&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=41653&status=done&style=none&taskId=ua36baa80-3be0-42c2-b6eb-5fb9d405bd8&title=&width=737.6)
土壤类型
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678297656-aa165d02-0bff-4542-a506-052388620940.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=639&id=ue6ce3bb8&originHeight=799&originWidth=1891&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=76597&status=done&style=none&taskId=u40c8ccc6-e77e-43f8-9df2-d24f2f43a26&title=&width=1512.8)
新增土壤类型
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678311689-f2302398-0ab4-496e-b9ed-42c4dcc380cc.png#averageHue=%23dcdcdc&clientId=u21acd822-6933-4&from=paste&height=467&id=ub4ea145b&originHeight=584&originWidth=861&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=36985&status=done&style=none&taskId=uc698de2e-1f31-4ebe-9444-138f58b0e6b&title=&width=688.8)
植被覆盖
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678337520-ca8fd62c-1ed4-46d4-b83e-380ca4031a3e.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=638&id=u44290c4d&originHeight=798&originWidth=1900&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=42575&status=done&style=none&taskId=u6daf7b91-16cf-4fca-a075-b7ba4f048fd&title=&width=1520)
新增植被覆盖
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678358370-ebaf3b71-cf27-48ca-a347-ed663e721ab4.png#averageHue=%23e5e5e5&clientId=u21acd822-6933-4&from=paste&height=394&id=uf750bebc&originHeight=492&originWidth=875&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=25607&status=done&style=none&taskId=u629058cf-5070-45b7-aa90-2b35539aad7&title=&width=700)
地形地貌
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678374682-e4f540d0-eea7-4756-9dbc-39554deec0f1.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=621&id=uce314108&originHeight=776&originWidth=1906&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=40558&status=done&style=none&taskId=u03306397-34ee-4715-9f63-a700b8ad612&title=&width=1524.8)
新增地形地貌
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678379630-7c9ad70f-f249-4f62-b39f-a6953b82714d.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=621&id=uc1396f8f&originHeight=776&originWidth=1906&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=40558&status=done&style=none&taskId=uff93d1ec-7563-42c7-9a14-b89a62697ba&title=&width=1524.8)
侵蚀等级
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678393355-7d568ecf-5206-4c4c-a62b-b5ff56c5d1c5.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=645&id=u746d0423&originHeight=806&originWidth=1891&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=62440&status=done&style=none&taskId=ufdabbf8c-b408-4a3e-818c-9621d38d676&title=&width=1512.8)
新增侵蚀等级
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678408045-94575688-ec58-4b6b-9093-c4c6be2389a6.png#averageHue=%23e9e8e8&clientId=u21acd822-6933-4&from=paste&height=465&id=u22f32685&originHeight=581&originWidth=849&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=39667&status=done&style=none&taskId=ubd1e9954-8fbf-4872-9f57-f953fb0ff21&title=&width=679.2)
监测数据
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678423236-ae3c0d68-c8cb-4718-8e3b-6f8601245f94.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=646&id=u7b839d82&originHeight=807&originWidth=1906&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=42969&status=done&style=none&taskId=u1e59072b-e02a-46ee-acf0-ac7ade41f96&title=&width=1524.8)
新增监测数据
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678435725-17e5a4a9-63c4-46d3-8f12-ea2d731dc561.png#averageHue=%23e8e7e7&clientId=u21acd822-6933-4&from=paste&height=366&id=uc2b66092&originHeight=457&originWidth=819&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=21582&status=done&style=none&taskId=u3d9b8509-1936-403c-a700-881220c2214&title=&width=655.2)

土地使用历史
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678455231-6622fde0-0260-4c34-ba27-959f86f97b07.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=629&id=ud1dfc0ae&originHeight=786&originWidth=1892&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=44715&status=done&style=none&taskId=u2a5d6e8b-9cf0-4e35-8dda-25871c382d4&title=&width=1513.6)

新增土地使用历史
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678471210-d50b11cc-3c5b-4aaf-a6e1-0e649a4c96be.png#averageHue=%23fefefe&clientId=u21acd822-6933-4&from=paste&height=614&id=u7777838c&originHeight=767&originWidth=1899&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=43085&status=done&style=none&taskId=ue7210367-b625-49db-8956-930b6179d43&title=&width=1519.2)

土地规划
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678491154-93530683-0301-46fd-bd77-cdcf792b113d.png#averageHue=%23fefefd&clientId=u21acd822-6933-4&from=paste&height=694&id=u345ba532&originHeight=867&originWidth=1910&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=70088&status=done&style=none&taskId=u10c5479c-e3a8-470d-a2d7-813f7eb4b22&title=&width=1528)

新增土地规划
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678504765-02a68188-79fc-4e53-a645-63beb03af2e9.png#averageHue=%23eeeeee&clientId=u21acd822-6933-4&from=paste&height=406&id=ud1df35e4&originHeight=507&originWidth=807&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=27201&status=done&style=none&taskId=u94aeb792-13ca-45f3-bc52-13cfafd24d2&title=&width=645.6)

文献资源查看
![image.png](https://cdn.nlark.com/yuque/0/2024/png/40592343/1710678543398-47f9d125-05e7-481d-964f-97ea50e5146b.png#averageHue=%23fafafa&clientId=u21acd822-6933-4&from=paste&height=660&id=uab29b255&originHeight=825&originWidth=1882&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=257800&status=done&style=none&taskId=ufc389c63-fc33-423e-9951-74541400ab6&title=&width=1505.6)

地图资源
![RWYT_)8GB4}SY(H~6OWEW%J.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/40592343/1710678595626-6f59f359-e826-462e-9fa0-135cfc530e5d.jpeg#averageHue=%23657d67&clientId=u21acd822-6933-4&from=paste&height=694&id=u9a3be994&originHeight=868&originWidth=1916&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=284122&status=done&style=none&taskId=u38fd60a2-fd71-41dd-9b7a-960e4ff34f3&title=&width=1532.8)

用户登录

![img](images/1710678603713-70078cc6-2009-48af-b764-4b300c066cdb.png)

用户注册

![img](images/1710678614175-b6f3557a-4cc3-4493-b698-608a3ed3ec98.png)

用户信息查看

![img](images/1710678626693-6d6abb82-6e7e-4f48-aabf-9386fa32f1eb.png)

用户信息编辑

![img](images/1710678626693-6d6abb82-6e7e-4f48-aabf-9386fa32f1eb-17121370294836.png)
