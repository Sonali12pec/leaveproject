package com.example.sonaliproject.exception;

import com.example.sonaliproject.model.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice("com.example.sonaliproject")
public class GlobalControllerAdvice {


    /**
     * Exception handler for validation exception
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public GenericResponse handleException(ValidationException ex) {
        log.error("handling exception: ", ex);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setException(ex);
        genericResponse.setMessage(ex.getMessage());
        genericResponse.setStatus("FAILURE");
        return genericResponse;
    }

    /**
     * Exception handler for Any Customer Exception
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(InternalErrorException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public GenericResponse handleException(InternalErrorException ex) {
        log.error("handling exception: ", ex);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setException(ex);
        genericResponse.setMessage(ex.getMessage());
        genericResponse.setStatus("FAILURE");
        return genericResponse;
    }


    /**
     * Exception handler for Any Generic Exception
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public GenericResponse handleException(Exception ex) {
        log.error("handling exception: ", ex);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setException(ex);
        genericResponse.setMessage(ex.getMessage());
        genericResponse.setStatus("FAILURE");
        return genericResponse;
    }

}
