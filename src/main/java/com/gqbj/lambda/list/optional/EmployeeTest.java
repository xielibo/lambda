package com.gqbj.lambda.list.optional;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 宫崎不骏
 * @className EmployeeTest
 * @Version 1.0
 * @Description: TODO
 * @date 2020/1/2220:12
 */
public class EmployeeTest {
    public static List<Employee> generateData() {
        return Arrays.asList(new Employee("Matt", 5000, "New York"),
                new Employee("Steve", 6000, "London"),
                new Employee("Carrie", 10000, "New York"),
                new Employee("Peter", 7000, "New York"),
                new Employee("Alec", 6000, "London"),
                new Employee("Sarah", 8000, "London"),
                new Employee("Rebecca", 4000, "New York"),
                new Employee("Pat", 20000, "New York"),
                new Employee("Tammy", 9000, "New York"),
                new Employee("Fred", 15000, "Tokyo"));
    }

    public static Map<String, Integer> generateMapData() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        return items;
    }

    @Test
    public void testEmployee(){
        List<Employee> results = generateData();

        //打印出名字是Strve的员工信息
        results.forEach(c->{
            if (c.getName().equals("Steve")){
                System.out.println("打印出名字是Strve的员工信息:"+c);
            }
        });
        System.out.println("----------I'm the divider----------");

        //找出年薪超过6000的员工
        results.stream().filter(c -> c.getSalary() >= 6000).forEach(
                c -> System.out.println("年薪>=6000的员工有"+c));

        System.out.println("----------I'm the divider----------");

        //java8遍历map
        Map<String, Integer> map = generateMapData();
        map.forEach((key,value)->
                System.out.println("key:"+key+","+"value:"+value));

        System.out.println("----------I'm the divider----------");

        //java8 分组操作
        Map<String,List<Employee>> groupMap = results.stream().collect(Collectors.groupingBy(c -> c.getOffice()));
        System.out.println("groupMap:"+groupMap);

        System.out.println("----------I'm the divider----------");

        //List转化map
        Map<String,Object> map_ = results.stream().collect(Collectors.toMap(Employee::getName,Employee::getOffice));
        map_.forEach((key, value) ->
                System.out.println("key:"+key+","+"value:"+value));

        System.out.println("----------I'm the divider----------^-^");
        /**
         * 注意  java8 stream 的toMap方法，如果key有重复的就会跑出 Exception in thread "main" java.lang.IllegalStateException: Duplicate key 的异常
         * 原因map集合key是唯一的，有多个重复的key
         * 原始方法如下： Map<Integer,Employee> employeeMap = results.stream().collect(Collectors.toMap((key -> key.getSalary()),(value -> value)));
         * 改进方法如下： Map<Integer,Employee> employeeMap = results.stream().collect(Collectors.toMap((key -> key.getSalary()),(value -> value),(e1,e2) -> e1));
         * 改进方法只取了相同key信息的第一条，也就是e1。
         **/
        Map<Integer,Employee> employeeMap = results.stream().collect(Collectors.toMap((key -> key.getSalary()),(value -> value),(e1,e2) -> e1));
        employeeMap.forEach((key,value) ->
                System.out.println(key+","+value));

        System.out.println("----------I'm the divider----------^-^");
        //打印出值大于30的map
        Map<String,Integer> resultMap = map.entrySet().stream().filter(c -> c.getValue() > 30).collect(Collectors.toMap(p -> p.getKey(),p -> p.getValue()));
        resultMap.forEach((key,value) ->
                System.out.println(key + "=" + value));

        System.out.println("----------I'm the divider----------^-^");
        //打印key=D的map
        Map<String,Integer> mapResults = map.entrySet().stream().filter(c -> c.getKey().equals("D")).collect(Collectors.toMap(p -> p.getKey(),p -> p.getValue()));
        mapResults.forEach((key,value) -> System.out.println(key + ">>>" + value));

        System.out.println("----------I'm the divider----------^-^");
        Optional<String> optional = Optional.of("李海潮吃屁");
        System.out.println(optional.isPresent());


    }
    @Test
    public void testEmployeeExample() {
        //anyMatch
        List<Employee> employeeList = generateData();
        boolean isMatch = employeeList.stream().anyMatch(employee -> employee.getOffice().equals("London"));
        System.out.println("isMatch:"+isMatch);

        //allMatch
        boolean matched = employeeList.stream().allMatch(employee -> employee.getOffice().equals("London"));
        System.out.println(matched);

        //找出工资最高的
        Optional<Employee> employeeOptional = employeeList.stream().max((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(employeeOptional);

        //找出工资最少的
        Optional<Employee> employee = employeeList.stream().min((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(employee);

        //返回姓名列表
        List<String> names = employeeList.stream().map(c->c.getName()).collect(Collectors.toList());
        System.out.println(names);

        System.out.println(">>>>>>>>>>>");
        //List转化Map
        Map<String,Employee> employeeMap = employeeList.stream().collect(Collectors.toMap((key->key.getName()),(value->value)));
        employeeMap.forEach((key,value)-> System.out.println(key + "=" + value));

        //统计办公室是New York的个数
        long officeCount =  employeeList.stream().filter(c->c.getOffice().equals("New York")).count();
        System.out.println(officeCount);

        long salaryCount = employeeList.stream().filter(c->c.getSalary()>60000).count();
        System.out.println(salaryCount);

        //List转化为Set
        Set<String> officeSet = employeeList.stream().map(c->c.getOffice()).distinct().collect(Collectors.toSet());
        System.out.println(officeSet);

        Set<Integer> salarySet = employeeList.stream().map(c->c.getSalary()).distinct().collect(Collectors.toSet());
        System.out.println(salarySet);

        //查找办公室地点是New York的员工
        Optional<Employee> optionals = employeeList.stream().filter(c->c.getOffice().equals("New York")).findAny();
        System.out.println(optionals);

        System.out.println(">>>>>工资降序排序>>>>>");
        //按照工资的降序来列出员工信息
        List<Employee> sortSalaryEmployeeList = employeeList.stream().sorted((e1,e2)->Integer.compare(e2.getSalary(),e1.getSalary())).collect(Collectors.toList());
        System.out.println(sortSalaryEmployeeList);

        System.out.println(">>>>>姓名升序排序>>>>>");
        List<Employee> sortNameEmployeeList = employeeList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        System.out.println(sortNameEmployeeList);

        System.out.println(">>>>获取工资最高的前2条员工信息");
        List<Employee> dispaly2EmployeeList = employeeList.stream().sorted((e1,e2)->Integer.compare(e2.getSalary(),e1.getSalary())).limit(2).collect(Collectors.toList());
        System.out.println(dispaly2EmployeeList);

        System.out.println(">>>>获取平均工资");
        OptionalDouble averageSalary = employeeList.stream().mapToInt(c->c.getSalary()).average();
        System.out.println(averageSalary);

        System.out.println(">>>>获取工作地点的平均工资");
        OptionalDouble optionalDouble = employeeList.stream().filter(c->c.getOffice().equals("New York")).mapToInt(c->c.getSalary()).average();
        System.out.println(optionalDouble);

        System.out.println(">>>>>>Java8 Optional用法>>>>>>");
        Optional<String> stringOptional = Optional.of("test");
        System.out.println(stringOptional.get());

        Optional<String> isOptional = Optional.ofNullable("hello");
        System.out.println(isOptional.isPresent());
        System.out.println(isOptional.get());
        System.out.println(isOptional.orElse("0"));

        System.out.println(">>>>>>>>>>>>");
        //Optional<String> optionalVal = Optional.of(null);
        // System.out.println(optionalVal);
        Optional<String> optional = Optional.ofNullable("optional");
        System.out.println(optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("haha"));
        System.out.println(">>>>>>>>>>>>");

        Optional<Employee> employeeOptional_ = employeeList.stream().filter(c->c.getOffice().equals("New York")).findFirst();
        System.out.println(employeeOptional_);

    }



}
