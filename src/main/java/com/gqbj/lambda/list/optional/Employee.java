package com.gqbj.lambda.list.optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 鲁班
 * @className Employee
 * @Version 1.0
 * @Description: TODO
 * @date 2020/1/2216:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private int salary;
    private String office;
}
