package io.github.gefangshuai.constant;

import com.google.gson.Gson;

/**
 * Created by gefangshuai on 2015/11/10.
 */
public class ResultCode {
    public static ResultCode OK = new ResultCode(200,"OK");                   // 成功
    public static ResultCode Forbidden = new ResultCode (403, "Forbidden");    // 禁止
    public static ResultCode Faild = new ResultCode(400, "Bad request");      // 失败

    private int code;
    private String desc;

    private ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
