package NIO.FileIo;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-14
 * Time: 13:31
 * Description:
 */
public class FileCopy
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream(new File("src/main/java/NIO/FileIo/x.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/java/NIO/FileIo/y.txt"));

            byte [] b = new byte[2048];
            while (fileInputStream.read(b) != -1)
            {
                fileOutputStream.write(b,0,b.length);
                fileOutputStream.flush();
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
