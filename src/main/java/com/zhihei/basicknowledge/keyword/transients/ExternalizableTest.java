// package com.zhihei.basicknowledge.keyword.transients;
//
// /**
//  * Created with IntelliJ IDEA.
//  * Author: zky
//  * Date: 2019-11-23
//  * Time: 10:52:26
//  * Description:
//  */
//
// import java.io.Externalizable;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInput;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutput;
// import java.io.ObjectOutputStream;
//
// /**
//  * 3. transient使用细节——被transient关键字修饰的变量真的不能被序列化吗？
//  *
//  */
// public class ExternalizableTest implements Externalizable
// {
//     private transient String content = "Apple is very good!";
//
//     @Override
//     public void writeExternal(ObjectOutput out) throws IOException
//     {
//         out.writeObject(content);
//     }
//
//     @Override
//     public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
//     {
//         content =(String) in.readObject();
//     }
//
//     public static void main(String[] args)
//     {
//         ExternalizableTest externalizableTest = new ExternalizableTest();
//         try
//         {
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("test")));
//             objectOutputStream.writeObject(externalizableTest);
//             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("test")));
//             externalizableTest = (ExternalizableTest) objectInputStream.readObject();
//             System.out.println(externalizableTest.content);
//             objectOutputStream.close();
//             objectInputStream.close();
//
//         }
//         catch (IOException | ClassNotFoundException e)
//         {
//             e.printStackTrace();
//         }
//     }
// }
