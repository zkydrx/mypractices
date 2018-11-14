package workTest.emailTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-14
 * Time: 11:28:07
 * Description:
 */
public class EmailTest
{
    public static void main(String[] args)
    {
        MultiPartEmail mail = new MultiPartEmail();
        try
        {
            mail.setHostName("192.168.10.30");
            mail.setAuthentication("test@*****", "*****");
            mail.setCharset("UTF-8");
            mail.setFrom("test@*****.com", "*****");
            mail.addTo("1964483239@qq.com", "Chrome");
            mail.setSubject(MimeUtility.encodeText("待办事务提醒", "UTF-8", "B"));
            mail.setMsg("A" + "有一条新记录" + "Z" + "等待审核");
            mail.setStartTLSEnabled(true);
            mail.setSmtpPort(587);
            mail.send();
        }
        catch (EmailException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }
}
