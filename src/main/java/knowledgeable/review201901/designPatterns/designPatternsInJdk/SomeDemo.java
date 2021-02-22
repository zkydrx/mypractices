package knowledgeable.review201901.designPatterns.designPatternsInJdk;

import knowledgeable.review201901.designPatterns.designPatternsInJdk.comparable.Person;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Class<?> aClass = Class.forName("knowledgeable.review201901.designPatterns.designPatternsInJdk.Dog");
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
     * <p>
     * (2) 桥接模式(Bridge)
     * • AWT (提供了抽象层映射于实际的操作系统)
     * •JDBC
     * <p>
     * (3) 组合模式(Composite)
     * •javax.swing.JComponent#add(Component)
     * •java.awt.Container#add(Component)
     * •java.util.Map#putAll(Map)
     * •java.util.List#addAll(Collection)
     * •java.util.Set#addAll(Collection)
     * <p>
     * (4) 装饰模式(Decorator)
     * •java.io.BufferedInputStream(InputStream)
     * •java.io.DataInputStream(InputStream)
     * •java.io.BufferedOutputStream(OutputStream)
     * •java.util.zip.ZipOutputStream(OutputStream)
     * •java.util.Collections#checked[List|Map|Set|SortedSet|SortedMap]()
     * <p>
     * (5) 外观模式(Facade)
     * •java.lang.Class
     * •javax.faces.webapp.FacesServlet
     * <p>
     * (6) 享元模式(Flyweight)
     * •java.lang.Integer#valueOf(int)
     * •java.lang.Boolean#valueOf(boolean)
     * • java.lang.Byte#valueOf(byte)
     * •java.lang.Character#valueOf(char)
     * <p>
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

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\document\\temp"
                + ".txt")));
        int charread;
        char[] tempchars = new char[10];
        while ((charread = inputStreamReader.read(tempchars)) != -1)
        {
            for (int i = 0; i < charread; i++)
            {
                System.out.print(tempchars[i]);
            }
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(inputStreamReader.read());
        String lineText = null;
        /**
         * BufferedReader无法读取首行的首个字符，是个bug.
         */
        while ((lineText = bufferedReader.readLine()) != null)
        {
            System.out.println(lineText);
        }

        /**
         * 组合模式(Composite)
         */
        List list = new ArrayList();
        list.addAll(Arrays.asList(new String[]{"123", "Github", "git", "Linux", "FreeBSD", "docker", "Maven"}));
        System.out.println(list);

        /**
         * 装饰模式(Decorator)
         */
        Dog dog = new Dog(1L, "amy", "12", "red", "20");
        list.add(dog);
        List list1 = Collections.checkedList(list, Dog.class);
        System.out.println(list1);

        /**
         * 享元模式(Flyweight)
         */
        Integer integer = Integer.valueOf("123");
        System.out.println(integer);
    }

    /**
     * 行为型模式：
     * (1) 职责链模式(Chain of Responsibility)
     * •java.util.logging.Logger#log()
     * •javax.servlet.Filter#doFilter()
     * <p>
     * (2) 命令模式(Command)
     * • java.lang.Runnable
     * • javax.swing.Action
     * <p>
     * (3) 解释器模式(Interpreter)
     * • java.util.Pattern
     * • java.text.Normalizer
     * • java.text.Format
     * • javax.el.ELResolver
     * <p>
     * (4) 迭代器模式(Iterator)
     * • java.util.Iterator
     * • java.util.Enumeration
     * <p>
     * (5) 中介者模式(Mediator)
     * • java.util.Timer (所有scheduleXXX()方法)
     * • java.util.concurrent.Executor#execute()
     * • java.util.concurrent.ExecutorService (invokeXXX()和submit()方法)
     * • java.util.concurrent.ScheduledExecutorService (所有scheduleXXX()方法)
     * •java.lang.reflect.Method#invoke()
     * <p>
     * (6) 备忘录模式(Memento)
     * •java.util.Date
     * •java.io.Serializable
     * •javax.faces.component.StateHolder
     * <p>
     * (7) 观察者模式(Observer)
     * •java.util.Observer/java.util.Observable
     * •java.util.EventListener (所有子类)
     * •javax.servlet.http.HttpSessionBindingListener
     * •javax.servlet.http.HttpSessionAttributeListener
     * •javax.faces.event.PhaseListener
     * <p>
     * (8) 状态模式(State)
     * •java.util.Iterator
     * •javax.faces.lifecycle.LifeCycle#execute()
     * <p>
     * (9) 策略模式(Strategy)
     * • java.util.Comparator#compare()
     * • javax.servlet.http.HttpServlet
     * • javax.servlet.Filter#doFilter()
     * <p>
     * (10) 模板方法模式(Template Method)
     * •java.io.InputStream, java.io.OutputStream, java.io.Reader和java.io.Writer的所有非抽象方法
     * •java.util.AbstractList, java.util.AbstractSet和java.util.AbstractMap的所有非抽象方法
     * •javax.servlet.http.HttpServlet#doXXX()
     * <p>
     * (11) 访问者模式(Visitor)
     * •javax.lang.model.element.AnnotationValue和AnnotationValueVisitor
     * •javax.lang.model.element.Element和ElementVisitor
     * •javax.lang.model.type.TypeMirror和TypeVisitor
     */
    @Test
    public void testAction() throws InterruptedException, IOException
    {
        /**
         * 职责链模式(Chain of Responsibility)
         */
        String name = Logger.getGlobal().getName();
        System.out.println(name);

        /**
         * 命令模式(Command)
         */
        System.out.println(Action.NAME);
        /**
         * 解释器模式(Interpreter)
         */
        String reg = "\\d{1,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("12312312");
        System.out.println(matcher.find());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);

        /**
         * 迭代器模式(Iterator)
         */
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4, 32, 32, 423, 4323, 323});

        Iterator iterator = ints.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + "\t");
        }

        System.out.println("\n***********************************************");
        /**
         * 中介者模式(Mediator)
         */
        new Timer().schedule(new TimerTask()
        {

            @Override
            public void run()
            {
                System.out.println("delay1000");
            }
            //如果延时1000毫秒的话，线程要在最后有个等待，否则线程执行完后就停止了，就不会打印run里的delay1000
        }, 1);

        Thread.sleep(1000);

        /**
         * 备忘录模式(Memento)
         */
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.compareTo(DateUtil.parseDate("2018年12月31日 00:00:00")));

        /**
         * 状态模式(State)
         */
        List<String> strings = Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F"});

        Iterator<String> iterator1 = strings.iterator();

        while (iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }


        /**
         * 策略模式(Strategy)
         */
        List<Person> people = Arrays.asList(new Person("Google", 99), new Person("Amazon", 109), new Person("Facebook",
                18),new Person("ZKY",28));

        System.out.println(people);
        Collections.sort(people);
        System.out.println(people);
        Collections.sort(people, new Comparator<Person>()
        {
            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.getAge() < o2.getAge() ? -1 : o1.getAge() == o2.getAge() ? 0 : 1;
            }
        });

        System.out.println(people);

        /**
         * 模板方法模式(Template Method)
         */
        FileReader reader =new FileReader(new File("D:\\document\\temp.txt"));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String readline = null;
        while ((readline= bufferedReader.readLine()) != null)
        {
            System.out.print(readline);
        }

        /**
         * 访问者模式(Visitor)
         */

        Element element= new Element()
        {
            @Override
            public TypeMirror asType()
            {
                return null;
            }

            @Override
            public ElementKind getKind()
            {
                return null;
            }

            @Override
            public Set<Modifier> getModifiers()
            {
                return null;
            }

            @Override
            public Name getSimpleName()
            {
                return null;
            }

            @Override
            public Element getEnclosingElement()
            {
                return null;
            }

            @Override
            public List<? extends Element> getEnclosedElements()
            {
                return null;
            }

            @Override
            public List<? extends AnnotationMirror> getAnnotationMirrors()
            {
                return null;
            }

            @Override
            public <A extends Annotation> A getAnnotation(Class<A> annotationType)
            {
                return null;
            }

            @Override
            public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType)
            {
                return null;
            }

            @Override
            public <R, P> R accept(ElementVisitor<R, P> v, P p)
            {
                return null;
            }


        };

        ElementKind kind = element.getKind();


        System.out.println("1");

        System.out.println(kind);
    }
}
