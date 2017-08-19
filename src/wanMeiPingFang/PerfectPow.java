package wanMeiPingFang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZKY on 2017-08-20 01:06.
 *
 *
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。
 *样例
 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 给出 n = 13, 返回 2 因为 13 = 4 + 9。
 *
 */
public class PerfectPow
{
    /**
     * 获取某数所有平方数，此数值小于或等于给定的正整数的平方根
     * @param n
     * @return
     */
    public List<Long> getIntegerList(int n)
    {
        List<Long> list = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            list.add((long)Math.pow(i,2));
        }
        return list;
    }




}
