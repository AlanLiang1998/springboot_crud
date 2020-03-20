package com.gdpu.springbootcrud.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Descriptin TODO
 * @Author AlanLiang
 * Date 2020/3/19 17:49
 * Version 1.0
 **/
@Data
public class Msg {
    /**
     * 状态码 200->success,400->fail
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("处理成功");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(400);
        msg.setMsg("处理失败");
        return msg;
    }

    public Msg add(String key, Object value) {
        Map<String, Object> data = this.getData();
        data.put(key, value);
        return this;
    }
}
