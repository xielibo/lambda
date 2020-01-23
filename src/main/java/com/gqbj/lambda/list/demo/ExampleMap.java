package com.gqbj.lambda.list.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 宫崎不骏
 * @className ExampleMap
 * @Version 1.0
 * @Description: Map操作
 * @date 2020/1/2120:26
 */
public class ExampleMap {

    private static Map<String, Integer> items = new HashMap<>();

    static {
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        items.put("G", 70);
        items.put("H", 80);
    }

    public static void main(String[] args){
        //java8 之前遍历是这样遍历map
        for (Map.Entry<String,Integer> entry:items.entrySet()){
            System.out.println("key:" + entry.getKey() +  " value:" + entry.getValue());
        }
        System.out.println("---------------------");

        //java8遍历map
        items.forEach((key,value)-> System.out.println("key:" + key + " value:" + value));
    }
}
