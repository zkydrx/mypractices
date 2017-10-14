package fromeFaceBook.JavaProgramming.ArraysSort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-10
 * Time: 01:55
 * Description:
 * Arrays sort method test.
 */
public class ProgrammingLanguages
{
    public static void main(String[] args)
    {
        String [] lang = new String [5];
        lang[0] = "Java";
        lang[1] = "C++";
        lang[2] = "Ruby";
        lang[3] = "Perl";
        lang[4] = "Python";
        Arrays.sort(lang);
        for (int i = 0; i < lang.length; i++)
        {
            if( i ==2 || i==4)
            {
                System.out.print(lang[i]);
            }
        }
    }
}
