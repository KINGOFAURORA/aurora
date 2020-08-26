package com.aurora.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Question54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> newMatrix = Lists.newArrayList();

        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                newMatrix.add(matrix[i][j]);
            }
            for (int k = i; k < matrix.length - 1 - i; k++) {
                newMatrix.add(matrix[k][matrix.length - 1 - i]);
            }
            for (int m = matrix[i].length - 1 - i; m > i; m--) {
                newMatrix.add(matrix[matrix.length - 1 - i][m]);
            }
            for (int n = matrix.length - 1 - i; n > i; n--) {
                newMatrix.add(matrix[n][i]);
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> newMatrix = spiralOrder(matrix);
        for (Integer i : newMatrix) {
            System.out.println(i);
        }
    }
}
