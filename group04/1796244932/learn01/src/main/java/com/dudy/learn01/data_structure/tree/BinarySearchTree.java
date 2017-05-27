package com.dudy.learn01.data_structure.tree;

import java.util.List;

public class BinarySearchTree<T extends Comparable> {

    BinaryTreeNode<T> root;

    public BinarySearchTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public T findMin() {
        return findMin(root).data;
    }

    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> t) {
        if (t == null) {
            return null;
        }
        BinaryTreeNode<T> current = t;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    public T findMax() {
        if (root == null) {
            return null;
        }
        BinaryTreeNode<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode<T> t) {
        if (t == null) return 0;
        int leftChildHeight = height(t.left);
        int rightChildHeight = height(t.right);
        if (leftChildHeight > rightChildHeight) {
            return leftChildHeight + 1;
        } else {
            return rightChildHeight + 1;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<T> root) {
        if (root == null) return 0;

        return size(root.left) + 1 + size(root.right);
    }

    public void remove(T e) {
        remove(e, root);
    }

    private BinaryTreeNode<T> remove(T e, BinaryTreeNode<T> t) {
        if (root == null) {
            return t;
        }

        int compareResult = e.compareTo(t.data);
        if (compareResult > 0) {
            t.right = remove(e, t.right);
        } else if (compareResult < 0) {
            t.left   = remove(e, t.left);
        } else {
            if (t.left != null && t.right != null) {
                t.data = findMin(t.right).data;
                t.right = remove(t.data, t.right);
            } else {
                 t = (t.left != null) ? t.left: t.right;
            }
        }

        return t;
    }


    public List<T> levelVisit(){

        return null;
    }
    public boolean isValid(){
        return false;
    }
    public T getLowestCommonAncestor(T n1, T n2){
        return null;

    }
    public List<T> getNodesBetween(T n1, T n2){
        return null;
    }


}