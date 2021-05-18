package NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-14
 * Time: 10:26
 * Description:
 * 读取文件和写入文件
 */
public class FileReadAndWrite
{
    static private final byte message[] = {83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46};

    public static void main(String[] args)
    {
        /**
         * 读取文件
         */
        try
        {
            /**
             * 第一步是获取通道。我们从 FileInputStream 获取通道：
             */
            FileInputStream fileInputStream = new FileInputStream("README.md");
            FileChannel fileChannel = fileInputStream.getChannel();

            /**
             * 第二步创建缓冲区
             */

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            /**
             * 第三步将数据从通道读到缓冲区中。
             */
            fileChannel.read(buffer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /**
         * 写入文集
         */
        try
        {
            /**
             * 第一步：从输出流中获取通道
             */
            FileOutputStream fileOutputStream = new FileOutputStream("README.md");
            FileChannel fileChannel = fileOutputStream.getChannel();


            /**
             * 第二步：创建缓冲区
             */
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


            for (int i = 0; i < message.length; i++)
            {
                byteBuffer.put(message[i]);
            }

            byteBuffer.flip();

            /**
             * 第三步：写入缓冲区
             */
            try
            {
                fileChannel.write(byteBuffer);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


}
