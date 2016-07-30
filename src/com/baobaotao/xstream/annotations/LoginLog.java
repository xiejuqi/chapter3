package com.baobaotao.xstream.annotations;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Date;

/**
 * Created by JuqiXie on 2016/7/16.
 *  日志对象，用于测试XStream
 */

@XStreamAlias("log")
public class LoginLog {

    @XStreamAlias("logId")
    private int loginLogId;

    @XStreamAlias("userId")
    private int userId;

    @XStreamAlias("ip")
    private String ip;

    @XStreamAlias("loginDate")
    private Date loginDate;

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getLoginLogId() {
        return loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public String getIp() {
        return ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }
}
