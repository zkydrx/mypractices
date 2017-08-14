package array;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Created by ZKY on 2017-06-16 09:19.
 */
public class SanWeiShuZu
{
    public void myArray() throws FileNotFoundException
    {
        int [][][] a = new int[100][100][100];
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                for(int k= 0; k<a[i][j].length;k++)
                {
                    a[i][j][k] = i*j*k;
                }
            }
        }
        FileWriter fileWriter = null;
        try
        {
           fileWriter = new FileWriter("D:\\file\\mytest\\a.txt");
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                for(int k= 0; k<a[i][j].length;k++)
                {
                    System.out.print("a["+i+"]["+j+"]["+k+"]="+a[i][j][k]);
                    fileWriter.write("a["+i+"]["+j+"]["+k+"]="+a[i][j][k]+"\t");
                    fileWriter.flush();
                }
                System.out.println("****************************************************************");
            }
            System.out.println("#################################################################");
        }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testArray() throws FileNotFoundException
    {
        myArray();
    }
}
