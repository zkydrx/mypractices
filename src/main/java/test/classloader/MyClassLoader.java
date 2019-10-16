package test.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-10-16
 * Time: 23:47:59
 * Description:
 */
public class MyClassLoader extends ClassLoader
{
    public String name;
    public String path;
    public final String fileType = ".class";

    public MyClassLoader(String name)
    {
        super();
        this.name = name;
    }

    public static void main(String[] args)
    {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);
        while (null != classLoader)
        {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

    }

    @Override
    public Class<?> findClass(String name)
    {
        byte[] bytes = loadClassData(name);
        Class<?> aClass = defineClass(name, bytes, 0, bytes.length);
        return aClass;
    }

    private byte[] loadClassData(String name)
    {
        InputStream is = null;
        ByteArrayOutputStream os = null;
        byte[] bytes = null;
        try
        {
            is = new FileInputStream(new File(path + name + fileType));
            os = new ByteArrayOutputStream();
            int ch = 0;
            while (0 != (ch = is.read()))
            {
                os.write(ch);
            }
            bytes = os.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
                os.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
