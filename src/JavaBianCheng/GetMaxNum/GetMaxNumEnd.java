package JavaBianCheng.GetMaxNum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-31
 * Time: 10:45
 * Description:
 * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。
 * 例如，给定[50，2，1,9]，最大数字为95021。
 */
public class GetMaxNumEnd
{

    /**
     * This algorithm offers guaranteed n*log(n) performance.
     *
     * @param array
     * @return
     */
    public static String getLargestNumByArranged(Integer[] array) {
        Arrays.sort(array, new Comparator<Object>() {
            /***
             * 默认是从小到大排序 if the result > 0 then swap
             */
            public int compare(Object o1, Object o2) {
                String left = o1.toString();
                String right = o2.toString();
                // 按字典顺序比较 if the result > 0 then * -1
                return (left + right).compareTo(right + left) * -1;
                // return (right + left).compareTo(left + right);
            }

        });

        StringBuffer sb = new StringBuffer();
        for (Integer integer : array) {
            sb.append(integer.toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] VALUES = { 1,2,3,21 };
        System.out.println(getLargestNumByArranged(VALUES));
    }

}
