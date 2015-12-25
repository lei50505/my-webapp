
# Install Tools for Mac

* 新建文件夹

```
mkdir ~/Documents/dev
mkdir ~/Documents/dev/repo
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
export JAVA_HOME=export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home
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
cd ~/Documents/dev/tools/
tar -zxvf ~/Downloads/apache-tomcat-8.0.30.tar.gz
```

* 安装Spring Tool Suite3.6.4

```
sts-bundle -> /Applications
Preferences
Java -> Installed JREs
Server -> Runtime Environments
Maven -> Installations
General -> Editors -> Text Editors -> Insert spaces for tabs
Java -> Code Style -> Formatter -> New... -> Edit... -> Tab policy -> Spaces only
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
rabbitmq-server
rabbitmqctl stop
rabbitmqctl status
```