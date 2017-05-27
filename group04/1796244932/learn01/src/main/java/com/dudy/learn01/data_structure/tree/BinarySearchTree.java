package com.dudy.learn01.data_structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
            t.left = remove(e, t.left);
        } else {
            if (t.left != null && t.right != null) {
                t.data = findMin(t.right).data;
                t.right = remove(t.data, t.right);
            } else {
                t = (t.left != null) ? t.left : t.right;
            }
        }

        return t;
    }


    public List<T> levelVisit() {
        List<T> result = new ArrayList<T>();
        Queue<BinaryTreeNode<T>> queue = new LinkedBlockingQueue<BinaryTreeNode<T>>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTreeNode<T> node = queue.remove();
                result.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }

        return result;
    }

    public boolean isValid() {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValid(BinaryTreeNode<T> r, Integer min, Integer max) {
        if (r == null) {
            return  true;
        }

        if(r.data.compareTo(min) <= 0 ||
                r.data.compareTo(max) >=0  ){
            return  false;
        }
        return isValid(r.left,min,(Integer) r.data) && isValid(r.right,(Integer) r.data,max);
    }

    public T getLowestCommonAncestor(T n1, T n2) {
        return getLowestCommonAncestor(root,n1,n2);

    }

    // https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.03.md
    private T getLowestCommonAncestor(BinaryTreeNode<T> r, T n1, T n2) {
        while (true){
            if(r.data.compareTo(n2) >=0 ){
                r = r.left;
            } else  if (r.data.compareTo(n1) <= 0){
                r = r.right;
            } else {
                return r.data;
            }
        }




    }

    public List<T> getNodesBetween(T n1, T n2) {

        List<T>  result = new ArrayList<T>();

        Queue<BinaryTreeNode<T>>  queue =  new LinkedBlockingQueue<BinaryTreeNode<T>>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<T> node = queue.remove();
            if(node.data.compareTo(n1) >=0 &&
                    node.data.compareTo(n2) <=0){
                result.add(node.data);
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }



        return result;
    }


}