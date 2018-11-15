package workTest.emailTest;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    /**
     * 基于apache的邮件框架仅支持jdk1.8及更高版本
     * @param args
     */
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


    /**
     * 仅支持jdk1.8
     */
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


    /**
     * 使用springemail 的邮件工具完美解决TLS问题（javax.mail.MessagingException: Could not convert socket to TLS;）
     * 同时支持jdk1.7和jdk1.8
     */
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    /**
     * 初始化邮件发送数据
     *
     * @param host     服务器
     * @param username 发送人
     * @param passwd   发送人密码
     */
    public void initData(String host, String username, String passwd)
    {
        //创建邮件发送服务器
        mailSender.setHost(host);
        mailSender.setPort(587);
        mailSender.setUsername(username);
        mailSender.setPassword(passwd);
        //加认证机制
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        javaMailProperties.put("mail.smtp.ssl.trust", "*");
        mailSender.setJavaMailProperties(javaMailProperties);
        System.out.println("初始化邮件发送信息完成");
    }

    /**
     * 发送普通文本
     *
     * @param email   对方邮箱地址
     * @param subject 主题
     * @param text    邮件内容
     */
    public void simpleMailSend(String email, String subject, String text)
    {
        //创建邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        //发送邮件
        mailSender.send(message);
        System.out.println("发送成功");
    }


    @Test
    public void testSpringEmail()
    {
        initData("****", "test@****.com", "****");

        simpleMailSend("****@qq.com", "A", "123");
    }
}
