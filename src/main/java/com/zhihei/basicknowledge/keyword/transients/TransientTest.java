package com.zhihei.basicknowledge.keyword.transients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-23
 * Time: 09:45:05
 * Description:
 * transient的作用及使用方法
 * 我们都知道一个对象只要实现了Serilizable接口，这个对象就可以被序列化，
 * java的这种序列化模式为开发者提供了很多便利，我们可以不必关系具体序列化的过程，
 * 只要这个类实现了Serilizable接口，这个类的所有属性和方法都会自动序列化。
 * 然而在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化，
 * 而其他属性不需要被序列化，打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），
 * ，不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）中被传输，
 * 这些信息对应的变量就可以加上transient
 * 关键字。换句话说，这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
 * 总之，java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，
 * 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会
 * 序列化到指定的目的地中。
 * <p>
 * <p>
 * 2. transient使用小结
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * <p>
 * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
 * 变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * <p>
 * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 */
public class TransientTest
{
    @Test
    public void testTransient()
    {
        User user = new User("zkyroot");

        user.setUserName("zky");
        System.out.println("Read before Serializable");
        System.out.println("userName:" + user.getUserName());
        System.out.println("password:" + user.getPassword());


        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        try
        {
            /**
             * 这说明反序列化后类中static型变量username的值为当前JVM中对应static变量的值，
             * 为修改后abc，而不是序列化时的值zky。
             *
             * Read before Serializable
             * userName:zky
             * password:zkyroot
             * Read after serializable:
             * userName:abc
             * password:null
             */

            user.setUserName("abc");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/user.txt"));
            User user1 = (User) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Read after serializable:");
            System.out.println("userName:" + user1.getUserName());
            System.out.println("password:" + user1.getPassword());
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testExternalizable()
    {
        ExternalizableTest externalizableTest = new ExternalizableTest();
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("test")));
            objectOutputStream.writeObject(externalizableTest);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("test")));
            externalizableTest = (ExternalizableTest) objectInputStream.readObject();
            System.out.println(externalizableTest.getContent());
            objectOutputStream.close();
            objectInputStream.close();

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User implements Serializable
{

    private static final long serialVersionUID = -6857547353614022556L;

    @Setter
    @Getter
    private static String userName;
    private transient String password;

}

/**
 * 3. transient使用细节——被transient关键字修饰的变量真的不能被序列化吗？
 * <p>
 * 我们知道在Java中，对象的序列化可以通过实现两种接口来实现，
 * 若实现的是Serializable接口，则所有的序列化将会自动进行，
 * 若实现的是Externalizable接口，则没有任何东西可以自动序列化，
 * 需要在writeExternal方法中进行手工指定所要序列化的变量，
 * 这与是否被transient修饰无关。因此第二个例子输出的是变量content初始化的内容，而不是null。
 * <p>
 * <p>
 * content变量会被序列化吗？好吧，我把答案都输出来了，是的，运行结果就是：
 * Apple is very good!
 * 这是为什么呢，不是说类的变量被transient关键字修饰以后将不能序列化了吗？
 */
class ExternalizableTest implements Externalizable
{

    public ExternalizableTest()
    {
    }

    @Getter
    private transient String content = "Apple is very good!";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        content = (String) in.readObject();
    }
}