package capstone.elibraries.controllers;

import capstone.elibraries.error.ValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ValidationException.class)
    public ModelAndView validationExceptionResponse(ValidationException e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", e);
        mav.setViewName("error/validation");
        return mav;
    }
}
