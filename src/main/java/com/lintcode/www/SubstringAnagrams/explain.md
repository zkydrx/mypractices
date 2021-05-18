问题：

Given a string s and a non-empty string p, find all the start indices of p’s anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
20,100.

The order of output does not matter.

Example 1:

Input:
s: “cbaebabacd” p: “abc”

Output:
[0, 6]

Explanation:
The substring with start index = 0 is “cba”, which is an anagram of “abc”. The substring with start index = 6 is “bac”,
which is an anagram of “abc”. Example 2:

Input:
s: “abab” p: “ab”

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is “ab”, which is an anagram of “ab”. The substring with start index = 1 is “ba”,
which is an anagram of “ab”. The substring with start index = 2 is “ab”, which is an anagram of “ab”. 大意：

给出一个字符串s和一个非空的字符串p，找到p的重组字在s中出现的开始位置。

字符串全部由小写字母组成，s和p的长度都不超过20100。

输出的顺序无所谓。

例1:

输入:
s: “cbaebabacd” p: “abc”

输出:
[0, 6]

解释:
“abc”的重组字“cba”可以从0开始找到。 “abc”的重组字“bac”可以从6开始找到。 例2:

输入:
s: “abab” p: “ab”

输出:
[0, 1, 2]

解释:
“ab”的重组字“ab”可以从0开始找到。 “ab”的重组字“ba”可以从1开始找到。 “ab”的重组字“ab”可以从2开始找到。 思路：

这道题的意思就是给两个字符串，看p的顺序打乱后的所有可能的字符串在s中能不能找到，找得到就把所有找到的开始的位置记录下来。这个大概的思路要用到两个标记，去一点点比对p的重组字有没有可能找到，找不找得到这一点，不可能把p的所有可能的重组字先列出来，就只能一个字母一个字母地判断，如果用过了就去掉，看是全部字母都能找到还是只能找到部分。注意题目说了只有小写字母，而且p的长度不为空。我自己的做法在超长的测试用例时超时了，用的循环太多了。这里看别人非常精简巧妙的一个方法。

他山之石：

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) count--; 
    
            if (count == 0) list.add(left);
    
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

这个代码非常精简，频繁地用到了后置++和–，这里要注意的是后置的计算是会先做玩判断后再进行加和减的，还有就是&&这个判断符，只有当前面的条件判断成功了才会去进行后面的判断，也就是说如果前面的不成立，后面的判断根本不会执行，这里也巧妙地利用了这个特性。这个代码可能过于精简了，来看一下稍微复杂化一点的同样的代码。

    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    
        int[] hash = new int[256]; 
    
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
    
        int left = 0, right = 0, count = p.length();
    
        while (right < s.length()) {
    
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;
    
            if (count == 0) {
                list.add(left);
            }
    
            if (right - left == p.length() ) {
    
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
    
            }
    
    
        }
            return list;
        }
    }

这个算法首先是判断为空的情况，然后创建了一个数组用来存储p中的各个字符的数量，这是对于判断有无字母的一个很好的办法，先用每个字母位置的数量来表示各个字母的数量，接下来每次对各个字母的数量进行加减就可以了，这里的数组名hash只是一个数组，不要和哈希算法弄混了。

创建了左右两个标志位，一个用来表示判断字符串的起始位，一个表示终止位，都从0开始，还一个变量表示p的长度。

只要右标志位没有到s的最右边，就进行大循环。

对右标志位记录的s中的字母进行判断，看p中有没有，这里就是用那个表示p中字母数量的数组来进行判断的，找到了，就把表示要判断的字符串长度减一，不管有没有找到，都要把数量数组减少，右标志位右移，这是为了之后进行判断，因为我们要找的的字符串始终处于左和右的标志位的中间。

如果要找的字符串的长度减少到0了，说明我们在左右标志位中间找到了p字符串长度的重组字，这时候就可以把左标志位，也就是开始的位置，添加到结果数组中。

在循环的最后，先判断左右标志位中间是否是p的长度，是的话，我们就该把左标志位也右移了，而右移之前，先要看看左标志位这个数我们是否找到过，找到过则要把count数量补回1，不论有没有找到过，都要讲数组中的对应的字母数量补回1。

整个过程感觉理解的也不是很到位，希望大家指点一下。