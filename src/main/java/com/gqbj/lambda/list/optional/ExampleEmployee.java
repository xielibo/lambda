package com.gqbj.lambda.list.optional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 宫崎不骏
 * @className ExampleEmployee
 * @Version 1.0
 * @Description: TODO
 * @date 2020/1/2217:12
 */
public class ExampleEmployee {
    private static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(Employee.builder().name("张三疯").salary(5000).office("郑州").build());
        employeeList.add(Employee.builder().name("张无忌").salary(8000).office("武当山").build());
        employeeList.add(Employee.builder().name("史玉柱").salary(9000).office("上海").build());
        employeeList.add(Employee.builder().name("任正非").salary(4000).office("北京").build());
        employeeList.add(Employee.builder().name("马化腾").salary(66000).office("深圳").build());
        employeeList.add(Employee.builder().name("马云").salary(85000).office("杭州").build());
        employeeList.add(Employee.builder().name("李嘉诚").salary(13000).office("香港").build());
        employeeList.add(Employee.builder().name("小瘪三").salary(23000).office("上海").build());
        employeeList.add(Employee.builder().name("阿三哥").salary(25000).office("上海").build());

    }
    public static void main(String[] args) {

        //anyMatch
        boolean isMatch = employeeList.stream().anyMatch(employee -> employee.getOffice().equals("北京"));
        System.out.println("isMatch:"+isMatch);

        //返回所有salary大于6000
        boolean matched = employeeList.stream().allMatch(employee -> employee.getSalary()>6000);
        System.out.println("matched:"+matched);

        //找出工资最高
        Optional<Employee> hightSalary = employeeList.stream().max((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println("hightSalary:"+hightSalary);

        //找出工资最低
        Optional<Employee> lowSalary = employeeList.stream().min((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
        System.out.println("lowSalary:"+lowSalary);

        //返回姓名列表
        List<String> names = employeeList.stream().map(employee -> employee.getName()).collect(Collectors.toList());
        System.out.println("names:"+names);

        //返回工资列表
        List<Integer> salarys = employeeList.stream().map(employee -> employee.getSalary()).collect(Collectors.toList());
        System.out.println("salarys:"+salarys);

        //返回office列表
        List<String> offices = employeeList.stream().map(employee -> employee.getOffice()).collect(Collectors.toList());
        System.out.println("offices:"+offices);

        //name List转换成map
        Map<String,Employee> employeeMap = employeeList.stream().collect(Collectors.toMap((key->key.getName()),(value->value)));
        employeeMap.forEach((key,value)->
                System.out.println(key + "=" + value));

        //salary List转换成map
        Map<Integer,Employee> employeeMapb = employeeList.stream().collect(Collectors.toMap((key->key.getSalary()),(value->value)));
        employeeMapb.forEach((key,value)->
                System.out.println(key + "=" + value));

        //统计办公地址是武当山的个数
        long officeCount = employeeList.stream().filter(employee -> employee.getOffice().equals("武当山")).count();
        System.out.println("officeCount:"+officeCount);

        //统计办公室是上海的个数
        long officeCounts = employeeList.stream().filter(employee -> employee.getOffice().equals("上海")).count();
        System.out.println("统计办公室是上海的个数:"+officeCounts);

        //List转换为set
        Set<String> officeSet = employeeList.stream().map(employee -> employee.getOffice()).distinct().collect(Collectors.toSet());
        System.out.println("officeSet:"+officeSet);
        Set<Integer> officeSets = employeeList.stream().map(employee -> employee.getSalary()).distinct().collect(Collectors.toSet());
        System.out.println("officeSet:"+officeSets);
        Set<String> officeSeta = employeeList.stream().map(employee -> employee.getName()).distinct().collect(Collectors.toSet());
        System.out.println("officeSet:"+officeSeta);

        //查找办公地址是上海的员工
        Optional<Employee> addressofice = employeeList.stream().filter(employee -> employee.getOffice().equals("上海")).findAny();
        System.out.println("查找办公地址是上海的员工:"+addressofice);

        //按照工资的降序来列出员工信息
        List<Employee> wagesdrop = employeeList.stream().sorted((e1,e2)->Integer.compare(e2.getSalary(),e1.getSalary())).collect(Collectors.toList());
        System.out.println("按照工资的降序来列出员工信息:"+wagesdrop);

        //按照名字的升序来列出员工信息
        List<Employee> namerise = employeeList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        System.out.println("按照名字的升序来列出员工信息:"+namerise);

        //获取工资最高的前2条员工信息
        List<Employee> topTwo = employeeList.stream().sorted((e1,e2)->Integer.compare(e2.getSalary(),e1.getSalary()))
                .limit(2).collect(Collectors.toList());
        System.out.println("获取工资最高的前2条员工信息:"+topTwo);

        //获取平均工资
        OptionalDouble averageSalary = employeeList.stream().mapToInt(employee->employee.getSalary()).average();
        System.out.println("平均工资:"+averageSalary);

        //查找上海
        OptionalDouble averagesAlaryByOffice = employeeList.stream().filter(employee -> employee.getOffice().equals("上海"))
                .mapToInt(employee->employee.getSalary()).average();
        System.out.println("上海办公室平均工资:"+averagesAlaryByOffice);
    }
}














