package com.tencent;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class JavaMail {
	
	public static String myEmailAccount = "@qq.com";
	public static String myEamilPassword = "";
	public static String myEmailSMTPHost = "smtp.qq.com";
	public static String receiveMailAccount = "@qq.com";
	
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort); 
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
        props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        props.setProperty("mail.smtp.ssl.enable", "true");
        
        Session session = Session.getInstance(props);
        
        session.setDebug(true);
        
        MimeMessage message = createMimeMessage(session,myEmailAccount, receiveMailAccount);
        
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEamilPassword);
        transport.sendMessage(message, message.getAllRecipients());
        
        transport.close();
        
		
	}
	
	private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendMail,"EPM System","UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("@qq.com","Users","UTF-8")); //收件人
		message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("@qq.com","Users","UTF-8")); //抄送
		message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("@qq.com","Users","UTF-8")); //密送
		message.setSubject("Process Details", "UTF-8");
		message.setContent("The Batch finished, please check the process details.","text/html;charset=UTF-8");
		message.setSentDate(new Date());
		return message;
	}

}
