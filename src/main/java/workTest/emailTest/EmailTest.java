package workTest.emailTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-11-14 Time: 11:28:07
 * Description:
 */
public class EmailTest {
	/**
	 * 基于apache的邮件框架仅支持jdk1.8及更高版本
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		MultiPartEmail mail = new MultiPartEmail();
		try {
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
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 仅支持jdk1.8
	 */
	@Test
	public void testJavaMail() {
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
		try {
			ts = session.getTransport();
			ts.connect("***", "test@***.com", "***");
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("test@***.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("1964483239@qq.com")); // 邮件的收件人
			// message.setRecipient(Message.RecipientType.CC, new
			// InternetAddress("zkydrx@gmail.com")); //
			// 邮件的抄送人
			// message.setRecipient(Message.RecipientType.BCC, new
			// InternetAddress("zkyjob@gmail.com"));
			// 邮件的密送人
			message.setSubject("Subject");
			message.setText("Content");
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用springemail 的邮件工具完美解决TLS问题（javax.mail.MessagingException: Could not convert
	 * socket to TLS;） 同时支持jdk1.7和jdk1.8
	 */
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	/**
	 * 初始化邮件发送数据
	 *
	 * @param host
	 *            服务器
	 * @param username
	 *            发送人
	 * @param passwd
	 *            发送人密码
	 */
	public void initData(String host, String username, String passwd) {
		// 创建邮件发送服务器
		mailSender.setHost(host);
		mailSender.setPort(587);
		mailSender.setUsername(username);
		mailSender.setPassword(passwd);
		// 加认证机制
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
	 * @param email
	 *            对方邮箱地址
	 * @param subject
	 *            主题
	 * @param text
	 *            邮件内容
	 */
	public void simpleMailSend(String email, String subject, String text) {
		// 创建邮件内容
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailSender.getUsername());
		message.setTo(email);
		message.setSubject(subject);
		message.setText(text);
		// 发送邮件
		mailSender.send(message);
		System.out.println("发送成功");
	}

	@Test
	public void testSpringEmailOnlyText() {
		initData("****", "test@****.com", "****");

		simpleMailSend("****@qq.com", "A", "123");
	}

	/**
	 * 发送附件,支持多附件 //使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
	 * //MimeMessages为复杂邮件模板，支持文本、附件、html、图片等。
	 *
	 * @param email
	 *            对方邮箱
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param paths
	 *            附件路径，和文件名
	 * @throws MessagingException
	 */
	public void attachedSend(String email, String subject, String text, Map<String, String> paths)
			throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		// 创建MimeMessageHelper对象，处理MimeMessage的辅助类
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		// 使用辅助类MimeMessage设定参数
		try {
			// helper.setFrom(mailSender.getUsername());
			/**
			 * 可以指定特殊用户名，就是显示的邮件题目是来自于谁
			 */
			helper.setFrom(mailSender.getUsername(), "指定用户名");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		helper.setTo(email);
		helper.setSubject(subject);
		helper.setText(text);

		if (paths != null) {
			paths.forEach((k, v) -> {
				// 加载文件资源，作为附件
				FileSystemResource file = new FileSystemResource(v);
				try {
					// 添加附件
					helper.addAttachment(k, file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		// 发送邮件
		mailSender.send(message);
		System.out.println("发送成功");
	}

	/**
	 * 发送html文件，支持多图片
	 *
	 * @param email
	 *            对方邮箱
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param paths
	 *            富文本中添加用到的路径，一般是图片，或者css,js文件
	 * @throws MessagingException
	 */
	public void richContentSend(String email, String subject, String text, Map<String, String> paths)
			throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom(mailSender.getUsername());
		helper.setTo(email);
		helper.setSubject(subject);
		// 第二个参数true，表示text的内容为html，然后注意<img/>标签，src='cid:file'，'cid'是contentId的缩写，'file'是一个标记，
		// 需要在后面的代码中调用MimeMessageHelper的addInline方法替代成文件
		helper.setText(text, true);
		// 文件地址相对应src目录
		// ClassPathResource file = new ClassPathResource("logo.png");

		if (paths != null) {
			paths.forEach((k, v) -> {
				// 文件地址对应系统目录
				FileSystemResource file = new FileSystemResource(v);
				try {
					helper.addInline(k, file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		mailSender.send(message);
		System.out.println("发送成功");
	}

	/**
	 * 群发多人，且多附件
	 *
	 * @param emails
	 *            多人邮件地址
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param filePath
	 *            文件路径
	 * @throws Exception
	 */
	public void sendBatchMailWithFile(String[] emails, String subject, String text, String[] filePath)
			throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		messageHelper
				.setFrom(new InternetAddress(javax.mail.internet.MimeUtility.encodeText(mailSender.getUsername())));
		messageHelper.setSubject(subject);
		if (filePath != null) {
			BodyPart mdp = new MimeBodyPart();// 新建一个存放信件内容的BodyPart对象
			mdp.setContent(text, "text/html;charset=UTF-8");// 给BodyPart对象设置内容和格式/编码方式
			Multipart mm = new MimeMultipart();// 新建一个MimeMultipart对象用来存放BodyPart对象
			mm.addBodyPart(mdp);// 将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
			// 把mm作为消息对象的内容
			MimeBodyPart filePart;
			FileDataSource filedatasource;
			// 逐个加入附件
			for (int j = 0; j < filePath.length; j++) {
				filePart = new MimeBodyPart();
				filedatasource = new FileDataSource(filePath[j]);
				filePart.setDataHandler(new DataHandler(filedatasource));
				try {
					filePart.setFileName(javax.mail.internet.MimeUtility.encodeText(filedatasource.getName()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				mm.addBodyPart(filePart);
			}
			mimeMessage.setContent(mm);
		} else {
			messageHelper.setText(text, true);
		}

		List<InternetAddress> list = new ArrayList<InternetAddress>();// 不能使用string类型的类型，这样只能发送一个收件人
		for (int i = 0; i < emails.length; i++) {
			list.add(new InternetAddress(emails[i]));
		}
		InternetAddress[] address = list.toArray(new InternetAddress[list.size()]);

		mimeMessage.setRecipients(Message.RecipientType.TO, address);
		mimeMessage = messageHelper.getMimeMessage();

		mailSender.send(mimeMessage);
		System.out.println("发送成功");
	}

	@Test
	public void testSpringEmail() {
		EmailTest test = new EmailTest();
		// 测试发送普通文本
		test.initData("192.*****", "test@****.com", "*****");
		test.simpleMailSend("1964483239@qq.com", "测试文本", "测试能不能发邮件！！！");

		// 测试发送附件
		Map<String, String> mapAttachment = new HashMap<String, String>();
		mapAttachment.put("dnsns.jar", "E:\\zky\\dnsns.jar");
		mapAttachment.put("sunec.jar", "E:\\sunec.jar");
		try {
			test.attachedSend("1964483239@qq.com", "Hello Attachment", "This is a mail with attachment", mapAttachment);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// 测试发送富文本（html文件）
		String text = "<body><p style='color:red;'>Hello Html Email</p><img src='cid:file'/></body>";
		Map<String, String> mapHtml = new HashMap<>();
		mapHtml.put("file", "E:\\zky\\documents\\workfile\\images\\Land_Rover_Discovery_4_HSE_2016.jpg");
		try {
			test.richContentSend("1964483239@qq.com", "测试富文本", text, mapHtml);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// 测试群发多人多附件
		String[] address = {"1964483239@qq.com", "zkydrx@163.com"};
		String[] filePath = {"E:\\sunec.jar", "E:\\zky\\dnsns.jar"};
		try {
			test.sendBatchMailWithFile(address, "测试群发多文件", "实时", filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
