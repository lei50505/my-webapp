# Note

* MacBook设置

```
系统偏好设置 -> 用户与群组 -> 登录选项 -> 将快速用户切换菜单显示为 -> 图标
系统偏好设置 -> 安全性与隐私 -> 允许从以下位置下载的应用程序 -> 任何来源
系统偏好设置 -> 声音 -> 在菜单栏显示音量
菜单栏 -> 电池状态 -> 显示百分比
系统偏好设置 -> 键盘 -> 将F1、F2等键用作标准功能键
```

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

* 新建项目

```
cd ~/Documents/dev/repos
mvn archetype:generate -DgroupId=cn.rest -DartifactId=my-web -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeCatalog=local
cd my-web
mvn eclipse:eclipse

STS -> Import -> Existing Maven Projects -> Next
Root Directory -> ...dev/repos/my-web -> Finish

pom.xml
添加properties
<properties>
		<!-- 源文件编码,解决单独设置目标编码warning -->
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<!-- 编译jdk版本 -->
		<maven-compiler-plugin.source>1.8</maven-compiler-plugin.source>
		<!-- 目标jdk版本 -->
		<maven-compiler-plugin.target>1.8</maven-compiler-plugin.target>
		<!-- junit版本 -->
		<junit.version>4.12</junit.version>
</properties>

改junit.version
<dependencies>
		<!-- junit单元测试 -->
		<!-- junit-4.12.jar -->
		<!-- hamcrest-core-1.3.jar -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>${junit.version}</version>
			<scope>test</scope>
		</dependency>
</dependencies>

添加build
<build>
		<!-- 解决eclipse升级报错 -->
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.3</version>
					<configuration>
						<!-- jdk版本 -->
						<source>${maven-compiler-plugin.source}</source>
						<target>${maven-compiler-plugin.target}</target>
						<!-- 文件编码 -->
						<encoding>${project.build.sourceEncoding}</encoding>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
		<!-- target包名字 -->
		<finalName>my-web</finalName>
</build>

command + S 保存
command + shift + F 格式化代码
option + F5 更新项目

my-web -> Properties -> Java Build Path -> Libraries
jre
maven

option + F5 更新项目

New Source Folder -> 
src/main/resources
src/test/resources
各添加a.txt防止空目录不上传

command + S 保存

my-web -> Properties -> Java Build Path -> Order and Export
main/java
main/resources
test/java
test/resources
maven
jre

command + S 保存
command + shift + F 格式化代码
option + F5 更新项目

改<packaging>war</packaging>
command + S 保存
command + shift + F 格式化代码
option + F5 更新项目

my-web -> Properties
Project Facets -> Dynamic Web Module -> 勾取消 -> Apply -> 勾选中 -> 3.1 -> Further configuration available -> Content directory -> src/main/webapp -> Generate web.xml deployment descriptor
```

* 上传

```
cd ~/Documents/dev/repos/my-web
git init
option + F5 更新项目
my-web -> Team -> Share Project -> Git -> Next
option + F5 更新项目
git add -A
git commit -m "init"
GitHub创建my-web
git remote add origin git@github.com:lei50505/my-web.git
git push -u origin master
```

* 切入点表达式

```
	1）匹配类型
		用于匹配哪些类型的方法启用方面组件，语法格式如下
		within(类型)
		--匹配容器中EmpService的所有方法
			within(com.tarena.service.EmpService)
		--匹配com.tarena包下所有类的所有方法
			within(com.tarena.*)
		--匹配com.tarena包及子包的所有类的所有方法
			within(com.tarena..*)
	2）匹配方法
		用于匹配哪些方法启用方面组件，语法格式如下
		execution(修饰符? 返回类型 方法名(参数列表) throws异常?)
		--匹配所有对象的delete方法
			execution(* delete(..))
		--匹配EmpService的delete方法
			execution(* com.tarena.service.EmpService.delete(..))
		--匹配EmpService的所有方法
			execution(* com.tarena.dao.EmpService.*(..))
		--匹配com.tarena包下所有类的所有方法
			execution(* com.tarena.*.*(..))
		--匹配com.tarena包及子包下所有类的所有方法
				execution(* com.tarena..*.*(..))
	3）匹配bean名称
		用于匹配bean的id属性，语法格式如下
		bean(id属性值)
		--匹配id="empService"的组件的所有方法
			bean(empService)
		--匹配所有id以Service结尾的组件的所有方法
			bean(*Service)
	4）匹配参数
		用于匹配参数类型和个数，代码格式如下
		args(参数列表)
		--匹配有一个参数并且为String类型的所有方法
			args(java.lang.String)
```

