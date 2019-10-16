package com.zhihei.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-05-08
 * Time: 20:32:16
 * Description:
 */
public class JsonDataUtil
{
    public static JSONObject readJsonDataTOJsonObject(String filePath)
    {
        StringBuffer strbuffer = new StringBuffer();
        File myFile = new File(filePath);
        if (!myFile.exists())
        {
            System.err.println("找不到文件");
        }
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in = new BufferedReader(inputStreamReader);
            String str;
            while ((str = in.readLine()) != null)
            {
                strbuffer.append(str);
            }
            in.close();
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
        JSONObject jsonObject = (JSONObject) JSONObject.parse(strbuffer.toString());

        return jsonObject;
    }
}
