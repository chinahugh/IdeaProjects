#!/bin/bash

echo "----------------------------------------------------------------------------------------">>
echo "----------------------------------------------------------------------------------------">>./git.sh.log
echo date
date>>./git.sh.log
git add $1 >>./git.sh.log
git commit -m $2 >>./git.sh.log
git pull >>./git.sh.log
git push origin master >>./git.sh.log