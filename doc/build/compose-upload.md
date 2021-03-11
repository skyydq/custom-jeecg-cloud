
## 正式环境部署
```
部署方案采用docker compose 部署方案
需要准备环境
docker 、 docker-compose、DockerHub私有仓库
```
## 项目构建
> docker-compose 构建 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200619201242684.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzkzNjEzMg==,size_16,color_FFFFFF,t_70)
```
docker-compose -f ./docker-compose.yml build
```
## 发布镜像到镜像仓库
> docker-compose-server.yml 注释部分进行修改镜像仓库，进行上传，版本号可自定义
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200619201346353.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzkzNjEzMg==,size_16,color_FFFFFF,t_70)
- linux环境中启动基础环境
```
docker-compose -f ./docker-compose-server.yml up -d jeecg-cloud-mysql jeecg-cloud-redis jeecg-cloud-nacos
```
> nacos启动完成进行添加配置，记得开放端口
```
http://192.168.1.11:8848/nacos/index.html（nacos/nacos）
配置列表-》配置添加俩配置文件
参考：doc/NACOSCONFIG
```
> 项目启动
```
docker-compose -f ./docker-compose-server.yml up -d jeecg-cloud-system jeecg-cloud-gateway jeecg-cloud-demo
```
> linux接口权限开放，项目测试
```
1. 直接访问demo服务请求
http://192.168.1.11:8002/demo/hello
2. 直接访问system服务请求
http://192.168.1.11:8001/sys/randomImage/12121
3. 网关跳转demo请求：
http://192.168.1.11:9999/demo/hello
4. 网关跳转system服务请求
验证码：  http://192.168.1.11:9999/sys/randomImage/12121
登录接口：http://192.168.1.11:9999/sys/login
```

