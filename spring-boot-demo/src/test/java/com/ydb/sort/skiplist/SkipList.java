package com.ydb.sort.skiplist;

import java.util.Random;

/**
 * 参考 https://www.jianshu.com/p/60d2561b821c
 * @Author ligeng
 * @Date 19/6/15
 * @Time 下午8:10
 */
public class SkipList<T> {
    public SkipList() {
        random=new Random();
    }



    /**
     * 查找是否存储key，存在则返回该节点，否则返回null
     * */
    public SkipListNode<T> search(int key){
        SkipListNode<T> p=findNode(key);
        if (key==p.getKey()) {
            return p;
        }else {
            return null;
        }
    }

    /**
     * 在最下面一层，找到要插入的位置前面的那个key
     *
     */
    private SkipListNode<T> findNode(int key) {
        SkipListNode<T> p = head;
        while (true) {
            while (p.right.key != tail.key && p.right.key < key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                return p;
            }
        }
    }




    private SkipListNode<T> head,tail;
    private int nodes;//节点总数
    private int listLevel;//层数
    private Random random;// 用于投掷硬币
    private static final double PROBABILITY=0.5;//向上提升一个的概率
}
