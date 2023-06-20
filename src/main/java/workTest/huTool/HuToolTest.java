package workTest.huTool;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-12-26 Time: 14:31:36
 * Description:
 */
public class HuToolTest {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("zky1", "drx1");
		jsonObject.put("zky2", "drx2");
		jsonObject.put("zky3", "drx3");
		JSONArray array = JSONUtil.createArray();
		array.add(jsonObject);
		Map<String, String> map = new HashMap<>();
		map.put("1", "123");
		array.add(map);
		System.out.println(array);
		DateTime date = DateUtil.date();
		System.out.println(date);
		DateTime dateTime = DateUtil.parseDateTime(date.toString());

	}
}
