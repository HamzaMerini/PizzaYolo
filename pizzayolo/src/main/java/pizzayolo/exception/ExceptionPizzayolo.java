package pizzayolo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ExceptionPizzayolo extends RuntimeException{

	public ExceptionPizzayolo() {
		
	}

}
