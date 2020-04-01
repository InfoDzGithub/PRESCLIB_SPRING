package presc_lib.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.metier.SmtpMailSender;

@RestController
public class RootController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/send-mail")
	public void sendMail() throws MessagingException {
		
		smtpMailSender.send("bouchekiflatifa13@gmail.com", "Test mail from Spring", "Howdy");
		
	}
	

}
