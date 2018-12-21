#!/bin/bash

# 安装elasticsearch
mkdir -p /root/apps
cd /root
tar -zxvf soft/elasticsearch-2.3.1.tar.gz -C apps
cd apps
ln -s elasticsearch-2.3.1 elasticsearch
cd elasticsearch

mkdir -p /export/data
cat >> config/elasticsearch.yml << EOF
#集群名称，通过组播的方式通信，通过名称判断属于哪个集群
cluster.name: hadoop
#节点名称，要唯一，这里其实是 s1,为了下面替换方便，临时弄成了 _s1
node.name: _s1
#数据存放位置
path.data: /export/data/es/data
#日志存放位置
path.logs: /export/data/es/logs
#es绑定的ip地址，这里其实是 s1,为了下面替换方便，临时弄成了 _s1
network.host: _s1
# 默认端口就是9200，所以不需要加此行
# http.port: 9200
#初始化时可进行选举的节点，不依赖于zokeeper，自己有选举的模块
discovery.zen.ping.unicast.hosts: ["s1", "s2"]
EOF



#### 分发安装包
SERVERS=(
	2
)
i=1
for SERVERNUM in ${SERVERS[@]}
do
	cd /root/apps
	SERVER="s${SERVERNUM}"
	ssh $SERVER "mkdir -p /root/apps"
	scp -r elasticsearch-2.3.1 $SERVER:/root/apps
	ssh $SERVER "cd /root/apps;ln -s elasticsearch-2.3.1 elasticsearch;"
	ssh $SERVER "mkdir -p /export/data"
	#修改别的机器的 node.name和network.host，分别为s2，s3等
	exe="s/_s1/${SERVER}/g"
	ssh $SERVER "sed -i ${exe} /root/apps/elasticsearch/config/elasticsearch.yml"
	let i+=1
done

# 把本机的ss1 再替换为 s1
sed -i 's/_s1/s1/g' /root/apps/elasticsearch/config/elasticsearch.yml


## 启动后 jps 会看到  Elasticsearch

## 用浏览器访问es所在机器的9200端口
#http://s1:9200/

## 杀掉进程
#kill `ps -ef | grep Elasticsearch | grep -v grep | awk '{print $2}'`

#------------------------------------------------------------------------------------------------------------------
#es安装插件下载es的head插件
#/root/apps/elasticsearch/bin/plugin install mobz/elasticsearch-head

# 本地方式离线安装head插件，这个插件是提供强大的web管理界面，可以在那查看索引的全部信息，非常强大。
/root/apps/elasticsearch/bin/plugin install file:///root/soft/elasticsearch-head-master.zip

#访问head管理页面
#http://s1:9200/_plugin/head



## 启动es，需要在本机和其他机器都启动
/root/apps/elasticsearch/bin/elasticsearch -Des.insecure.allow.root=true -d

# 其它机器启动
SERVERS=(
	2
)
i=1
for SERVERNUM in ${SERVERS[@]}
do
	SERVER="s${SERVERNUM}"
	ssh $SERVER "source /etc/profile;/root/apps/elasticsearch/bin/elasticsearch -Des.insecure.allow.root=true -d"
	let i+=1
done
