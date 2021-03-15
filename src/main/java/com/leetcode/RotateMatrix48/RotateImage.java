package com.leetcode.RotateMatrix48;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-25
 * Time: 16:47:47
 * Description:
 * 48. Rotate Image
 * Medium
 * <p>
 * 4365
 * <p>
 * 319
 * <p>
 * Add to List
 * <p>
 * Share
 * You are given an n x n 2D matrix representing an image,
 * rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * example1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Example 3:
 * Input: matrix = [[1]]
 * Output: [[1]]
 */
public class RotateImage
{
    public int[][] rotate(int[][] matrix)
    {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c)
        {
            change(matrix, a++, b++, c--, d--);
        }
        return matrix;
    }

    private void change(int[][] matrix, int a, int b, int c, int d)
    {
        int temp = 0;
        for (int j = 0; j < d - a; j++)
        {
            /**
             * 思路，把数据按圈划分到最内圈。然后找每一个圈中数字的特点，分为几组数据，然后再找到每一个数字的抽象化表达。
             * 然后用一个临时变量把每个数字按照规则替换就可以。
             */
            temp = matrix[a][b + j];
            matrix[a][b + j] = matrix[c - j][b];
            matrix[c - j][b] = matrix[c][d - j];
            matrix[c][d - j] = matrix[a + j][d];
            matrix[a + j][d] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage rotateImage = new RotateImage();
        int[][] rotate = rotateImage.rotate(m);
        Arrays.stream(rotate).forEach(c -> System.out.println(Arrays.toString(c)));
    }
}
