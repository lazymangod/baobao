package com.example.doman;

/**
 * Created by lazygod on 2016/8/7.
 */
public class Vote {
    private Integer zid;//参与宝宝报名ID
    private String name;
    private Integer userId;//投票人userId
    private String openId;//微信公众号openId
    private String ip;//投票人ip地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String Time;//投票时间

    public Vote() {
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "zid=" + zid +
                ", userId=" + userId +
                ", openId='" + openId + '\'' +
                ", ip='" + ip + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
