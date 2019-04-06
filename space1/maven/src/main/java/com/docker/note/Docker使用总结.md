# 一、安装Redis使用总结
## 1.安装
`docker pull hub.c.163.com/library/redis:latest`
## 2.启动
### 1.创建数据目录
`mkdir  -p  redis/data`
### 2.启动redis server
`docker run -p 6379:6379 -v $PWD/redis/data:/data  -d hub.c.163.com/library/redis:latest redis-server --appendonly yes`
* -p 6379:6379 : 将容器的6379端口映射到主机的6379端口
* -v $PWD/data:/data : 将主机中当前目录下的data挂载到容器的/data
* redis-server --appendonly yes : 在容器执行redis-server启动命令，并打开redis持久化配置
### 3.连接redis cli
`docker exec -it 21f05ee1f333 redis-cli`
### 4.关闭redis镜像
`docker stop 21f05ee1f333`
### 5.开启redis远程连接
```
docker run \
-p 6379:6379 \ # 端口映射 宿主机:容器
-v /docker/redis/data:/data:rw \ # 映射数据目录 rw 为读写
-v $PWD/redis.conf:/usr/local/etc/redis/redis.conf:ro \ # 挂载配置文件 ro 为readonly
--privileged=true \ # 给与一些权限
--name myredis \ # 给容器起个名字
-d docker.io/redis:latest redis-server /usr/local/etc/redis/redis.conf \ # deamon 运行 服务使用指定的配置文件
```
> redis.conf
```
#bind 127.0.0.1
protected-mode no //protected-mode 是在没有显示定义 bind 地址（即监听全网断），又没有设置密码 requirepass
                    时，只允许本地回环 127.0.0.1 访问。 也就是说当开启了 protected-mode 时，如果你既没有显示的定义了 bind
                    监听的地址，同时又没有设置 auth 密码。那你只能通过 127.0.0.1 来访问 redis 服务
appendonly yes//持久化
requirepass yourpassword //密码
```
### 6.远程连接redis—cli
`docker exec -it 21f05ee1f333 redis-cli -a yourpassword`
### 7.创建新镜像
```
docker commit 
-a "myredis" \ #新镜像名字
-m "myredis:docker run -d --privileged=true -p 6379:6379 -v $PWD/redis.conf:/usr/local/etc/redis/redis.conf -v $PWD/data:/data   hub.c.163.com/library/redis  redis-server /usr/local/etc/redis/redis.conf --appendonly yes" \#提交信息 
49db0fb2d8e1  
myredis:v1 \#名字:tag

```

