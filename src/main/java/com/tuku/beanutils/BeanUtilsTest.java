package com.tuku.beanutils;

import com.tuku.model.CarAudi;
import com.tuku.model.CarBenz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-04-22 Time: 15:11:28
 * Description:
 */
@Slf4j
public class BeanUtilsTest {
	public static void main(String[] args) {
		CarAudi audi = CarAudi.builder().name("奥迪").age(20).price(200000.00).build();
		CarBenz benz = CarBenz.builder().build();
		BeanUtils.copyProperties(audi, benz);
	}

}
