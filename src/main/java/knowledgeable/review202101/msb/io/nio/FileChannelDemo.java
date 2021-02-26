package knowledgeable.review202101.msb.io.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-25
 * Time: 09:51:26
 * Description:
 * <p>
 * 在文件通道中read和write方法都是阻塞的，对于read方法，除非遇到文件结束，
 * 否则会把缓冲区的剩余空间读满再返回。对于write方法，
 * 会一次性把缓冲区中的内容全部写入到文件中才会返回。
 * <p>
 * 下面的代码展示了FileChannel的功能，首先向文本文件中写入utf8格式的中英文混合字符，
 * 然后再读取出来。读写过程中都涉及到编解码问题。
 */
public class FileChannelDemo
{
    public static void main(String[] args)
    {

        /*创建文件，向文件中写入数据*/
        try
        {
            /*如果文件不存在，创建该文件,文件后缀是不是文本文件不重要*/
            File file = new File("E:/noi_utf8.data");
            if (!file.exists())
            {
                file.createNewFile();
            }
            /*根据文件输出流创建与这个文件相关的通道*/
            FileOutputStream fos = new FileOutputStream(file);
            FileChannel fc = fos.getChannel();
            /*创建ByteBuffer对象， position = 0, limit = 64*/
            ByteBuffer bb = ByteBuffer.allocate(64);
            /*向ByteBuffer中放入字符串UTF-8的字节, position = 17, limit = 64*/
            bb.put("Hello,World 123 \n".getBytes("UTF-8"));
            /*flip方法  position = 0, limit = 17*/
            bb.flip();
            /*write方法使得ByteBuffer的position到 limit中的元素写入通道中*/
            fc.write(bb);
            /*clear方法使得position = 0， limit = 64*/
            bb.clear();
            /*下面的代码同理*/
            bb.put("你好，世界 456".getBytes("UTF-8"));
            bb.flip();
            fc.write(bb);
            bb.clear();
            fos.close();
            fc.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        /*从刚才的文件中读取字符序列*/
        try
        {
            /*通过Path对象创建文件通道*/
            Path path = Paths.get("E:/noi_utf8.data");
            FileChannel fc = FileChannel.open(path);
            ByteBuffer bb = ByteBuffer.allocate((int) fc.size() + 1);
            Charset utf8 = Charset.forName("UTF-8");
            /*阻塞模式，读取完成才能返回*/
            fc.read(bb);
            bb.flip();
            CharBuffer cb = utf8.decode(bb);
            System.out.print(cb.toString());
            bb.clear();
            fc.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
