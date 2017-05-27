package com.dudy.learn01.coderising.jvm;

/**
 * Created by dudy on 2017/5/27.
 * java -Xss64k
 * 我们知道, JVM 的运行时数据区中有一个叫做 虚拟机栈 的内存区域, 此区域的作用是:
 * 每个方法在执行时都会创建一个栈帧, 用于存储局部变量表, 操作数栈, 方法出口等信息.
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError(1);
    }

    private static void stackOverflowError(int i) {
        i++;
        stackOverflowError(i);

    }

}
