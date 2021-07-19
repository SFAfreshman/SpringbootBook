package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created BY DarkSheep ON 2021/7/19 16:27
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHanlder {
    /*
    * 400 -BadRequest
    * 缺少参数错误
    * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map<String,Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e)
    {
        log.error("缺少请求参数",e);
        Map<String,Object> map=new HashMap<>();
        map.put("rspCode",400);
        map.put("rspMsg",e.getMessage());
        //发生异常进行日志记录或者计入数据库,此处省略
        return map;//RestController直接return map;
    }
    /*
     * 400 -BadRequest
     * 参数解析失败
     * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e)
    {
        log.error("参数解析失败",e);
        Map<String,Object> map=new HashMap<>();
        map.put("rspCode",400);
        map.put("rspMsg",e.getMessage());

        return map;//RestController直接return map;
    }
    //其余同理
    /*自定义异常类*/
   /* @ResponseBody
    @ExceptionHandler(自定义的业务异常)*/
}
