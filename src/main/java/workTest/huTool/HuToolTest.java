package workTest.huTool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-12-26
 * Time: 14:31:36
 * Description:
 */
public class HuToolTest
{
    public static void main(String[] args)
    {
        File file = FileUtil.file("\\\\192.168.50.11\\公共文件夹\\2018\\2.8其他\\1.加班调休统计表\\技术部\\2018技术部加班调休统计表.xls");
        HttpRequest request = HttpRequest
                .post("http://localhost:8889/file/upload")
                .form("file", file)
                .form("fileType", "图片");

        HttpResponse response = request.execute();
        System.out.println(response.body());

    }
}
