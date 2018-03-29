package com.zzq.exception;

import com.zzq.entity.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzq
 * @createTime 2018/3/26
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {
    //@ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        e.printStackTrace();
        return JsonResult.errorTokenMsg(e.getMessage());
    }
}
