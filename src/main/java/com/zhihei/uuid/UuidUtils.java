package com.zhihei.uuid;

import cn.hutool.core.lang.UUID;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-04-09 Time: 10:43:52
 * Description:
 */
public class UuidUtils {
	@Test
	public void testUuid() {
		UUID uuid = UUID.fastUUID();
		System.out.println(uuid);
	}
}
