package member.model.vo;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailSend {
	public String mailSend(String email) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i < 6 ; ++i) {
			sb.append(r.nextInt(10));
			sb.append('\n');
		}
		System.out.println("랜덤코드 : "+sb.toString());
//		메일전송코드
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("bext007@gmail.com","");
			}
			
		});
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSendData(new Data());
			msg.setFrom(new InternetAddress("bext007@gmail.com","이윤수"));
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(message., address);
		} 
		return sb.toString();
	}
}
