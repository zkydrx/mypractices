package com.hundsun.practices.multiparameter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class MultiParameter {

	public static void multi(String... str) {

		for (int i = 0; i < str.length; i++) {
			log.info("第" + (i + 1) + "个参数:{}", str[i]);
		}
	}

	@Test
	public void testMulti(){
		multi("zhou","wang","ding");
	}

}
