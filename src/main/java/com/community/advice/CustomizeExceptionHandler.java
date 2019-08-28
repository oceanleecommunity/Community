package com.community.advice;

import com.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Com.OceanLee
 * @date 2019/8/28 22:10
 * 出现错误
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model){
        if(e instanceof CustomizeException){
            //添加默认的错误标识
            model.addAttribute("message",e.getMessage());
        }else {
            //添加默认的错误标识
            model.addAttribute("message","换个姿势再来一次吧？");
        }
        return new ModelAndView("error");
    }

}
