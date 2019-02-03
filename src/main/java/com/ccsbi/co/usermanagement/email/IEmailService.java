package com.ccsbi.co.usermanagement.email;

public interface IEmailService {

	void sendRegistrationMail(String to, String subject, String text);
	
	void sendMailRegistrationActivation(String to, String subject, String text);

	void sendMailIMessage(String to, String subject, String text);

}
