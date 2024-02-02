package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses ipAddresses = new RestoreIPAddresses();
        ipAddresses.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(new LinkedList<>(), 0, 1, s);
        return null;
    }
    public void dfs(LinkedList<Integer> path, int start, int level, String s) {
        if (level == 4) {
            Integer substring = Integer.valueOf(s.substring(start));
            if (substring >= 0 && substring <= 255) {
                path.add(substring);
                System.out.println(new Gson().toJson(path));
                path.removeLast();
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            Integer substring = Integer.valueOf(s.substring(start, start+i));
            if (substring >= 0 && substring <= 255) {
                path.add(substring);
                dfs(path, start+i, level+1, s);
                path.removeLast();
            }
        }
    }

}
