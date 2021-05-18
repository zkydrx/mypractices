package com.hundsun.practices.path;

/**
 * 文件描述
 * 获取配置文件路径的各种方式
 * ├── pom.xml
 * ├── src
 * │  ├── main
 * │  │  ├── java
 * │  │  │  ├── com
 * │  │  │  │  ├── alipay
 * │  │  │  │  │  ├── ResourceTest.java
 * │  │  │  │  │  └── Resource.java
 * │  │  └── resources
 * │  │  │  ├── conf
 * │  │  │  │  ├── sysConf.json
 * │  │  │  └── request.xml
 * └── local.iml
 **/
public class ResourcesPathTest
{
    public static void main(String[] args)
    {
        // 1、通过Class的getResource方法
        String a1 = ResourcesPathTest.class.getResource("/com/alipay/Resource.class").getPath();
        String a2 = ResourcesPathTest.class.getResource("Resource.class").getPath();
        String a3 = ResourcesPathTest.class.getResource("/request.xml").getPath();
        String a4 = ResourcesPathTest.class.getResource("../../request.xml").getPath();
        String a5 = ResourcesPathTest.class.getResource("/conf/sysConf.json").getPath();
        String a6 = ResourcesPathTest.class.getResource("../../conf/sysConf.json").getPath();

        // 2、通过本类的ClassLoader的getResource方法
        String b1 = ResourcesPathTest.class.getClassLoader().getResource("com/alipay/Resource.class").getPath();
        String b2 = ResourcesPathTest.class.getClassLoader().getResource("request.xml").getPath();
        String b3 = ResourcesPathTest.class.getClassLoader().getResource("conf/sysConf.json").getPath();

        // 3、通过ClassLoader的getSystemResource方法
        String c1 = ClassLoader.getSystemClassLoader().getResource("com/alipay/Resource.class").getPath();
        String c2 = ClassLoader.getSystemClassLoader().getResource("request.xml").getPath();
        String c3 = ClassLoader.getSystemClassLoader().getResource("conf/sysConf.json").getPath();

        // 4、通过ClassLoader的getSystemResource方法
        String d1 = ClassLoader.getSystemResource("com/alipay/Resource.class").getPath();
        String d2 = ClassLoader.getSystemResource("request.xml").getPath();
        String d3 = ClassLoader.getSystemResource("conf/sysConf.json").getPath();

        // 5、通过Thread方式
        String e1 = Thread.currentThread().getContextClassLoader().getResource("com/alipay/Resource.class").getPath();
        String e2 = Thread.currentThread().getContextClassLoader().getResource("request.xml").getPath();
        String e3 = Thread.currentThread().getContextClassLoader().getResource("conf/sysConf.json").getPath();

    }
}
