package workTest.excel;


import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-12-24
 * Time: 11:16:39
 * Description:
 *
 */
public class ExcelForCellVerify
{
    /**
     * 对每个cell的值进行校验
     */
    public String isNull(Cell cell)
    {

        String value = "";
        if (cell == null)
        {
            return value;
        }
        switch (cell.getCellType())
        {
            //数值型
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell))
                {
                    //如果是date类型则 ，获取该cell的date值
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = format.format(date);

                }
                else
                {   // 纯数字
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    if (null != value && !"".equals(value.trim()))
                    {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1]))
                        {
                            value = item[0];
                        }
                    }
                }
                break;
            //字符串类型
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            // 公式类型
            case Cell.CELL_TYPE_FORMULA:
                //读公式计算值
                value = String.valueOf(cell.getNumericCellValue());
                if (value.equals("NaN"))
                {   // 如果获取的数据值为非法值,则转换为获取字符串
                    value = cell.getStringCellValue().toString();
                }
                break;
            // 布尔类型
            case Cell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            // 空值
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            // 故障
            case Cell.CELL_TYPE_ERROR:
                value = "";
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        if ("null".endsWith(value.trim()))
        {
            value = "";
        }
        return value;
    }
}
