package digitAddTogither;

/**
 * Created by ZKY on 2017-08-15 01:00.
 * 给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
 * 样例
 * 给出 num = 38。
 * 相加的过程如下：3 + 8 = 11，
 * 1 + 1 = 2。
 * 因为 2 只剩下一个数字，所以返回 2。
 */
public class DoMain
{
    /**
     * Get a number's all digit's sum.
     * @param num
     * @return
     */
    public int geSum(int num)
    {
        int sum = 0;
        while(num >0)
        {
            int temp = num %10;
            num /= 10;
            sum+=temp;
        }
         return sum;
    }

    /**
     * 获取一个数的各位和，并判断和是否满足个位数，满足就返回结果。否者继续。
     * @param num
     * @return
     */
    public int getAdigit(int num)
    {
        while(num >=10)
        {
            num = geSum(num);
        }
         return num;
    }



    public static void main(String[] args)
    {
        DoMain doMain = new DoMain();
        int adigit = doMain.getAdigit(38);
        System.out.println(doMain.getAdigit(45));
        System.out.println(doMain.getAdigit(23));
        System.out.println(doMain.getAdigit(69));
        System.out.println(doMain.getAdigit(123));
        System.out.println(doMain.getAdigit(6623));
    }
}
