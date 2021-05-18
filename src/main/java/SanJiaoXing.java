/**
 * Created by ZKY on 2017-05-25 1:31 PM.
 */
public class SanJiaoXing
{
    public int triangleCount(int S[])
    {
        // write your code here
        int count = 0;
        for (int i = 0; i < S.length; i++)
        {
            for (int j = 0; j < S.length; j++)
            {
                for (int k = 0; k < S.length; k++)
                {
                    if (i != k && i != j && k != j)
                    {
                        if (S[i] + S[j] > S[k])
                        {
                            if (S[j] + S[k] > S[i])
                            {
                                if (S[k] + S[i] > S[j])
                                {
                                    count++;
                                }
                                else
                                {
                                    continue;
                                }
                            }
                            else
                            {
                                continue;
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        SanJiaoXing sanJiaoXing = new SanJiaoXing();
        int i = sanJiaoXing.triangleCount(new int[]{3, 4, 6, 7,});
        System.out.println(i);
    }
}
