# Create WebApp Maven

* 新建Maven项目

```
mvn archetype:generate -DgroupId=cn.springmvc -DartifactId=my-webapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeCatalog=local
```

* 转为Eclipse项目

```
cd my-webapp
mvn eclipse:eclipse
```

* 转为Web项目

```
pom.xml -> <packaging>war</packaging>
Eclipse -> Properties -> Project Facets -> Dynamic Web Module -> 勾取消 -> Apply -> 勾选中 -> 3.1 -> Further configuration available -> Content directory -> src/main/webapp -> Generate web.xml deployment descriptor
```

* 设置

```
New Source Folder -> src/main/resources -> src/test/resources -> a.txt

Eclipse -> Properties -> Java Build Path

Order and Export
main/java
main/resources
test/java
test/resources
maven
jre

Libraries
jre
maven

Source
main -> target/classes
test -> target/test-classes

Eclipse -> Properties -> Deployment Assembly
/src/main...
/target/m2e...
Maven...
```