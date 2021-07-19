package com.example.demo.aop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created BY DarkSheep ON 2021/7/19 16:21
 * 返回的对象实体类 返回code和Msg
 **/
@Getter
@Setter
public class Resp {
    private String rspCode="200";
    private String rspMsg="操作成功";

    @Override
    public String toString() {
        return "Response{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                '}';
    }
    public Resp(ExpectionMsgEnmu msg){
        this.rspCode=msg.getCode();
        this.rspMsg=msg.getMsg();
    }

    public Resp(String rspCode) {
        this.rspCode = rspCode;
        this.rspMsg = "";
    }

    public Resp(String rspCode, String rspMsg) {
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }

    public Resp() {
    }
}
