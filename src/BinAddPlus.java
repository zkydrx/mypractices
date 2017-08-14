import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZKY on 2017-05-25 11:17 AM.
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 *
 * 样例
 * a = 11
 * b = 1
 * 返回 100
 */
public class BinAddPlus
{
    /**
     * 得到两个二进制字符串的和（结果仍然用二进制表示)
     * @param a
     * @param b
     * @return
     */
    public String addPlus(String a, String b)
    {
       long temp1 = changeLong(a);
       long temp2 = changeLong(b);
       long temp3 = temp1 + temp2;
       String s = changeBin(temp3);
       return s;
    }

    /**
     * 把一个二进制的字符串变成一个十进制的long型的数字。
     * @param a
     * @return
     */
    public static long changeLong(String a)
    {
        if(a =="0")
        {
            return 0L;
        }
        long sum = 0L;
        long l = Long.parseLong(a);
        List<Long> list = new ArrayList<>();
        int count = 0;
        while( l > 0)
        {
            long temp = l % 10;
            list.add(temp);
            l /= 10;
            count++;
        }

        for(int i = count-1; i >= 0; i--)
        {
            double pow = Math.pow(2, i);
            sum += list.get(i) * Math.pow(2,i);
        }
        return sum;
    }

    /**
     * 将一个十进制的数字变成二进制的字符串。
     * @param a
     * @return
     */
    public String changeBin(long a)
    {
        if(a == 0L)
        {
            return "0";
        }
        List<Long> list = new ArrayList<>();
        int count = 0;
        while(a > 0)
        {
            long temp = a % 2;
            list.add(temp);
            count++;
            a /= 2;
        }
        StringBuffer sbf = new StringBuffer();
        for(int i = list.size()-1; i >= 0; i--)
        {
            sbf.append(list.get(i));
        }
        return sbf.toString();
    }
    @Test
    public void testChangeLong()
    {
        BinAddPlus binAddPlus = new BinAddPlus();
        /**
         * 测试用
         */
        long l = binAddPlus.changeLong("1111");

        System.out.println(l);

        /**
         * 测试用
         */
        System.out.println(binAddPlus.changeBin(15));
        String s = binAddPlus.addPlus("11", "1");
        /**
         * 这个是极限条件。
         */
        String s1 = binAddPlus.addPlus("0", "0");
        System.out.println(s);
        System.out.println(s1);
    }


}
