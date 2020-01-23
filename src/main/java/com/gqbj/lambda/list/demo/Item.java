package com.gqbj.lambda.list.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 宫崎不骏
 * @className Person
 * @Version 1.0
 * @Description: TODO
 * @date 2020/1/2120:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item  {

    private String name;

    private int qty;

    private BigDecimal price;

}
