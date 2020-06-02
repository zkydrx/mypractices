package com.tuku.spider.test.douban.data;

import com.alibaba.excel.annotation.write.style.ContentStyle;
import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-06-01
 * Time: 11:59:08
 * Description:
 */
@Data
@Builder
public class DouBanWriteData
{
    @ContentStyle(locked = true)
    private String title;
    @ContentStyle(locked = true)
    private String score;
    @ContentStyle(locked = true)
    private String num;
    @ContentStyle(locked = true)
    private String quote;
    @ContentStyle(locked = true)
    private String link;
}
