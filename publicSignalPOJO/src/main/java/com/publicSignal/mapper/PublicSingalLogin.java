package com.publicSignal.mapper;

import java.io.Serializable;

/**
 * 
 * t_weixin_publicsingal_login
 * @author xuyp
 *
 */
public class PublicSingalLogin implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8838140597363841290L;

    
    // ID Id只增长  
    private Long id;
    
    //公众号Id
    private String appid;
    
    //个人Id
    private String openid;
    
    //注册日期
    private String regDate;
    
    //注册时间
    private String regTime;

    public Long getId() {
        return this.id;
    }

    public void setId(Long anId) {
        this.id = anId;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String anAppid) {
        this.appid = anAppid;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String anOpenid) {
        this.openid = anOpenid;
    }

    public String getRegDate() {
        return this.regDate;
    }

    public void setRegDate(String anRegDate) {
        this.regDate = anRegDate;
    }

    public String getRegTime() {
        return this.regTime;
    }

    public void setRegTime(String anRegTime) {
        this.regTime = anRegTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.appid == null) ? 0 : this.appid.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.openid == null) ? 0 : this.openid.hashCode());
        result = prime * result + ((this.regDate == null) ? 0 : this.regDate.hashCode());
        result = prime * result + ((this.regTime == null) ? 0 : this.regTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PublicSingalLogin other = (PublicSingalLogin) obj;
        if (this.appid == null) {
            if (other.appid != null) return false;
        }
        else if (!this.appid.equals(other.appid)) return false;
        if (this.id == null) {
            if (other.id != null) return false;
        }
        else if (!this.id.equals(other.id)) return false;
        if (this.openid == null) {
            if (other.openid != null) return false;
        }
        else if (!this.openid.equals(other.openid)) return false;
        if (this.regDate == null) {
            if (other.regDate != null) return false;
        }
        else if (!this.regDate.equals(other.regDate)) return false;
        if (this.regTime == null) {
            if (other.regTime != null) return false;
        }
        else if (!this.regTime.equals(other.regTime)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PublicSingalLogin [id=" + this.id + ", appid=" + this.appid + ", openid=" + this.openid + ", regDate=" + this.regDate + ", regTime="
                + this.regTime + "]";
    }
    
   
    
}
