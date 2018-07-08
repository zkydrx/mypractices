package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-07-06
 * Time: 14:52:28
 * Description:
 */
public class JsonTest
{
    @Test
    public void jsonTest()
    {
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < 3; i++)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("apple1", 10001);
            jsonObject.put("apple2", 10002);
            jsonObject.put("apple3", 10003);
            jsonObject.put("apple4", 10004);
            jsonObject.put("apple5", 10005);
            jsonArray.add(i,jsonObject);
        }

        JSONObject jsonObject =  new JSONObject();
        jsonObject.put("zky1", "drx1");
        jsonObject.put("zky2", "drx2");
        jsonObject.put("zky3", "drx3");
        jsonObject.put("zky4", "drx4");
        jsonObject.put("zky5", "drx5");
        jsonObject.put("data", jsonArray);
        /**
         *
         这是组装好以后的json格式的数据。从下面的组装情况来看。说明json组装的报文是无序列的。
         就是并不是按照先后的put顺序而进行排列展示的。
         * {
         "zky1": "drx1",
         "zky3": "drx3",
         "zky2": "drx2",
         "zky5": "drx5",
         "data": [
         {
         "apple1": 10001,
         "apple2": 10002,
         "apple3": 10003,
         "apple4": 10004,
         "apple5": 10005
         },
         {
         "apple1": 10001,
         "apple2": 10002,
         "apple3": 10003,
         "apple4": 10004,
         "apple5": 10005
         },
         {
         "apple1": 10001,
         "apple2": 10002,
         "apple3": 10003,
         "apple4": 10004,
         "apple5": 10005
         }
         ],
         "zky4": "drx4"
         }


         说明json是无序的
         */
        System.out.println(jsonObject.toJSONString());

        System.out.println(jsonArray.toJSONString());
    }
}
