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
 * Time: 15:00
 * Description:
 * <p>
 * 直接缓冲区的实际应用(给定一个直接字节缓冲区，
 * Java 虚拟机将尽最大努力直接对它执行本机 I/O 操作。也就是说，
 * 它会在每一次调用底层操作系统的本机 I/O 操作之前(或之后)，
 * 尝试避免将缓冲区的内容拷贝到一个中间缓冲区中
 * (或者从一个中间缓冲区中拷贝数据)。)
 */
public class FastCopyFile
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
            FileInputStream fin = new FileInputStream(infile);

            FileOutputStream fout = new FileOutputStream(outfile);


            FileChannel fcin = fin.getChannel();
            FileChannel fcout = fout.getChannel();


            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2048);


            while (true)
            {
                byteBuffer.clear();

                int r = fcin.read(byteBuffer);

                if (r == -1)
                {
                    break;
                }

                byteBuffer.flip();

                fcout.write(byteBuffer);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
