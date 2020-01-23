package com.gqbj.lambda.list.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 宫崎不骏
 * @className ExampleTwoMapping
 * @Version 1.0
 * @Description: Groupingby操作
 * @date 2020/1/2215:28
 */
public class ExampleTwoMapping {
    private static List<Person> personList = new ArrayList<>();

    static {
        personList.add(Person.builder().id(10).name("张三疯").address("河南").build());
        personList.add(Person.builder().id(11).name("杨过").address("湖北").build());
        personList.add(Person.builder().id(12).name("小龙女").address("江西").build());

    }

    public static void main(String[] args) {
        //分组
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(c -> c.getAddress()));
        System.out.println("collect:" + collect);

        System.out.println("--------分割线-------");
        //java8  list转换map
        Map<Integer, Person> map_ = personList.stream().collect(Collectors.toMap((key -> key.getId()), (value -> value)));
        map_.forEach((key, value) -> System.out.println(key + ":" + value));

    }
}