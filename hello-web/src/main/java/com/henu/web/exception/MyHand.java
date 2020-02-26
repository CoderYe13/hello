package com.henu.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class MyHand {
    public MyHand() {
        System.out.println("MyHand初始化了");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handles(Exception e){
        System.out.println("MyHand处理了");
        ModelAndView modelAndView=new ModelAndView("myerror");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }
}
