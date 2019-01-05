package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/11/11
 * @Time 下午7:26
 */
public class Q78_Subsets {
    public static void main(String[] args) {
        Q78_Subsets subsets = new Q78_Subsets();
        List<List<Integer>> list = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}

//class Solution {
//    public:
//    vector<vector<int> > subsets(vector<int> &S) {
//        sort (S.begin(), S.end());
//        int elem_num = S.size();
//        int subset_num = pow (2, elem_num);
//        vector<vector<int> > subset_set (subset_num, vector<int>());
//        for (int i = 0; i < elem_num; i++)
//            for (int j = 0; j < subset_num; j++)
//                if ((j >> i) & 1)
//                    subset_set[j].push_back (S[i]);
//        return subset_set;
//    }
//};
