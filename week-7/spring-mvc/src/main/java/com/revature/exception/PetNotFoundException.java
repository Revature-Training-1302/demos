package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// whenever this exception is thrown, we will return this response status with this reason
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pet with id does not exist.")
public class PetNotFoundException extends Exception{
}
