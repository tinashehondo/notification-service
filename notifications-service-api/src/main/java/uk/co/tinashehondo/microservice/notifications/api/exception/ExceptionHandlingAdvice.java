package uk.co.tinashehondo.microservice.notifications.api.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@ControllerAdvice
@Slf4j
public class ExceptionHandlingAdvice extends ResponseEntityExceptionHandler {

}
