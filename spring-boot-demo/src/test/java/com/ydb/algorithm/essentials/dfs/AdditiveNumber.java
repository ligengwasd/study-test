package com.ydb.algorithm.essentials.dfs;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        for (int i=1; i<num.length()/2; i++) {
            for (int j=i+1; j<num.length(); j++) {
                if (dfs(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(String num, int i, int j, int k) {
        long num1 = Long.parseLong(num.substring(i, j));
        long num2 = Long.parseLong(num.substring(j, k));
        String addition = String.valueOf(num1 + num2);

        if (!num.substring(k).startsWith(addition)) {
            return false;
        }
        if (num.substring(k).equals(addition)) {
            return true;
        }
        return dfs(num, j, k, k+addition.length());
    }
}
