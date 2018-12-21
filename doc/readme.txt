1、新服务器，需要设置hostname，才能跑  quartz，否则会出现 Cannot run without an instance id & java.net.UnknownHostException
   sed -i "/^HOSTNAME=/c\HOSTNAME=s2" /etc/sysconfig/network
   echo -e "127.0.0.1 localhost s2" >> /etc/hosts
   hostname s2
需要执行上面这三句


################################################################################################
2、maven打包、自动部署
#打成 jar包 并上传和部署 (最后的 -Dmaven.test.skip=true，是指打包时不编译 test类)
clean package -P pro wagon:upload-single wagon:sshexec -Dmaven.test.skip=true
#只打包，不上传部署
clean package -P pro -Dmaven.test.skip=true
#打成 war包
clean package -f pom-war.xml -P pro -Dmaven.test.skip=true
#线上运行
#java -jar xxx.jar --spring.profiles.active=pro
nohup java -jar /export/App/usedcar/usedcar-1.0.0.jar --spring.profiles.active=pro --db.dbname=usedcar > /export/App/usedcar/run.log 2>&1 &



3、在已存在的目录下，想像git clone一样操作：
git clone git@github.com:xxx/xxx.git
等价于：
git init
git remote add origin git@github.com:xxx/xxx.git