# JavaReview
本地代码如何推送到git仓库

…or create a new repository on the command line
~~~shell
echo "# LeetCode" >> README.md
git init
git add README.md
git commit -m "first commit"
# 本地创建一个main分之
git branch -M main
# 将本地仓库和远程仓库建立联系
git remote add origin git@github.com:HYLijing/LeetCode.git
# 将本地代码推送到远程(origin)分支(main)上
git push -u origin main
~~~

…or push an existing repository from the command line
~~~shell
git remote add origin git@github.com:HYLijing/LeetCode.git
git branch -M main
git push -u origin main
~~~
