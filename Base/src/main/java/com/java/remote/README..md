# 远程调试
## 远程要调试的程序加入jvm参数：
`-Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=8888`
## 本地代码加入选remote启动方式，加入jvm参数：
`-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8888`