
# Install Tools for Mac

* 新建文件夹

```
mkdir ~/Documents/dev
mkdir ~/Documents/dev/repos
mkdir ~/Documents/dev/tools
```

* 安装MacDown

```
MacDown.app -> /Applications
```

* 安装Sublime Text 2

```
Sublime Text 2 -> /Applications
Help -> License
```

* 安装iTerm2

```
http://www.iterm2.com
iTerm.app -> /Applications
```

* 安装Homebrew

```
http://brew.sh
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

* 安装Git

```
brew install git
git config --global push.default simple
git config --global user.name "CAOLEI"
git config --global user.email 183515951@qq.com
```

* 安装Oh My Zsh

```
http://ohmyz.sh
$ sh -c "$(curl -fsSL https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
brew install autojump
vi ~/.zshrc
plugins=(git autojump)
```

* 安装JDK8

```
使用Pkg包安装
vi ~/.zshrc
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home
```

* 安装Maven

```
cd ~/Documents/dev/tools/
tar -xzvf ~/Downloads/apache-maven-3.3.9-bin.tar.gz
vi ~/.zshrc
export PATH=/Users/CAOLEI/Documents/dev/tools/apache-maven-3.3.9/bin:$PATH
```

* 安装Tomcat8

```
拷贝apache-tomcat-8.0.30.tar.gz -> 下载
cd ~/Documents/dev/tools/
tar -zxvf ~/Downloads/apache-tomcat-8.0.30.tar.gz
```

* 安装Spring Tool Suite 3.6.4

```
拷贝spring-tool-suite-3.6.4.RELEASE-e4.4.2-macosx-cocoa-x86_64.tar.gz -> 下载
双击spring-tool-suite-3.6.4.RELEASE-e4.4.2-macosx-cocoa-x86_64.tar.gz
拖动sts-bundle -> 应用程序
Launchpad -> sts-bundle -> 拖动STS -> Launchpad根目录

打开STS
Select a workspace
Workspace默认 -> /Users/CAOLEI/Documents/workspace-sts-3.6.4.RELEASE
选中Use this as the defult... -> OK

Preferences
Install/Update -> Automatic Update -> 取消Automatically find...
Java -> Installed JREs -> 选择版本
Server -> Runtime Environments -> Add... -> Tomcat v8.0 + Create a new... -> OK -> Tomcat installation directory -> dev/tools/apache-tomcat-8.0.30 -> Finish
Maven -> Installations -> Add... -> Installation home -> dev/tools/apache-maven-3.3.9 -> Finish -> 选择新添加 -> Apply
General -> Editors -> Text Editors -> 选中Insert spaces for tabs -> OK
Java -> Code Style -> Formatter -> Edit... -> Tab policy -> 选Spaces only -> Profile name -> 改Spaces only -> OK

布局
左
Package Explorer
下
Console
Servers
Problems
Progress
右
Outline

Confirm Exit -> 选中Always exit without prompt
```

* 安装MySQL

```
cd /usr/local/
tar -zxvf ~/Downloads/mysql-5.7.9-osx10.10-x86_64.tar.gz
ln -s mysql-5.7.9-osx10.10-x86_64 mysql
cd mysql/
bin/mysqld --initialize
localhost: fy99t.HeTnK=
support-files/mysql.server start
bin/mysql -u root -p
set password = password("password");

support-files/mysql.server restart
support-files/mysql.server stop
support-files/mysql.server status
```

* 安装RabbitMQ

```
cd ~/Documents/dev/tools
tar -zxvf ~/Downloads/rabbitmq-server-mac-standalone-3.6.0.tar.xz

cd
vi .zshrc
export RABBITMQ_HOME=/Users/CAOLEI/Documents/dev/tools/rabbitmq_server-3.6.0
export PATH=$RABBITMQ_HOME/sbin:$PATH

sudo scutil --set HostName localhost
rabbitmq-server -detached
rabbitmqctl stop
rabbitmqctl status
```