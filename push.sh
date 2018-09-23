#! /bin/bash 
echo start push...
echo "***************************************************************************">>push.log
date >>push.log
git add . >>push.log 2>&1
git commit -m $1 >>push.log 2>&1
git push origin master >>push.log 2>&1
