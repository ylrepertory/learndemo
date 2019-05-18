package com.learn.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: learndemo
 * @description:
 * @author: leo
 * @create: 2019-04-30 14:30
 **/
public class SortHandler {
    private Integer[] sortData = null;
    private Map<Integer,String> integerStringMap=new HashMap<>(100000000);


    /**
     * 排序
     * @param in 数据文件路径
     */
    public void sort(String in){
        File file = new File(in);
        if(!file.exists())
            return;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));){
            TreeSet<Integer> set = new TreeSet<>();
            String line = null;
            while((line = reader.readLine()) != null && !"".equals(line)){
                String[] lines = line.split(" ");
                Integer money=new Integer(lines[1]);
                set.add(money);
                integerStringMap.put(money,line);
            }
            this.sortData = set.toArray(new Integer[set.size()]);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 从pos开始，获取count个数
     * @param pos
     * @param count
     * @return
     */
    public List<String> limit(int pos, int count){
        String s=new String("javaisland");
        System.out.println(this instanceof SortHandler);

        List<String> maps=new ArrayList<>(count-pos);
        Integer[] result = new Integer[count];
        for (int i = 0; i < count && pos + i < this.sortData.length; i++) {
            result[i] = this.sortData[pos + i];
            maps.add(integerStringMap.get(result[i]));
        }
        int i = 0;
        while (maps.size()<count-pos&& i < count){
            result[i] = this.sortData[pos + i];
            maps.add(integerStringMap.get(result[i]));
        }
        return maps;
    }

    public static void main(String[] args) {

        SortHandler handler = new SortHandler();
        for (int i=0;i<10;i++){
            handler.sort("file"+i+".txt");
        }


        List<String> limit = handler.limit(10, 10);
        System.out.println(Arrays.asList(limit));
    }
}
