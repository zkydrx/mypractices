package com.tuku.spider.test.douban.data;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-06-01 Time: 11:47:26
 * Description:
 */
@Data
public class DouBanData {
	@ExcelProperty("电影名称")
	@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 42)
	@ColumnWidth(20)
	private String title;
	@ColumnWidth(3)
	@ExcelProperty("评分")
	@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 42)
	private String score;
	@ExcelProperty("评价数")
	@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 42)
	@ColumnWidth(15)
	private String num;
	@ExcelProperty("短评")
	@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 42)
	@ColumnWidth(50)
	private String quote;
	@ExcelProperty("链接")
	@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 42)
	@ColumnWidth(39)
	private String link;
	/**
	 * 忽略这个字段
	 */
	@ExcelIgnore
	private String ignore;
}
