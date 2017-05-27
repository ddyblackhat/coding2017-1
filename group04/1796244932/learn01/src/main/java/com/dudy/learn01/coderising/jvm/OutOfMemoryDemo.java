package com.dudy.learn01.coderising.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dudy on 2017/5/27.
 * java -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OutOfMemoryDemo {

    public static void main(String[] args) {
        System.out.println("asldfajsd;fjasdlfßßßß");
        List<Integer>  list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(i++);
        }


    }
}
