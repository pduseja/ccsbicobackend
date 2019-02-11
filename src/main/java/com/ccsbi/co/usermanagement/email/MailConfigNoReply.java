package com.ccsbi.co.usermanagement.email;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfigNoReply {
	
	String usernameContactUs = "noreply@ccsbi.com";

	String passwordcontactUs = "donotreply123";

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername(usernameContactUs);
		mailSender.setPassword(passwordcontactUs);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	// Code to add attachments in future
	/*
	 * MimeMessage message = emailSender.createMimeMessage();
	 * 
	 * boolean multipart = true;
	 * 
	 * MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
	 * 
	 * helper.setTo(MyConstants.FRIEND_EMAIL);
	 * helper.setSubject("Test email with attachments");
	 * 
	 * helper.setText("Hello, Im testing email with attachments!");
	 * 
	 * String path1 = "/home/tran/Downloads/test.txt"; String path2 =
	 * "/home/tran/Downloads/readme.zip";
	 * 
	 * // Attachment 1 FileSystemResource file1 = new FileSystemResource(new
	 * File(path1)); helper.addAttachment("Txt file", file1);
	 * 
	 * // Attachment 2 FileSystemResource file2 = new FileSystemResource(new
	 * File(path2)); helper.addAttachment("Readme", file2);
	 * 
	 * emailSender.send(message);
	 */


}
