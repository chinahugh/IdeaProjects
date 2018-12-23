#一般而言，Dockerfile分为四部分：基础镜像信息、维护者信息、镜像操作指令和容器启动是执行的指令。
模板如下：

#This dockerfile uses the Ubuntu image
#指定基于的基础镜像,可以使用多个FROM指令，每个镜像一次
#FROM <image>或FROM <image>:<tag>

#MAINTAINER 指定维护者信息
#MAINTAINER UserName <cheng@xxxx.com>

#ENV 指定一个环境变量，会被后续RUN指令使用，并在容器运行时保持。
#ENV <key> <value>

#RUN 镜像的操作指令
#格式为RUN <command>或RUN ["executable","param1","param2"],前者将在shell终端中运行命令，即/bin/sh -c;后者则可使用exec执行。

#复制本地主机的<src>（为Docker所在目录的相对路径，文件或目录）为容器中的<dest>。目标路径不存在是，会自动创建。当使用本地目录为源目录是，推荐使用COPY。
#COPY <src> <dest>

#ENTRYPOINT,有两种格式
#1.ENTRYPOINT ["executable","param1","param2"]
#2.ENTRYPOINT command param1 param2(shell中执行)
#每个Dockerfile只能有一个ENTRYPOINT,当指定多个时，如果指定多个ENTRYPOINT，只有最后一个生效。配置容器启动后执行的命令，并且不可被docker run提>供的参数覆盖。

#EXPOSE 告诉Docker服务端容器暴露的端口号，供互联系统使用。
#EXPOSE <port> [<port>...]

#复制指定的<src>到容器中的<dest>,其中<src>可以使Dockerfile所在目录的一个相对路径（文件或目录）;也可以是一个URL;还可以是一个tar文件（自动解压为目录）。
#ADD <src> <dest>

#VOLUME 创建一个可以从本地主机或其他容器挂载的挂载点，一般用来存放数据库和需要保持的数据等。
#VOLUME ["/data"]

#USER指定运行容器时的用户名或UID,后续的RUN也会使用指定用户。要临时获取管理员权限的时候要使用gosu，不推荐使用sudo。如果不指定，容器默认是root运行。
#USER daemon

#WORKDIR 为后续的RUN\CMD\ENTRYPOINT指令配置工作目录，可以使用多个WORKDIR指令，后续命令如果参数是相对路径，则会基于之前命令指定的路径。
#WORKDIR /path/to/workdir
#例如：
WORKDIR /a
WORKDIR b
WORKDIR c
RUN pwd
#则最终路径为/a/b/c

#ONBUILD 配置为所创建的镜像作为其他新创建镜像的基础镜像时，所执行的操作指令。使用ONBUILD指令的镜像，推荐在标签中注明，例如：nginx:1.9.11-onbuild。
#ONBUILD [INSTRUCTION]

#CMD 容器启动时执行指令，支持三种格式
#1.CMD ["executable","param1","param2"]
#2.CMD command param1 param2在/bin/sh中执行，提供给需要交互的应用
#3.CMD ["param1","param2"]提供给ENTRYPOINT的默认参数
#如果指定多条，只有最后一条会被执行，如果用户启动容器时指定了运行的命令，则会覆盖掉CMD指定的命令。

举个例子：
vi Dockerfile
#This dockerfile uses the pagekit
FROM ubuntu:trusty
MAINTAINER UserName<cheng@ule.com>
RUN apt-get update && \
apt-get -y install && \
nginx \
unzip \
wget \
ca-certificates \
php5 php5-fpm php5-cli php5-json php5-mysql php5-curl
ENV PAGEKIT_VERSION 1.0.2
RUN mkdir pagekit
WORKDIR /pagekit
VOLUME ["/pagekit/storage", "/pagekit/app/cache"]
RUN wget https://github.com/pagekit/pagekit/releases/download/$PAGEKIT_VERSION/pagekit-$PAGEKIT_VERSION.zip -O /pagekit/pagekit.zip && \
unzip /pagekit/pagekit.zip && rm /pagekit/pagekit.zip
ADD nginx.conf /etc/nginx/nginx.conf
RUN chown -R wwwdata: /pagekit && \
apt-get autoremove wget unzip -y && \
apt-get autoclean -y && \
apt-get clean -y && \
rm -rf /varf/lib/apt/list/ /tmp/ /var/tmp/*
CMD ["sh","-c","service php5-fpm start && nginx"]