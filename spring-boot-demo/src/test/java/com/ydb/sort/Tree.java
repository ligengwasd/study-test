package com.ydb.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tree {
    public static class TreeNode<T>{
        T data;
        TreeNode<T> left=null;
        TreeNode<T> right=null;

        public TreeNode() {}
        public TreeNode(T data){
            this.data=data;
        }
        public TreeNode(T data, TreeNode left, TreeNode right) {
            super();
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinaryTree<T>{
        /**二叉树的根节点*/
        private TreeNode<T> root;

        public BinaryTree(){}
        public BinaryTree(TreeNode<T> root){
            this.root = root;
        }


        /* public TreeNode<Integer> createBinaryTree(){
             TreeNode<Integer> e = new   TreeNode<Integer>(5);
             TreeNode<Integer> g = new   TreeNode<Integer>(7);
             TreeNode<Integer> h = new   TreeNode<Integer>(8);

             TreeNode<Integer> l = new   TreeNode<Integer>(12);
             TreeNode<Integer> m = new   TreeNode<Integer>(13);
             TreeNode<Integer> n = new   TreeNode<Integer>(14);
             TreeNode<Integer> k = new   TreeNode<Integer>(11, n, null);
             TreeNode<Integer> j = new   TreeNode<Integer>(10, l, m);
             TreeNode<Integer> i = new   TreeNode<Integer>(9, j, k);
             TreeNode<Integer> d = new   TreeNode<Integer>(4, null, g);

             TreeNode<Integer> f = new   TreeNode<Integer>(6, h, i);
             TreeNode<Integer> b = new   TreeNode<Integer>(2, d, e);
             TreeNode<Integer> c = new   TreeNode<Integer>(3, f, null);

             TreeNode<Integer> root = new   TreeNode<Integer>(1, b, c);
             return root;
         }*/
        //递归前序
        public void preOrder(TreeNode<T> root){
            if(root!=null){
                visit(root);
                preOrder(root.left);
                preOrder(root.right);
            }
        }
        /*非递归前序:对于任一结点P：

           1)访问结点P，并将结点P入栈;

           2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;

           3)直到P为NULL并且栈为空，则遍历结束。
           */
        public void nonRecursivePreOrder(TreeNode<T> root){
            Stack<TreeNode<T>> s=new Stack<TreeNode<T>>();
            if(root!=null){
                s.push(root);//先把根节点入栈
                while(!s.isEmpty()){//while栈不为空
                    TreeNode<T> node=s.pop();//弹出栈
                    visit(node);
                    if(node.right!=null) s.push(node.right);//把右节点入栈
                    if(node.left!=null)  s.push(node.left); //把左节点入栈
                }

            }
        }

        //递归中序
        public void inOrder(TreeNode<T> root){
            if(root!=null){

                inOrder(root.left);
                visit(root);
                inOrder(root.right);
            }
        }
        public void nonRecursiveInOrder(TreeNode<T> root){
            Stack<TreeNode<T>> stack=new Stack<>();

            TreeNode<T> curr=root; // 当前节点
            while(curr!=null||!stack.isEmpty()){
                while(curr!=null){
                    // 只要当前节点不为空，就一直寻找最左边的那个节点
                    stack.push(curr);
                    curr=curr.left;
                }
                // 走到这里，说明当前节点为空 当前节点 = 上一个最左节点的左节点
                // 因为是左中右的顺序，所以此时应该访问当前节点的父节点，即上一个最左节点
                curr=stack.pop();
                visit(curr);
                // 访问完了父节点，当前节点指向父节点的右节点。
                // 继续循环，查找右节点的最左节点。
                curr=curr.right;
            }
        }
        //递归后序
        public void postOrder(TreeNode<T> root){
            if(root!=null){
                postOrder(root.left);
                postOrder(root.right);
                visit(root);
            }
        }
        //非递归后序遍历
        public void nonRecursivePostOrder(TreeNode<T> root){
            TreeNode<T> node=root;
            TreeNode<T> preNode=null;//记录之前遍历的右结点
            Stack<TreeNode<T>> stack=new Stack<TreeNode<T>>();
            while(node!=null||!stack.isEmpty()){
                /*左子树一直入栈*/
                while(node!=null){
                    stack.push(node);
                    node=node.left;
                }
                node=stack.peek();//获得栈顶节点但不出栈

                /*如果右结点为空，或者右结点之前遍历过，打印根结点*/
                if(node.right==null||node.right==preNode){
                    visit(node);
                    node=stack.pop();
                    preNode = node;
                    node=null;
                }
                else{
                    node=node.right;
                }

            }

        }
        //层次遍历
        public void levelTraverse(TreeNode<T> root){
            //Queue是一个接口，不能直接实例化，一般使用它的实现类LinkedList当做队列用，
            //Queue的实现类还有LinkedList, PriorityQueue, LinkedBlockingQueue, BlockingQueue, ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue
            Queue<TreeNode<T>> queue=new LinkedList<TreeNode<T>>();
            TreeNode<T> node=root;
            queue.offer(node);//队列用offer添加元素

                /*对每一个节点先出队列再让其左节点和右节点入队列*/
            while(!queue.isEmpty()){
                node=queue.poll();//队列用poll出队列
                if(node!=null){
                    visit(node);
                    //左右节点入队列
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

            }
        }
        //递归求树的高度
        public int treeHeight(TreeNode<T> root){
            if(root==null){
                return 0;
            }
            else{
                int leftTreeHeight=treeHeight(root.left);
                int rightTreeHeight=treeHeight(root.right);
                return leftTreeHeight>rightTreeHeight?leftTreeHeight+1:rightTreeHeight+1;
            }
        }
        //递归求节点总数
        public int treeNodes(TreeNode<T> root){
            if(root==null){
                return 0;
            }
            else{
                int leftTreeNodes=treeNodes(root.left);
                int rightTreeNodes=treeNodes(root.right);
                return leftTreeNodes+rightTreeNodes+1;
            }
        }
        //递归求叶子节点总数
        public int treeLeaf(TreeNode<T> root){
            if(root==null){
                return 0;
            }
            else{
                int leftTreeLeaf=treeLeaf(root.left);
                int rightTreeLeaf=treeLeaf(root.right);
                if(root.left==null&&root.right==null){
                    return leftTreeLeaf+rightTreeLeaf+1;
                }
                else{
                    return leftTreeLeaf+rightTreeLeaf;
                }
            }
        }
        public void visit(TreeNode<T> root) {
            System.out.print(root.data+" ");
        }


    }

    public static void main(String[] args) {
        TreeNode<Integer> e = new   TreeNode<Integer>(5);
        TreeNode<Integer> g = new   TreeNode<Integer>(7);
        TreeNode<Integer> h = new   TreeNode<Integer>(8);

        TreeNode<Integer> l = new   TreeNode<Integer>(12);
        TreeNode<Integer> m = new   TreeNode<Integer>(13);
        TreeNode<Integer> n = new   TreeNode<Integer>(14);
        TreeNode<Integer> k = new   TreeNode<Integer>(11, n, null);
        TreeNode<Integer> j = new   TreeNode<Integer>(10, l, m);
        TreeNode<Integer> i = new   TreeNode<Integer>(9, j, k);
        TreeNode<Integer> d = new   TreeNode<Integer>(4, null, g);

        TreeNode<Integer> f = new   TreeNode<Integer>(6, h, i);
        TreeNode<Integer> b = new   TreeNode<Integer>(2, d, e);
        TreeNode<Integer> c = new   TreeNode<Integer>(3, f, null);

        TreeNode<Integer> root = new   TreeNode<Integer>(1, b, c);

        BinaryTree<Integer> tree=new BinaryTree<Integer>(root);
        System.out.println("递归前序遍历二叉树结果：");
        tree.preOrder(root);
        System.out.println();
        System.out.println("非递归前序遍历二叉树结果：");
        tree.nonRecursivePreOrder(root);
        System.out.println();

        System.out.println("递归中序遍历二叉树结果：");
        tree.inOrder(root);
        System.out.println();
        System.out.println("非递归中序遍历二叉树结果：");
        tree.nonRecursiveInOrder(root);
        System.out.println();

        System.out.println("递归后序遍历二叉树结果：");
        tree.postOrder(root);
        System.out.println();
        System.out.println("非递归后序遍历二叉树结果：");
        tree.nonRecursivePostOrder(root);
        System.out.println();

        System.out.println("层次遍历二叉树结果：");
        tree.levelTraverse(root);
        System.out.println();

        System.out.println("递归求二叉树的高度："+ tree.treeHeight(root));

        System.out.println("递归二叉树的结点数："+ tree.treeNodes(root));

        System.out.println("递归二叉树的叶子节点："+tree.treeLeaf(root));


    }
}
