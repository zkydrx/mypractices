package NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-14
 * Time: 10:56
 * Description:
 * copy 的小例子
 */
public class CopyFile
{
    public static void main(String[] args) throws IOException
    {

        //        if (args.length < 2)
        //        {
        //            System.err.println("Usage: java FastCopyFile infile outfile");
        //            System.exit(1);
        //        }
        //
        //        String infile = args[0];
        //        String outfile = args[1];
        String infile = "src/main/java/NIO/README.md";
        String outfile = "src/main/java/NIO/Test.txt";
        try
        {
            /**
             * 从流中获取通道
             */
            FileInputStream fileInputStream = new FileInputStream(infile);
            FileOutputStream fileOutputStream = new FileOutputStream(outfile);

            FileChannel fcin = fileInputStream.getChannel();
            FileChannel fcout = fileOutputStream.getChannel();
            /**
             *创建缓冲区
             */
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (true)
            {
                /**
                 * 读入之前要清空
                 */
                byteBuffer.clear();

                // position 自动前进
                int r = fcin.read(byteBuffer);
                if (r == -1)
                {
                    break;
                }
                // position = 0; limit=读到的字节数
                byteBuffer.flip();

                // 从buffer中读
                fcout.write(byteBuffer);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
