package presc_lib.metier;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImp implements MailService{
 
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public void send(String toAddress, String fromAddress, String subject, String content) throws Exception{
		MimeMessage mimemessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimemessage,true);
	
        helper.setSubject(subject);
		helper.setTo(toAddress);
		helper.setFrom(fromAddress);
		helper.setText(content);
		helper.setSentDate(new Date());
		javaMailSender.send(mimemessage);
	
	
	}

}
