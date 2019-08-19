package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 19/8/17
 * @Time 下午9:22
 */
public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString demo = new InterleavingString();
        System.out.println(demo.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
//
//    public boolean isInterleave2(String s1, String s2, String s3) {
//        char[] a1 = s1.toCharArray();
//        char[] a2 = s2.toCharArray();
//        char[] a3 = s3.toCharArray();
//        int i=0,j=0;
//        for (int k=0; k< a3.length; k++){
//            if (i<a1.length && a3[k] == a1[i]){
//                i++;
//                continue;
//            }
//            if (j<a2.length && a3[k] == a2[j]){
//                j++;
//                continue;
//            }
//            return false;
//        }
//        return true;
//
//    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length()+s2.length())!=s3.length()) return false;

        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }

        return matrix[s2.length()][s1.length()];


    }
}
