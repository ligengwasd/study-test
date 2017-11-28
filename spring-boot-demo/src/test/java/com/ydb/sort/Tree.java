package com.ydb.sort;

/**
 * Created by ligeng on 17/11/28.
 */
public class Tree {
    public static void main(String[] args) {

    }
    private Node root;

    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            if (key < current.iData){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }
    public void insert(int iData, double dData){
        Node newNode = new Node();
        newNode.iData = iData;
        newNode.dData = dData;

        if (root == null){
            root = newNode;
        } else {
            Node currentNode = root;
            while (true){
                if (iData < currentNode.iData){
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        currentNode.leftChild = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        currentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}
class Node{
    public int iData; // key
    public double dData; // value
    public Node leftChild;
    public Node rightChild;
}
