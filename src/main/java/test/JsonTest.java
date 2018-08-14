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


        /**
         * test the override the value
         * find the key and put the new values.
         */

        jsonObject.put("zky1","I was changed.");

        System.out.println(jsonObject);
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

        JSONObject jsonObject3  =new JSONObject();

        JSONArray jsonArray3 = new JSONArray();


        jsonObject3.put("name","牛肉");
        jsonObject3.put("id",1);
        jsonObject3.put("price",30);
        jsonObject3.put("sign","1");
        jsonObject3.put("name","猪肉");
        jsonObject3.put("id",2);
        jsonObject3.put("price",10);
        jsonObject3.put("sign","2");
        jsonObject3.put("name","鱼肉");
        jsonObject3.put("id",3);
        jsonObject3.put("price",20);
        jsonObject3.put("sign","3");

        jsonArray3.add(jsonObject3);
        System.out.println(jsonArray3);
        /**
         * {
         "A": [
         {
         "id": "1",
         "name": "Apple",
         "price": "3"
         },
         {
         "id": "2",
         "name": "Avocado",
         "price": "22"
         },
         {
         "id": "3",
         "name": "Orange",
         "price": "2"
         }
         ],
         "B": [
         {
         "id": "4",
         "name": "Durian",
         "price": "50"
         },
         {
         "id": "5",
         "name": "Lichee",
         "price": "6"
         },
         {
         "id": "6",
         "name": "Potato",
         "price": "1"
         }
         ],
         "C": [
         {
         "id": "7",
         "name": "Tomato",
         "price": "1"
         },
         {
         "id": "8",
         "name": "Banana",
         "price": "2.5"
         },
         {
         "id": "9",
         "name": "Watermelon",
         "price": "1"
         }
         ]
         }
         */

        JSONObject jsonObject4 = new JSONObject();
        JSONArray jsonArray4 = new JSONArray();
        JSONObject jsonObject5 = new JSONObject();

        jsonObject5.put("id","1");
        jsonObject5.put("name","Apple");
        jsonObject5.put("price","3");
        jsonArray4.add(jsonObject5);

        JSONObject jsonObject6 = new JSONObject();
        jsonObject6.put("id","2");
        jsonObject6.put("name","Avocado");
        jsonObject6.put("price","22");
        jsonArray4.add(jsonObject6);

        JSONObject jsonObject7 = new JSONObject();
        jsonObject7.put("id","3");
        jsonObject7.put("name","Orange");
        jsonObject7.put("price","2");
        jsonArray4.add(jsonObject7);

        jsonObject4.put("A",jsonArray4);

        JSONArray jsonArray5 = new JSONArray();
        JSONObject jsonObject8 = new JSONObject();
        jsonObject8.put("id","4");
        jsonObject8.put("name","Durian");
        jsonObject8.put("price","50");
        jsonArray5.add(jsonObject8);

        JSONObject jsonObject9 = new JSONObject();
        jsonObject9.put("id","5");
        jsonObject9.put("name","Lichee");
        jsonObject9.put("price","6");
        jsonArray5.add(jsonObject9);

        JSONObject jsonObject10 = new JSONObject();
        jsonObject10.put("id","6");
        jsonObject10.put("name","Potato");
        jsonObject10.put("price","1");
        jsonArray5.add(jsonObject10);

        jsonObject4.put("B",jsonArray5);


        JSONArray jsonArray6 =  new JSONArray();
        JSONObject jsonObject11 = new JSONObject();
        jsonObject11.put("id","7");
        jsonObject11.put("name","Tomato");
        jsonObject11.put("price","1");
        jsonArray6.add(jsonObject11);

        JSONObject jsonObject12 = new JSONObject();
        jsonObject12.put("id","8");
        jsonObject12.put("name","Banana");
        jsonObject12.put("price","2.5");
        jsonArray6.add(jsonObject12);

        JSONObject jsonObject13 = new JSONObject();
        jsonObject13.put("id","9");
        jsonObject13.put("name","Watermelon");
        jsonObject13.put("price","2");
        jsonArray6.add(jsonObject13);

        jsonObject4.put("C",jsonArray6);




    }



    public boolean checkRepetitionValue(JSONArray jsonArray,Long id)
    {
        for (Object obj : jsonArray)
        {
            Long lon= (Long) obj;
//            Long lon= Long.parseLong(obj.toString());
            if (id.compareTo(lon)==0)
            {
                return true;
            }
        }

        System.out.println("1234");
        System.out.println("54321");
        return false;
    }

    @Test
    public void testObjectToLong ()
    {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(Long.parseLong("1"));
        jsonArray.add(2L);
        jsonArray.add(3L);
        boolean b = checkRepetitionValue(jsonArray, 1L);
        checkRepetitionValue(jsonArray,1L);
    }
}
