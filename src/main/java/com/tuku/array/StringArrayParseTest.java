package com.tuku.array;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-04-28
 * Time: 10:23:20
 * Description:
 * 字符串转为字符串数组的问题
 */
@Slf4j
public class StringArrayParseTest
{
    @Test
    public void testStringArray()
    {
        String arrayString = "[\"110000\",\"110100\"]";
        String substring = arrayString.substring(arrayString.indexOf("[")+1, arrayString.indexOf("]"));
        String[] split1 = substring.split(",");
        log.info("截取的字符串：substring：{}",substring);
        log.info("直接字符串截取，处理---split1[0]:{}",split1[0]);
        log.info("直接字符串截取，处理---split1[1:{}",split1[1]);
        JSONArray jsonArray = JSONObject.parseArray(arrayString);
        log.info("解析成json数组---jsonArray 0:{}",jsonArray.get(0));
        log.info("解析成json数组---jsonArray 1:{}",jsonArray.get(1));
        String toString = jsonArray.toString();
        /**
         * 这里已经成功完成了数据的转换。
         */
        toString = toString.substring(toString.indexOf("[") + 1, toString.indexOf("]")).replaceAll("\"","");
        log.info("json数组转成字符串toString:{}",toString);
        String[] split = toString.split(",");
        log.info("json数组转成字符串，然后对字符串进行处理---split[0]:{}",split[0]);
        log.info("json数组转成字符串，然后对字符串进行处理---split[1]:{}",split[1]);

        /**
         * 其实可以直接使用字符串。
         */

        String[] split2 = arrayString.substring(arrayString.indexOf("[") + 1, arrayString.indexOf("]")).replaceAll("\"", "").split(",");

        log.info("直接使用字符串，进行截取与处理---split2[0]:{}",split2[0]);
        log.info("直接使用字符串，进行截取与处理---split2[0]:{}",split2[1]);

    }
}
