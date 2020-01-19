# 技术积累和总结

#### 从jdk8 切换到jdk11的注意事项
一些背景
在背景知识，我们会讨论一些关于新的JDK Release周期，OpenJDK特性归一化，LTS（Long-term support长期支持版本）的事情。

1. 新的发布周期
这个就可以长话短说了，反正我们知道如下两点就好：

每六个月发布一个大更新（就是每年的3月还有9月）
对于每个大版本更新，会有两次小版本更新（在发布后一个月或者四个月之后）
2. OpenJDK已可以作为新的线上标准JDK
在2018.9之前，Oracle JDK是大家普遍运用于线上的JDK，OpenJDK的特性并不完全，并且Oracle JDK号称做了很多优化。在2018.9之后，Oracle JDK正式商用（开发不收费，但是运行线上业务收费）。但是与此同时，Oracle宣布，OpenJDK与Oracle JDK在功能上不会有区别。并且，OpenJDK 11 RTS将会由红帽社区进行维护。这样，更加增加了可靠性与保证问题的及时解决。

我们可以在线上使用OpenJDK，开发时，使用任意的JDK。

3. LTS（Long-term support长期维护）版本
对于商业版的JDK，不同的厂商都将长期维护版本定在JDK 11/17/23/...

对于OpenJDK，社区说，对于这些版本，至少会提供四年的维护更新时间。每个长期维护版本都会有一个固定的管理者，对于OpenJDK11，应该就是红帽社区。现在源代码搞定了，但是，我们应该从哪里获取编译好的OpenJDK呢？这个可以交给AdoptOpenJDK，它会一直收集不同版本的OpenJDK以及全平台的build好的OpenJDK

4. Amazon Corretto
AWS也提供了自己的OpenJDK，Amazon Corretto：

基于OpenJDK，采取GPL+CE协议，做了一些安全性，性能和稳定性优化，并且修复了一些bug
支持linux，MAC OS还有Windows操作系统
长期支持Java 8并且至少到2023年
从2019年开始支持Java 11并且至少到2024
季度更新，并且伴随一些紧急bug修复的更新
OpenJDK社区的FAQ部分曾经提到：“Amazon从2017年开始贡献OpenJDK，并且计划开始大量贡献”。我猜Amazon会把他们在Corretto上面做的优化，合并到OpenJDK源码中，即使没有，Corretto也是开源的，迟早会有人参考并在OpenJDK源码上进行修改。同时也说明，OpenJDK的更新也会及时被合并到Corretto中。

准备迁移
1. 更新好开发环境以及编译环境
各种常用工具，建议升级到如下版本以后：

IntelliJ IDEA: 2018.2
Eclipse: Photon 4.9RC2 with Java 11 plugin
Maven: 3.5.0
Maven compiler plugin: 3.8.0
surefire and failsafe: 2.22.0
Gradle: 5.0
对于如下工具，由于已经不再维护，需要替换成其他工具：

FindBugs（静态代码bug发现）： 用SpotBugs替换。
Cobertura（代码测试覆盖率）：用Jacoco替换
同时由于在Java 9 之后，每六个月bytecode level会提升一次。如果你依赖的库有处理字节码相关的库，应该注意下版本升级，例如：

对于直接操作字节码的库，如果你升级了JDK，那么最好也跟着升级这些库：ASM (7.0), Byte Buddy (1.9.0), cglib (3.2.8), or Javassist (3.23.1-GA).这些版本是OpenJDK11适用的版本
如果你使用的库依赖了上面提到的操作字节码的库，那么也需要注意下版本依赖，看依赖的操作字节码的库是否升级到了上面提到的版本。对于Spring，最好采用5.1以后的版本， Mockito则是2.20.0以后的版本
2. 引入JPMS后，相关的迁移工作
2.1. Java EE相关模块默认不在Java包里面了，相关的类需要增加额外依赖或者替换成其他的类
如果你的项目中使用了这些类，那么在编译阶段就会报错，例如：

error: package javax.xml.bind does not exist
import javax.xml.bind.JAXBException;
                     ^
如果你是用JDK 8编译成功，拿到JDK 11运行，就会报错：

Exception in thread "main" java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
    at monitor.Main.main(Main.java:27)
Caused by: java.lang.ClassNotFoundException: javax.xml.bind.JAXBException
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:582)
    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:185)
    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:496)
    ... 1 more
以下是相关移除列表还有解决方案

JavaBeans Activation Framework (JAF) （javax.activation）变成了一个独立的框架，maven依赖：
<dependency>
    <groupId>com.sun.activation</groupId>
    <artifactId>javax.activation</artifactId>
    <version>1.2.0</version>
</dependency>
CORBA(java.corba)在JEP 230已经不复存在了，在你的项目中如果遇到，证明你的项目太古老了。移除掉吧
JTA (java.transaction)变成了独立依赖：
<dependency>
    <groupId>javax.transaction</groupId>
    <artifactId>javax.transaction-api</artifactId>
    <version>1.2</version>
