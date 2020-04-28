package com.tuku.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-04-22
 * Time: 15:40:15
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarBenz
{
    private String name;
    private BigDecimal price;
    private int age;
}
