package com.gqbj.lambda.list.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 鲁班
 * @className ExampleFilterMap
 * @Version 1.0
 * @Description: FilterMap操作
 * @date 2020/1/2215:54
 */
public class ExampleFilterMap {

    private static Map<Integer,String> map = new HashMap<>();

    static {
        map.put(1,"熊大");
        map.put(2,"熊二");
        map.put(3,"光头强");
        map.put(4,"吉吉国王");
        map.put(5,"土坡鼠");
    }
    public static void main(String[] args){
        // java8 之前操作 map
        String result = null;
        for (Map.Entry<Integer,String> entry:map.entrySet()){
            if ("熊大".equals(entry.getValue())){
                result = entry.getValue();
            }
        }
        System.out.println("Before java 8 :"+result);

        //java8 map->stream->filter->string
        result = map.entrySet().stream().filter(map->"熊二".equals(map.getValue()))
                .map(map->map.getValue())
                .collect(Collectors.joining());
        System.out.println("After java 8 "+result);

        Map<Integer,String> collect = map.entrySet().stream().filter(c->c.getKey()==3)
                .collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));
        System.out.println(collect);
    }
}
