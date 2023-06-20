package com.hundsun.practices.pairs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.instanceofs
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/11/22 15:56
 * @UpdateUser: zky
 * @UpdateDate: 2021/11/22 15:56
 * @UpdateRemark: The modified content
 * @DATE: 2021-11-22 15:56
 * @SINCE:
 * @Version: 1.0
 *           <p>
 *           Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class JSONObjectTests {
	public static void main(String[] args) {
		String json = "{\n" + "      \"id\": \"600570SH\",\n" + "      \"index_map\": {\n"
				+ "        \"pos_valuation_market_value\": {\n" + "          \"38614\": \"1\"\n" + "        }\n"
				+ "      }\n" + "    }";
		// JSONObject jsonObject = JSONObject.parseObject(a);
		// JSONArray result = jsonObject.getJSONArray("result");

		Gson gson = new Gson();
		PairObject pairObject = gson.fromJson(json, PairObject.class);
	}

	@Test
	public void test1() {
		PairObjectOne pairObjectOne = new PairObjectOne();
		pairObjectOne.setId("1");
		Map<String, DataType> map = new HashMap<>();
		map.put("1", DataType.builder().dataString("1112312321").dataType("1").build());
		pairObjectOne.setIndexData(map);

		String string = JSON.toJSONString(pairObjectOne);

		log.info("string:{}", string);
		List<PairObjectOne> pairObjectOnes = JSONArray.parseArray(string, PairObjectOne.class);
		log.info("pairObjectOnes:{}", pairObjectOnes.get(0).toString());

	}
}
