#! /bin/bash 
echo start push...
date >>push.log
git add . >>push.log
git commit -m $1 >>push.log
git push origin master >>push.log
