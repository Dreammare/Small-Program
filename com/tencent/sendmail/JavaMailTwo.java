import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailTwo {
	public static void main(String [] args) throws Exception {

	    String host = "smtp.qq.com";
	    String password = "";
	    String from = "@qq.com";
	    String to = "@qq.com";
	    String cc = "@qq.com";
	    String nickname = "System";
	    
	    String subject = "Process Details";
	    String content = "The Batch finished, please check the process details.";
	    String character = "text/html;charset=UTF-8";
	    
	    String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	    
	      Properties prop = new Properties();
	      prop.setProperty("mail.smtp.host", host);
	      prop.put("mail.smtp.port", 465); 
	      prop.put("mail.smtp.ssl.enable", true);  //boolean isSSL
	      prop.put("mail.smtp.auth", true);
	      prop.put("mail.transport.protocol", "smtp");
	      prop.put("mail.smtp.socketFactory.class", SSL_FACTORY);
	      prop.put("mail.smtp.socketFactory.fallback", false); 
	      
	      
	      Session session = Session.getInstance(prop);
	      session.setDebug(true);
	      MimeMessage message = new MimeMessage(session);
	   try {
	      message.setFrom(new InternetAddress(from,nickname,"UTF-8"));
		  //message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to,"Users","UTF-8")); //收件人
		  //message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(cc,"Users","UTF-8")); //抄送
		  message.setRecipients(MimeMessage.RecipientType.TO, "@qq.com,@qq.com");
		  message.setSubject(subject, "UTF-8");
		  message.setContent(content,character);
		  message.setSentDate(new Date());
			
	      Transport transport = session.getTransport();
	      transport.connect(from, password);
	      transport.sendMessage(message, message.getAllRecipients());
	        
	      transport.close();
	   } catch (MessagingException mex) {
		   mex.printStackTrace();
	   } catch (UnsupportedEncodingException ue) {
		ue.printStackTrace();
	   }
	}
}
