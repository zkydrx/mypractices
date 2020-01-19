package com.tuku.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-01-17
 * Time: 13:34:01
 * Description:
 */
public class StringSubTest
{
    Logger logger = LoggerFactory.getLogger(StringSubTest.class);
    @Test
    public void testSubString()
    {
        String testStr = "微信支付+支付宝支付+";
        logger.info("test:{}",testStr.substring(0,testStr.length()-1));
    }
}
