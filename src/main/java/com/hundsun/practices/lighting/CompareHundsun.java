package com.hundsun.practices.lighting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入第一行有三个空格分割证书组成，numloc,airportLocx和airportLocy分别表示繁忙地点总数（N)和机场的X坐标和Y坐标。接下来的N行中，
 * 每行有两个空格分割的整数组成，即locx和locy，分别表示每个繁忙地点的x坐标和y坐标。
 * 输出
 * 打印一个整数，表示最优路线可以覆盖繁忙地点的数量（这个数量不包括机场）
 * 示例：
 * 6 0 0
 * 2 2
 * 3 3
 * -4 -8
 * 8 8
 * -1 -1
 * 5 8
 * 输出
 * 4
 **/
public class CompareHundsun
{


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String[] s2 = number.split(" ");
        BigDecimal x0 = new BigDecimal(s2[1]);
        BigDecimal y0 = new BigDecimal(s2[2]);
        List<TempParm> array = new ArrayList<>();
        for (int j = 0; j < Integer.valueOf(s2[0]); j++)
        {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            TempParm tempParm = new TempParm(new BigDecimal(s1[0]), new BigDecimal(s1[1]));
            array.add(tempParm);
        }

        Map<String, Integer> hashMap = new HashMap<>();
        for (TempParm tempParm : array)
        {
            BigDecimal x = tempParm.getX();
            BigDecimal y = tempParm.getY();
            BigDecimal subtract = x.subtract(x0);
            BigDecimal subtract1 = y.subtract(y0);
            if (BigDecimal.ZERO.compareTo(subtract1) == 0)
            {
                if (null != hashMap.get("X"))
                {
                    hashMap.put("X", hashMap.get("X") + 1);
                }
                else
                {
                    hashMap.put("X", 1);
                }
            }
            else
            {
                BigDecimal divide = ((subtract).divide(subtract1, 2, BigDecimal.ROUND_HALF_UP));
                if (null != hashMap.get(String.valueOf(divide)))
                {
                    hashMap.put(String.valueOf(divide), hashMap.get(String.valueOf(divide)) + 1);
                }
                else
                {
                    hashMap.put(String.valueOf(divide), 1);
                }
            }

        }
        Object[] objects = hashMap.values().stream().sorted().toArray();
        System.out.println(objects[objects.length - 1]);
    }
}

class TempParm
{
    private BigDecimal x;
    private BigDecimal y;

    public TempParm(BigDecimal x, BigDecimal y)
    {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX()
    {
        return x;
    }

    public BigDecimal getY()
    {
        return y;
    }

}
