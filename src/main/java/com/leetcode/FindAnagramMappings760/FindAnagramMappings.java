package com.leetcode.FindAnagramMappings760;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-12
 * Time: 16:03
 * Description:
 * <p>
 * 760. Find Anagram Mappings
 * <p>
 * <p>
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of
 * the elements in A.
 * <p>
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at
 * index j.
 * <p>
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * <p>
 * For example, given
 * <p>
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at
 * B[4], and so on.
 * Note:
 * <p>
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 */
public class FindAnagramMappings
{
    public static void main(String[] args)
    {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] ints = new FindAnagramMappings().anagramMappings(A, B);

        System.out.println(Arrays.toString(ints));
    }

    public int[] anagramMappings(int[] A, int[] B)
    {
        int[] c = new int[A.length];

        for (int i = 0; i < A.length; i++)
        {
            for (int i1 = 0; i1 < B.length; i1++)
            {
                if (A[i] == B[i1])
                {
                    c[i] = i1;
                }
            }
        }

        return c;
    }
}
