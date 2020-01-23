package com.gqbj.lambda.list.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宫崎不骏
 * @className ExampleList
 * @Version 1.0
 * @Description: List操作
 * @date 2020/1/2120:09
 */
public class ExampleList {
    private static List<String> items = new ArrayList<>();

    static {
        items.add("A");
        items.add("BC");
        items.add("C");
        items.add("BD");
        items.add("E");
    }
    public static void main (String[] args){
        //java8之前操作list
        for (String item:items){
            System.out.println(item);

        }
        System.out.println("-------------");
        //java8 lambda遍历list
        items.forEach(c-> System.out.println(c));

        System.out.println("-------------");
        items.forEach(item->{
            if ("C".equals(item)){
                System.out.println(item);
            }
        });

        System.out.println("-------------");

        //先过滤
        //stream() − 为items集合创建串行流。过滤是否包含“B”的
        items.stream().filter(s->s.contains("B")).forEach(c1-> System.out.println(c1));
    }




}









