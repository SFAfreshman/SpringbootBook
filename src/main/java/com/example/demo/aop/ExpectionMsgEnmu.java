package com.example.demo.aop;

/**
 * Created BY DarkSheep ON 2021/7/19 16:14
 * 第九章 9.31.实现响应的枚举类
 * 枚举想相当于普通类,但是可以通过`SUCCESS` 或者` SUCCESS("200","操作成功")`快速定义静态属性
 **/
public enum ExpectionMsgEnmu {
    //相当于定义了两个静态内部类对象
    SUCCESS("200","操作成功"), FAILED("99999","操作失败");

    private String code;
    private String msg;
    ExpectionMsgEnmu(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
