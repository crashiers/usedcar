#!/bin/bash
#sudo -s
source /etc/profile
cd /export/web/usedcar
git pull
mvn clean package -P pro -Dmaven.test.skip=true
pkill java
nohup java -jar /export/web/usedcar/target/usedcar-1.0.0.jar --spring.profiles.active=pro --db.dbname=db_usedcar > /export/web/run.log 2>&1 &