package pl.dkaluza.spring_validation;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@RestControllerAdvice
class GreetingControllerAdvice extends DefaultHandlerExceptionResolver {
}
