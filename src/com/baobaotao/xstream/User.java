package com.baobaotao.xstream;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JuqiXie on 2016/7/16.
 *
 *通过一个实例来开始Xstream的应用之旅，采用User用户对象以及LoginLog登录日志领域对象作为XStream实例转换对象。
 *
 */
public class User {

    private int userId;
    private String userName;
    private String password;
    private int credits;
    private String lastIp;
    private Date lastVisit;
    private List<LoginLog> logs = new ArrayList<>();

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void setLogs(List logs) {
        this.logs = logs;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getCredits() {
        return credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public List<LoginLog> getLogs() {
        return logs;
    }

    public void addLoginLog(LoginLog loginLog){
        this.logs.add(loginLog);
    }
}

