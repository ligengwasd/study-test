package com.ydb.algorithm.essentials.dfs;

import com.google.gson.Gson;

import java.util.*;

/**
 * @Author ligeng
 * @Date 19/8/19
 * @Time 下午5:49
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
//        solution.dfs(new int[]{10,1,2,7,6,1,5}, 8, new LinkedList<>());
//        solution.dfs(new int[]{2,3,6,7}, 7, new LinkedList<>(), 0);
    }

    public void dfs(int[] choose, int target, LinkedList<Integer> path, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            System.out.println(new Gson().toJson(path));
            return;
        }
        for (int i = start; i < choose.length; i++) {
            path.add(choose[i]);
            dfs(choose, target-choose[i], path, i);
            path.removeLast();
        }
    }
}
