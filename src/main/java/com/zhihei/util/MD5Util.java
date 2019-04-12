package com.zhihei.util;

import cn.hutool.crypto.digest.MD5;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-04-12
 * Time: 19:10:52
 * Description:
 */
public class MD5Util
{
    @Test
    public void etestMd5()
    {
        MD5 md5 =new MD5();
        String s = md5.digestHex("123456");
        System.out.println(s);
    }
}
