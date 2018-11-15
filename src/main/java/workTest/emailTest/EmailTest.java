package workTest.emailTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

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


    @Test
    public void testJavaMail()
    {
        Properties prop = new Properties();
        prop.setProperty("mail.debug", "true");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.EnableSSL.enable", "true");
        prop.put("mail.smtp.ssl.trust", "*");

        Session session = Session.getInstance(prop);
        Transport ts;
        try
        {
            ts = session.getTransport();
            ts.connect("***", "test@***.com", "***");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test@***.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("1964483239@qq.com")); // 邮件的收件人
            //            message.setRecipient(Message.RecipientType.CC, new InternetAddress("zkydrx@gmail.com")); //
            // 邮件的抄送人
            //            message.setRecipient(Message.RecipientType.BCC, new InternetAddress("zkyjob@gmail.com"));
            // 邮件的密送人
            message.setSubject("Subject");
            message.setText("Content");
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        }
        catch (NoSuchProviderException e)
        {
            e.printStackTrace();
        }
        catch (AddressException e)
        {
            e.printStackTrace();
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }

    }
}
