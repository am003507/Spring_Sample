package com.maven.test.Controller;

        import com.maven.test.util.BaseException;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ControllerAdvice;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.ResponseStatus;
        import org.springframework.web.bind.annotation.RestController;
@ControllerAdvice
@RestController
public class globalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class)
    public String handleBaseException(BaseException e){
        return e.getMessage();
    }
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){return e.getMessage();}

}
