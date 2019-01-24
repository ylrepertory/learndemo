package main.java;

import java.io.*;

/**
 * @program: learndemo
 * @description: io学习
 * @author: leo
 * @create: 2019-01-14 16:22
 **/
public class IOLearn {
    public static void main(String[] args) {
        File file=new File("");
        try {
            FileReader fileReader=new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
