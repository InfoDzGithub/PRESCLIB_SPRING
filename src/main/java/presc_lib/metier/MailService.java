package presc_lib.metier;

public interface MailService {
   public void send(String toAddress, String fromAddress, String subject, String content) throws Exception;
}
