package com.hundsun.elearning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: mypractices
 * @Package: com.hundsun.elearning
 * @ClassName: ConstNumber
 * @Author: hspcadmin
 * @Description:
 * @Date: 2022-05-24 23:34
 * @Version: 1.0
 */
public class ConstNumber
{
    public static void main(String[] args)
    {
        Integer[] arr = {11, 164, 25, 34, 9, 32, 8, 11, 25, 7, 9, 25, 4, 25, 3, 19, 65, 8, 9, 85, 9, 7, 25, 9, 12, 63};
        Map.Entry<Integer, Integer> integerIntegerEntry = getIntegerIntegerEntry(arr);
        System.out.println(integerIntegerEntry);
        Integer[] newArray = getNewArray(arr);
        Map.Entry<Integer, Integer> integerIntegerEntry1 = getIntegerIntegerEntry(newArray);
        System.out.println(integerIntegerEntry1);

    }

    /**
     * 获取数组中出现次数最多的数值，如果出现次数相同，输出数值较大的一个。
     *
     * @param arr
     * @return
     */
    private static Map.Entry<Integer, Integer> getIntegerIntegerEntry(Integer[] arr)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer i : arr)
        {
            hashSet.add(i);
        }
        for (Integer integer : hashSet)
        {
            int j = 1;
            hashMap.put(integer, j);
            for (int i = 0; i < arr.length; i++)
            {
                if (integer == arr[i])
                {
                    hashMap.put(integer, j++);
                }
            }
        }
        System.out.println(hashMap);

        Map.Entry<Integer, Integer> integerIntegerEntry = hashMap.entrySet()
                                                                 .stream()
                                                                 .filter(e -> e.getValue() == hashMap.values()
                                                                                                     .stream()
                                                                                                     .max(Integer::compareTo)
                                                                                                     .get())
                                                                 .max(Comparator.comparing(Map.Entry::getKey))
                                                                 .get();
        return integerIntegerEntry;
    }

    /**
     * 获取一个新的数组（把所有的数都拆成纯数字,例如：123=>1,2,3）
     *
     * @param arr
     * @return
     */
    private static Integer[] getNewArray(Integer[] arr)
    {
        List<Integer> arrayList = new ArrayList<>();
        for (Integer integer : arr)
        {
            while (integer >= 10)
            {
                int temp = integer % 10;
                arrayList.add(temp);
                integer /= 10;
            }
            if (integer < 10)
            {
                arrayList.add(integer);
            }
        }

        Integer[] resultArr = new Integer[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
        {
            resultArr[i] = arrayList.get(i);
            System.out.println("数组："+resultArr[i]);
        }
        return resultArr;
    }
}
