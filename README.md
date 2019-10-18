# redis-batch-server

#### 介绍

批量模糊匹配删除redis的key，用scan命令

#### 软件架构

1.  jdk1.8
2.  springboot
3.  redis


#### 使用说明

1.  通过idea导入项目
2.  修改 application.yml 配置文件里面的 host ，port ，password 为自己的redis地址、端口、密码
3.  修改 logback-spring.xml 里面的日志文件路径 <property name="LOG_PATH" value="/Users/zhangxiaobin/sunlands/logs" />
4.  运行 ServerApplication
5.  通过浏览器或者 postman 请求 http://localhost:9027/test/delKey , 具体的参数请移步至 com.zhangxiaobin.controller.Test 

