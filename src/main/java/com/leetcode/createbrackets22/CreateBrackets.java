package com.leetcode.createbrackets22;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-05-19
 * Time: 21:13:18
 * Description:
 * //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：n = 3
 * //输出：[
 * //       "((()))",
 * //       "(()())",
 * //       "(())()",
 * //       "()(())",
 * //       "()()()"
 * //     ]
 * //
 * // Related Topics 字符串 回溯算法
 */
@Slf4j
public class CreateBrackets
{

    public List<String> generateParenthesis(int n)
    {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res, String ans, int count1, int count2, int n)
    {

        if (count1 > n || count2 > n)
        {
            return;
        }

        if (count1 == n && count2 == n)
        {
            res.add(ans);
        }


        if (count1 >= count2)
        {
            String ans1 = ans;
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans1 + ")", count1, count2 + 1, n);
        }
    }

    @Test
    public void createBracketsTest()
    {
        List<String> strings = generateParenthesis(4);

        log.info("strings:{}", JSON.toJSON(strings));
    }
}
