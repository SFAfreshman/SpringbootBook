package com.example.demo.aop;

import lombok.Data;

/**
 * Created BY DarkSheep ON 2021/7/19 16:24
 * 把返回的结果进行封装
 **/
@Data
public class RespData extends Resp {
    //新增了data对象的定义
    private Object data;

    public RespData(ExpectionMsgEnmu msg, Object data) {
        super(msg);
        this.data = data;
    }

    public RespData(String rspCode, Object data) {
        super(rspCode);
        this.data = data;
    }

    public RespData(String rspCode, String rspMsg, Object data) {
        super(rspCode, rspMsg);
        this.data = data;
    }

    public RespData(Object data) {
        this.data = data;
    }
    public RespData()
    {

    }

    public RespData(ExpectionMsgEnmu msg) {
        super(msg);
    }

    public RespData(String rspCode) {
        super(rspCode);
    }

    public RespData(String rspCode, String rspMsg) {
        super(rspCode, rspMsg);
    }
    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                "} " + super.toString();
    }
}