</dependency>
JAXB和JAX-WS：
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.2.8</version>
</dependency>
<dependency>
    <groupId>com.sun.xml.bind</groupId>
    <artifactId>jaxb-core</artifactId>
    <version>2.2.8</version>
</dependency>
<dependency>
    <groupId>com.sun.xml.bind</groupId>
    <artifactId>jaxb-impl</artifactId>
    <version>2.2.8</version>
</dependency>
<dependency>
    <groupId>com.sun.xml.ws</groupId>
    <artifactId>jaxws-ri</artifactId>
    <version>2.3.0</version>
    <type>pom</type>
</dependency>
Common Annotations:
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.1</version>
</dependency>
一个建议就是，在你的项目中如果没有冲突，建议都加上这些依赖。

2.2. 模块可见性导致的内部API不能调用的问题
这个在我另一篇文章也说过：https://zhanghaoxin.blog.csdn.net/article/details/90514045

在Java9之后引入了模块化的概念，是将类型和资源封装在模块中，并仅导出其他模块要访问其公共类型的软件包。如果模块中的软件包未导出或打开，则表示模块的设计人员无意在模块外部使用这些软件包。 这样的包可能会被修改或甚至从模块中删除，无需任何通知。 如果仍然使用这些软件包通过使用命令行选项导出或打开它们，可能会面临破坏应用程序的风险！

对于这种限制，在编译阶段，可能会有类似下面的报错：

error: package com.sun.imageio.plugins.jpeg is not visible
import com.sun.imageio.plugins.jpeg.JPEG;
                              ^
  (package com.sun.imageio.plugins.jpeg is declared
  in module java.desktop, which does not export it)
如果是反射的调用，可能在运行阶段有类似于如下的报警：

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by j9ms.internal.JPEG
    (file:...) to field com.sun.imageio.plugins.jpeg.JPEG.TEM
WARNING: Please consider reporting this
    to the maintainers of j9ms.internal.JPEG
WARNING: Use --illegal-access=warn to enable warnings
    of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
# here's the reflective access to the static field com.sun.imageio.plugins.jpeg.JPEG.TEM
对于这种错误，我们最好是更换API，如果难以实现，则可以通过添加编译以及启动参数解决。

我们需要的参数是：

--add-exports选项:模块声明中的exports语句将模块中的包导出到所有或其他模块，因此这些模块可以使用该包中的公共API。 如果程序包未由模块导出，则可以使用-add-exports的命令行选项导出程序包:
--add-exports <source-module>/<package>=<target-module-list>
如果设置target-module-list为ALL-UNNAMED，那么所有Classpath下的module，都可以访问source-module中的pakage包下的公共API

--add-opens选项: 模块声明中的opens语句使模块里面的包对其他模块开放，因此这些模块可以在运行期使用深层反射访问该程序包中的所有成员类型。 如果一个模块的包未打开，可以使用--add-opens命令行选项打开它。 其语法如下：
--add-opens <source-module>/<package>=<target-module-list>
如果设置target-module-list为ALL-UNNAMED，那么所有Classpath下的module，都可以访问source-module中的pakage包下的所有成员类型

对于编译阶段，也就是javac命令，我们只需要添加--add-exports，对于上面的例子，就是：

javac --add-exports java.desktop/com.sun.imageio.plugins.jpeg=ALL-UNNAMED
对于运行阶段，也就是java命令，我们最好把--add-exports和--add-open都加上，对于上面的例子，就是：

java --add-exports java.desktop/com.sun.imageio.plugins.jpeg=ALL-UNNAMED --add-open java.desktop/com.sun.imageio.plugins.jpeg=ALL-UNNAMED
这样，在运行阶段，首先不会有禁止访问报错，同时也不会有警告。

同时，为了在运行期能找到所有需要添加的模块和包，可以通过添加--illegal-access=${value}来检查。这个value可以填写：

permit: 未来可能会移除。仅在第一次反射调用内部api的时候报警
warn：每次次反射调用内部api的时候报警
debug：在warn的基础上，加上堆栈输出
deny: 拒绝所有非法反射访问内部api
我们可以设置--illegal-access=deny来知道我们需要添加的所有--add-export和--add-open包。

2.3 通过JDK11内置jdeps工具查找过期以及废弃API以及对应的替换
这个也在我另一篇文章提到过：https://zhanghaoxin.blog.csdn.net/article/details/100732605

jdeps --jdk-internals -R --class-path 'libs/*' $project
libs是你的所有依赖的目录，$project是你的项目jar包，示例输出：

...
JDK Internal API                         Suggested Replacement
----------------                         ---------------------
sun.misc.BASE64Encoder                   Use java.util.Base64 @since 1.8
sun.reflect.Reflection                   Use java.lang.StackWalker @since 9
在这里简单提一些在JDK11过期，但是JDK8使用的API：

