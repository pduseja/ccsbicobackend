package com.ccsbi.co.usermanagement.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailConfigContactUs mailConfigContactUs;

		
	@Override
	public void sendRegistrationMail(String to, String subject, String text) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setFrom("noreply@ccsbi.com");
        
        javaMailSender.send(mailMessage);

	}

	
	@Override
	public void sendMailRegistrationActivation(String to, String subject, String text) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setFrom("noreply@ccsbi.com");
        javaMailSender.send(mailMessage);		
	}

	@Override
	public void sendMailIMessage(String to, String subject, String text) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setFrom("contactus@ccsbi.com");
        mailConfigContactUs.getJavaMailSender().send(mailMessage);
	}

}
