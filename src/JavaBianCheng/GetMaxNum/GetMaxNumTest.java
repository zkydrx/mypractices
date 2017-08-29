package JavaBianCheng.GetMaxNum;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 01:48
 * Description:
 */
class GetMaxNumTest
{
    @Test
    public void combination1()
    {
        /**
         * 全组合：
         */
        String arr[] = {"a", "b", "c"};
        int all = arr.length;
        int nbit = 1 << all;
        for (int i = 0; i < nbit; i++)
        {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < all; j++)
            {
                if ((i & (1 << j)) != 0)
                {
                    sb.append(arr[j]);
                }
            }
            System.out.println(sb);
        }
    }
}