sun.misc.Base64 (替换成 java.util.Base64)
com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel (替换成 javax.swing.plaf.nimbus.NimbusLookAndFeel)
java.util.LogManager, java.util.jar.Pack200.Packer类 Unpacker: addPropertyChangeListener 和 removePropertyChangeListener这两个方法已经移除
java.lang.Runtime类: methods getLocalizedInputStream 和 getLocalizedOutputStream方法已经移除
SecurityManager的操作方法已经整体移除
2.4. ClassLoader变化带来的URLClassLoader的变化
Java 8的ClassLoader流程：

bootstrap classloader加载rt.jar，jre/lib/endorsed
ext classloader加载jre/lib/ext
application classloader加载-cp指定的类
java9及之后的classloader流程：

bootstrap classloader加载lib/modules
ext classloader更名为platform classloader，加载lib/modules
application classloader加载-cp，-mp指定的类
同时，我们注意到，JDK9开始，AppClassLoader他爹不再是 URLClassLoader

一般热部署，插件部署，都会使用到AppClassLoader，例如Spring-Boot的热部署，老版本的会报异常：

Exception in thread "main" java.lang.ClassCastException: java.base/jdk.internal.loader.ClassLoaders$AppClassLoader cannot be cast to java.base/java.net.URLClassLoader
    at org.springframework.boot.devtools.restart.DefaultRestartInitializer.getUrls(DefaultRestartInitializer.java:93)
    at org.springframework.boot.devtools.restart.DefaultRestartInitializer.getInitialUrls(DefaultRestartInitializer.java:56)
    at org.springframework.boot.devtools.restart.Restarter.<init>(Restarter.java:140)
    at org.springframework.boot.devtools.restart.Restarter.initialize(Restarter.java:546)
    at org.springframework.boot.devtools.restart.RestartApplicationListener.onApplicationStartingEvent(RestartApplicationListener.java:67)
    at org.springframework.boot.devtools.restart.RestartApplicationListener.onApplicationEvent(RestartApplicationListener.java:45)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:172)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:165)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:139)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:122)
    at org.springframework.boot.context.event.EventPublishingRunListener.starting(EventPublishingRunListener.java:69)
    at org.springframework.boot.SpringApplicationRunListeners.starting(SpringApplicationRunListeners.java:48)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:292)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1107)
    at com.asofdate.AsofdateMain.main(AsofdateMain.java:18)
这是主要是因为AppClassLoader不再是URLClassLoader的子类导致的。

之前对于动态加载的类，我们总是通过将这个类通过反射调用URLClassLoader加到classpath里面进行加载。这么加载在JDK11中已经无法实现，并且这样加载的类不能卸载。 对于动态加载的类，我们在OpenJDK11中只能自定义类加载器去加载，而不是通过获取APPClassLoader去加载。同时，这么做也有助于你随时能将动态加载的类卸载，因为并没有加载到APPClassLoader。

建议使用自定义的类加载器继承SecureClassLoader去加载类：java.security.SecureClassLoader

最后，如果你想访问classpath下的内容，你可以读取环境变量：

String pathSeparator = System
    .getProperty("path.separator");
String[] classPathEntries = System
    .getProperty("java.class.path")
    .split(pathSeparator);
2.5. 过期启动参数修改
JDK 8 到JDK 11有很多参数变化，可以总结为两类参数的变化，一是GC相关的（GC配置调优更加简单），二是日志相关的，日志统一到了一起，不像之前那么混乱

具体请参考：

https://docs.oracle.com/en/java/javase/11/tools/java.html#GUID-4856361B-8BFD-4964-AE84-121F5F6CF111
https://docs.oracle.com/javase/9/tools/java.htm#JSWOR-GUID-4856361B-8BFD-4964-AE84-121F5F6CF111
https://docs.oracle.com/javase/10/tools/java.htm#GUID-3B1CE181-CD30-4178-9602-230B800D4FAE__REMOVEDJAVAOPTIONS-A4E6F213
每个说明参考三部分：

Obsolete Java Options: 参数可以被接受但是忽略掉了，但是会有警告，一般这种参数有替代写法，请用替代的写法
Deprecated Java Options: 参数可以被接受并有效，但是会有警告，一般这种参数有替代写法，请用替代的写法
Removed Java Options: 参数被移除，并且使用的话会有报错
3. 一些框架的OpenJDK11兼容问题持续收集（持续更新中）
OpenJDK11与Spring Cloud Finchley的不兼容问题与解决: https://blog.csdn.net/zhxdick/article/details/102314886
Lombok编译异常: 升级到1.18.+的版本才可以
Spring Cloud Hystrix ThreadPool的bug：Spring Cloud Hystrix ThreadPool的bug



## License
[Apache License](https://github.com/zkydrx/mypractices/blob/master/LICENSE)
