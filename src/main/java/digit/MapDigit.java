package digit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZKY on 2017-06-15 09:54.
 * Given a digit string excluded 01, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Cellphone

 注意事项

 以上的答案是按照词典编撰顺序进行输出的，不过，在做本题时，你也可以任意选择你喜欢的输出顺序。
 本题是说出了01以外的2,3,4,5,6,7,8,9随意输入一个数字返回这几个数字对应的字母的所有组合数组。
 2：abc
 3:def
 4:ghi
 5:jkl
 6:mno
 7:pqrs
 8:tuv
 9:wxyz


 样例
 给定 "23"

 返回 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class MapDigit
{
    public ArrayList<String> letterCombinations(String digits)
    {
        // Write your code here
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        for(int i = 0; i < digits.length(); i++)
        {
            for(int j = 0; j < map.size(); j++)
            {
                if((digits.charAt(i)+"").equals(j+2+""))
                {

                }
            }
        }
        return null;
    }


}
