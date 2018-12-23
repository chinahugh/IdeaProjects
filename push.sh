#! /bin/bash 
read -t 36000  -p "请输入本次提交信息 " msg
echo start push...
echo "******************************************************************************************************">>push.log
date >>push.log
echo "message >>>>> $msg">>push.log
git add . >>push.log 2>&1
git commit -m "$msg" >>push.log 2>&1
git push origin master >>push.log 2>&1
