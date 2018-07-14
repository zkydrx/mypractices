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


        JSONArray jsonArray1 = new JSONArray();

        jsonArray1.add(0,"ok0");
        jsonArray1.add(1,"ok1");
        jsonArray1.add(2,"ok2");
        jsonArray1.add(3,"ok3");
        jsonArray1.add(4,"ok4");
        jsonArray1.add(5,"ok5");
        jsonArray1.add(6,"ok6");
        jsonArray1.add(7,"ok7");
        jsonArray1.add(8,"ok8");

        System.out.println(jsonArray1);
    }

    @Test
    public void testKindsOfJson()
    {
        /**
         * kinds of one
         * {"String":"value"}
         * {"apple6":"iphone6","apple7":"iphone7","apple4":"iphone4","apple5":"iphone5"}
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("apple4","iphone4");
        jsonObject.put("apple5","iphone5");
        jsonObject.put("apple6","iphone6");
        jsonObject.put("apple7","iphone7");

        System.out.println(jsonObject);

        /**
         * kinds of two
         * ["value"]
         * ["google1","google2","google3","google4"]
         */
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0,"google1");
        jsonArray.add(1,"google2");
        jsonArray.add(2,"google3");
        jsonArray.add(3,"google4");
        System.out.println(jsonArray);


        /**
         * kinds of three
         * {"String":["value"]}
         * {"fruit":["apple","banana","tmatoes"]}
         */
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();

        jsonArray1.add("apple");
        jsonArray1.add("banana");
        jsonArray1.add("tmatoes");

        jsonObject1.put("fruit",jsonArray1);

        System.out.println(jsonObject1);

        /**
         * kinds of four
         * [{"String":"value","String":"value"}]
         * [{"price":5000,"name":"tree","age":26,"height":30}]
         */
        JSONObject jsonObject2 = new JSONObject();
        JSONArray jsonArray2 = new JSONArray();

        jsonObject2.put("name","tree");
        jsonObject2.put("age",26);
        jsonObject2.put("height",30);
        jsonObject2.put("price",5000);

        jsonArray2.add(jsonObject2);

        System.out.println(jsonArray2);



    }
}
