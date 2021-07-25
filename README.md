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


# [git commit 和 git add 撤销 最终有效操作](https://www.cnblogs.com/zph666/p/12692734.html)

### 有关git reset --hard HEAD^后显示more?的解决方案

原因：这是因为cmd控制台中换行符默认是`^`，而不是`\` ，所以它的more？的意思是问你下一行是否需要再输入，而`^` 符号就被当做换行符而被git命令忽略掉了。

解决方法有如下几种：

```
一、加引号：git reset --hard ``"HEAD^"``二、加一个^：git reset --hard HEAD^^``三、换成~：git reset --hard HEAD~ 或者 git reset --hard HEAD~1
```

当然还可以换成git bash，powershell等就不会出现这种问题了

参考：https://www.cnblogs.com/zhaoatian/p/11677530.html

### **查看log日志**

```shell
git log
```

### 撤销此次**add，且未commit[常用]**

```shell
git reset HEAD~``git reset HEAD filename ``// 撤销某个文件
```

### **撤销此次commit ，保留add[常用]**

```shell
git reset --soft HEAD~
```

### **撤销此次commit 和 add【常用】（****不删除工作空间改动代码****）**

```shell
git reset HEAD~``or``git reset --mixed HEAD~
```

### **撤销commit 和 add【慎用】（****删除工作空间改动代码****），代码会回滚到最新的一次git pull的代码**

```
git reset --hard HEAD~
```