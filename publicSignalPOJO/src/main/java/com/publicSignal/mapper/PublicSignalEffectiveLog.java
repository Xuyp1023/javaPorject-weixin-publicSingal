package com.publicSignal.mapper;

import java.io.Serializable;

public class PublicSignalEffectiveLog implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 7142979436374485743L;

    //主键Id
    private Long id;
    
    //微信传递的operid
    private String openid;
    
    //是否已经授权  0 未授权  1已经授权
    private String businStatus;
    
    //从微信获取到用户的详细信息Id
    private Long persionId;
    
    //记录微信公众号Id
    private String appid;

    public Long getId() {
        return this.id;
    }

    public void setId(Long anId) {
        this.id = anId;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String anOpenid) {
        this.openid = anOpenid;
    }

    public String getBusinStatus() {
        return this.businStatus;
    }

    public void setBusinStatus(String anBusinStatus) {
        this.businStatus = anBusinStatus;
    }

    public Long getPersionId() {
        return this.persionId;
    }

    public void setPersionId(Long anPersionId) {
        this.persionId = anPersionId;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String anAppid) {
        this.appid = anAppid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.appid == null) ? 0 : this.appid.hashCode());
        result = prime * result + ((this.businStatus == null) ? 0 : this.businStatus.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.openid == null) ? 0 : this.openid.hashCode());
        result = prime * result + ((this.persionId == null) ? 0 : this.persionId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PublicSignalEffectiveLog other = (PublicSignalEffectiveLog) obj;
        if (this.appid == null) {
            if (other.appid != null) return false;
        }
        else if (!this.appid.equals(other.appid)) return false;
        if (this.businStatus == null) {
            if (other.businStatus != null) return false;
        }
        else if (!this.businStatus.equals(other.businStatus)) return false;
        if (this.id == null) {
            if (other.id != null) return false;
        }
        else if (!this.id.equals(other.id)) return false;
        if (this.openid == null) {
            if (other.openid != null) return false;
        }
        else if (!this.openid.equals(other.openid)) return false;
        if (this.persionId == null) {
            if (other.persionId != null) return false;
        }
        else if (!this.persionId.equals(other.persionId)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PublicSignalEffectiveLog [id=" + this.id + ", openid=" + this.openid + ", businStatus=" + this.businStatus + ", persionId="
                + this.persionId + ", appid=" + this.appid + "]";
    }
    
    

}
