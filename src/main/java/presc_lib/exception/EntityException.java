package presc_lib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityException extends Exception
{
   public EntityException(String msg)
   {
	   super(msg);
   }
}