* 整合SpringMVC

```
		pom.xml
		<!-- spring版本 -->
		<spring.version>4.2.3.RELEASE</spring.version>
		
		<!-- spring-webmvc -->
		<!-- spring-webmvc-4.2.3.RELEASE.jar -->
		<!-- spring-beans-4.2.3.RELEASE.jar -->
		<!-- spring-context-4.2.3.RELEASE.jar -->
		<!-- spring-aop-4.2.3.RELEASE.jar -->
		<!-- aopalliance-1.0.jar -->
		<!-- spring-core-4.2.3.RELEASE.jar -->
		<!-- commons-logging-1.2.jar -->
		<!-- spring-expression-4.2.3.RELEASE.jar -->
		<!-- spring-web-4.2.3.RELEASE.jar -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>

src/main/resources -> New -> Bean Configuration File
applicationContext.xml

<!-- DispatcherServlet -->

	web.xml
	<servlet>
		<servlet-name>SpringMVC</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:applicationContext.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

<servlet-mapping>
	<servlet-name>SpringMVC</servlet-name>
	<url-pattern>*.do</url-pattern>
</servlet-mapping>

<!-- component-scan -->

applicationContext.xml -> Namespaces -> 选中context
<context:component-scan base-package="cn.rest"></context:component-scan>
@Reposirory
@Servicce
@Controller
@Autowired / @Qualifier("loginServiceImpl")
@Resource(name="")

<!-- annotation-driven -->

<mvc:annotation-driven></mvc:annotation-driven>
@RequestMapping("/login")

<!-- InternalResourceViewResolver -->

<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix" value="/WEB-INF/"></property>
	<property name="suffix" value=".jsp"></property>
</bean>

<!-- SimpleMappingExceptionResolver -->

<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
	<property name="exceptionMappings">
		<props>
			<prop key="java.lang.Exception">main/error</prop>
		</props>
	</property>
</bean>

<!-- ExceptionHandler -->

@ExceptionHandler
public String doException(Exception e,
	HttpServletRequest request) 
	throws Exception {
	if(e instanceof CodeException
		|| e instanceof PasswordException) {
	} else {
		throw e;
	}
}

<!-- interceptors -->

<mvc:interceptors>
	<mvc:interceptor>
		<mvc:mapping path="/**"/>
		<mvc:exclude-mapping path="/login/toLogin.do"/>
		<mvc:exclude-mapping path="/login/validate.do"/>
		<bean class="com.tarena.interceptor.LoginInterceptor"></bean>
	</mvc:interceptor>
</mvc:interceptors>

<!-- LoginInterceptor -->

public class LoginInterceptor implements HandlerInterceptor {}

<!-- aspectj-autoproxy -->

<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
@Component
@Aspect
public class ExceptionLogger {
	@Around("within(com.tarena.web.*)")
	public Object log(ProceedingJoinPoint p) {
		Object result = null;
		try {
			result = p.proceed(); //µ÷ÓÃÄ¿±ê×é¼þ
		} catch (Throwable e) {
			e.printStackTrace();
			//log4j
			Logger logger = Logger.getLogger(this.getClass());
			ServletRequestAttributes sr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = sr.getRequest();
			User user = (User)request.getSession().getAttribute("user");
			String ip = request.getRemoteHost();
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String className = p.getTarget().getClass().getName();
			String methodName = p.getSignature().getName();
			if(user != null) {
				logger.error("ÓÃ»§[" + user.getCn_user_name() + "],");
			}
			logger.error("IP[" + ip + "],");
			logger.error("ÔÚ[" + now + "],");
			logger.error("µ÷ÓÃ[" + className + "." + methodName + "]Ê±£¬·¢ÉúÈçÏÂÒì³££º\n");
			StackTraceElement[] elems = e.getStackTrace();
			for(StackTraceElement elem : elems) {
				logger.error("\t" + elem.toString() + "\n");
			}
			return new Result(false,"ÏµÍ³Òì³££¬ÇëÁªÏµ¹ÜÀíÔ±.",null);
		}
		return result;
	}
}

<!-- Result -->

public class Result implements Serializable {
	private boolean success=true;
	private String message;
	private Object data;
}
```