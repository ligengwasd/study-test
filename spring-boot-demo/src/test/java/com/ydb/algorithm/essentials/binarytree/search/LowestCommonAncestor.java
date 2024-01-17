package com.ydb.algorithm.essentials.binarytree.search;

import com.ydb.algorithm.essentials.binarytree.Node;

/**
 * 很简单的思路就是看两个值在root的哪边：
 * 两个值都在左边，则LCA在左边
 * 两个值都在右边，则LCA在右边
 * 一个在左一个在右，则说明LCA就是当前的root节点。
 *
 * 类似题目
 * https://cloud.tencent.com/developer/article/1875014
 */
public class LowestCommonAncestor {

    /**
     * 默认p < q
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        // 如果p>q，交换位置。
        if (p.iData > q.iData) {
            return lowestCommonAncestor(root, q, p);
        }
        if (root.iData < p.iData) {
            return lowestCommonAncestor(root.rightChild, p, q);
        }
        if (root.iData > p.iData) {
            return lowestCommonAncestor(root.leftChild, p, q);
        }
        if (root.iData > p.iData && root.iData < q.iData) {
            return root;
        }
        return null;
    }
}
