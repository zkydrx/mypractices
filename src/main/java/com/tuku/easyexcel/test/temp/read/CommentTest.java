package com.tuku.easyexcel.test.temp.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 临时测试
 *
 * @author Jiaju Zhuang
 **/
@Ignore
public class CommentTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentTest.class);

    @Test
    public void comment() throws Exception
    {
        File file = new File("D:\\test\\d1.xlsx");
        List<Map<Integer, CellData>> datas = EasyExcel.read(file).doReadAllSync();
        for (Map<Integer, CellData> data : datas)
        {
            LOGGER.info("数据:{}", JSON.toJSONString(data));
        }
    }

}
