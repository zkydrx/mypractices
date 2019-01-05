package KnowledgeableReview201901.designPatterns.designPatternsInJdk;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-05
 * Time: 13:01:54
 * Description:
 */
public class SomeDemo implements Cloneable
{
    /**
     * 创建型模式：
     * (1) 抽象工厂模式(Abstract Factory)
     * • java.util.Calendar#getInstance()
     * • java.util.Arrays#asList()
     * • java.util.ResourceBundle#getBundle()
     * • java.net.URL#openConnection()
     * • java.sql.DriverManager#getConnection()
     * • java.sql.Connection#createStatement()
     * • java.sql.Statement#executeQuery()
     * • java.text.NumberFormat#getInstance()
     * • java.lang.management.ManagementFactory (所有getXXX()方法)
     * • java.nio.charset.Charset#forName()
     * • javax.xml.parsers.DocumentBuilderFactory#newInstance()
     * • javax.xml.transform.TransformerFactory#newInstance()
     * • javax.xml.xpath.XPathFactory#newInstance()
     * <p>
     * (2) 建造者模式(Builder)
     * • java.lang.StringBuilder#append()
     * • java.lang.StringBuffer#append()
     * • java.nio.ByteBuffer#put() (CharBuffer, ShortBuffer, IntBuffer,LongBuffer, FloatBuffer 和DoubleBuffer与之类似)
     * • javax.swing.GroupLayout.Group#addComponent()
     * • java.sql.PreparedStatement
     * • java.lang.Appendable的所有实现类
     * <p>
     * (3) 工厂方法模式(Factory Method)
     * • java.lang.Object#toString() (在其子类中可以覆盖该方法)
     * • java.lang.Class#newInstance()
     * • java.lang.Integer#valueOf(String) (Boolean, Byte, Character,Short, Long, Float 和 Double与之类似)
     * • java.lang.Class#forName()
     * • java.lang.reflect.Array#newInstance()
     * • java.lang.reflect.Constructor#newInstance()
     * <p>
     * (4) 原型模式(Prototype)
     * • java.lang.Object#clone() (支持浅克隆的类必须实现java.lang.Cloneable接口)
     * <p>
     * (5) 单例模式 (Singleton)
     * • java.lang.Runtime#getRuntime()
     * • java.awt.Desktop#getDesktop()
     */
    @Test
    public void testCreateMoudle() throws ClassNotFoundException, CloneNotSupportedException, IOException
    {
        /**
         * 抽象工厂模式(Abstract Factory)
         */
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 23});
        System.out.println(integers.get(0));

        /**
         * 建造者模式(Builder)
         */
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Google ")
                                            .append("Apple ")
                                            .append("Amazon ")
                                            .append("Microsoft ")
                                            .append("Are Wonderful Company Over The World!");
        System.out.println(append);

        /**
         * 工厂方法模式(Factory Method)
         */
        Integer integer = Integer.valueOf("123");
        System.out.println(integer);
        Class<?> aClass = Class.forName("KnowledgeableReview201901.designPatterns.designPatternsInJdk.Dog");
        System.out.println(Arrays.asList(aClass.getMethods()));
        System.out.println(Arrays.asList(aClass.getConstructors()));

        /**
         * 原型模式(Prototype)
         */
        Object clone = clone();
        System.out.println(clone);


        /**
         * 单例模式 (Singleton)
         */
        Desktop desktop = Desktop.getDesktop();

        desktop.open(new File("C:\\Users\\19644\\Desktop\\Snipaste_2019-01-05_10-12-46.png"));
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.availableProcessors());
        runtime.gc();


    }

    /**
     * 结构型模式：
     * (1) 适配器模式(Adapter)
     * •java.util.Arrays#asList()
     * •javax.swing.JTable(TableModel)
     * •java.io.InputStreamReader(InputStream)
     * •java.io.OutputStreamWriter(OutputStream)
     * •javax.xml.bind.annotation.adapters.XmlAdapter#marshal()
     * •javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal()
     *
     * (2) 桥接模式(Bridge)
     * • AWT (提供了抽象层映射于实际的操作系统)
     * •JDBC
     *
     * (3) 组合模式(Composite)
     * •javax.swing.JComponent#add(Component)
     * •java.awt.Container#add(Component)
     * •java.util.Map#putAll(Map)
     * •java.util.List#addAll(Collection)
     * •java.util.Set#addAll(Collection)
     *
     * (4) 装饰模式(Decorator)
     * •java.io.BufferedInputStream(InputStream)
     * •java.io.DataInputStream(InputStream)
     * •java.io.BufferedOutputStream(OutputStream)
     * •java.util.zip.ZipOutputStream(OutputStream)
     * •java.util.Collections#checked[List|Map|Set|SortedSet|SortedMap]()
     *
     * (5) 外观模式(Facade)
     * •java.lang.Class
     * •javax.faces.webapp.FacesServlet
     *
     * (6) 享元模式(Flyweight)
     * •java.lang.Integer#valueOf(int)
     * •java.lang.Boolean#valueOf(boolean)
     * • java.lang.Byte#valueOf(byte)
     * •java.lang.Character#valueOf(char)
     *
     * (7) 代理模式(Proxy)
     * • java.lang.reflect.Proxy
     * •java.rmi.*
     */
    @Test
    public void testStructure() throws IOException, InterruptedException
    {

        /**
         * 适配器模式(Adapter)
         */
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File
                ("D:\\document\\temp.txt")));
        outputStreamWriter.write("Fly with me!");
        outputStreamWriter.flush();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\document\\temp" +
                ".txt")));
        int charread;
        char[] tempchars = new char[10];
        while ((charread= inputStreamReader.read(tempchars)) != -1)
        {
            for (int i = 0; i <charread ; i++)
            {
                System.out.print(tempchars[i]);
            }
        }
        BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
        System.out.println(inputStreamReader.read());
        String lineText = null;
        /**
         * BufferedReader无法读取首行的首个字符，是个bug.
         */
        while ((lineText=bufferedReader.readLine()) != null)
        {
            System.out.println(lineText);
        }

        /**
         * 组合模式(Composite)
         */
        List list = new ArrayList();
        list.addAll(Arrays.asList(new String[]{"123","Github","git","Linux","FreeBSD","docker","Maven"}));
        System.out.println(list);

        /**
         * 装饰模式(Decorator)
         */
        Dog dog = new Dog(1L,"amy","12","red","20");
        list.add(dog);
        List list1 = Collections.checkedList(list, Dog.class);
        System.out.println(list1);

    }
}
