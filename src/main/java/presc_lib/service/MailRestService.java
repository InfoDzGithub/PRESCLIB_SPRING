package presc_lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.metier.*;

@RestController
public class MailRestService {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/sendMail",method = RequestMethod.POST)
	public void send(@RequestParam(name="email")  String DistinationEmail) throws Exception {
		mailService.send(DistinationEmail, "bouchekiflatifa13@gmail.com", "Recuperation de mot de passe oublier", "heeeyyyyy");
	}
}
