package com.gqbj.lambda.list.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 宫崎不骏
 * @className Person
 * @Version 1.0
 * @Description: TODO
 * @date 2020/1/2215:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private String address;
}
