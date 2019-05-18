package com.learn.basic;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learndemo
 * @description:
 * @author: leo
 * @create: 2019-04-19 10:54
 **/
public class basic {
    public static void main(String[] args) {
        Integer i=2;
        Byte b=2;
        System.out.println(Objects.equals((int )b,i));
        Lock lock=new ReentrantLock();
        new HashMap<>();
    }
}
