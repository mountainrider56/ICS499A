package com.shrew.consulting.eagleeye.msp.customer.service.exception.handling

import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import spock.lang.Specification

class GlobalExceptionHandlingSpec extends Specification {

    def 'handleValidationExceptions'() {
        setup:
        GlobalExceptionHandling globalExceptionHandling = new GlobalExceptionHandling()
        MethodArgumentNotValidException methodArgumentNotValidExceptionMock = Mock()
        BindingResult bindingResultMock = Mock()
        FieldError fieldError = new FieldError('test', 'test', 'test has error')
        List<ObjectError> errors = [fieldError]
        Map<String, String> expected = ['test': 'test has error']

        when:
        Map<String, String> result = globalExceptionHandling.handleValidationExceptions(methodArgumentNotValidExceptionMock)

        then:
        1 * methodArgumentNotValidExceptionMock.getBindingResult() >> bindingResultMock
        1 * bindingResultMock.getAllErrors() >> errors
        result == expected
    }

}
