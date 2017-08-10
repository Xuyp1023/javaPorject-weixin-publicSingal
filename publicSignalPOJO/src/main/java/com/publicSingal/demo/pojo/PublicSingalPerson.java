package com.publicSingal.demo.pojo;

import java.io.Serializable;


/**
 * t_weixin_publicsingal_person
 * @author xuyp
 *
 */
public class PublicSingalPerson implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6670574481268422098L;

    //Id 自动增长
    private Long id;
    
    //L_OPER_ID   operid 公众号对应客户Id
    private String openid;
    
    //C_NICK_NAME 关注人昵称
    private String nickname;
    
    //C_SEX  关注人性别
    private String sex;
    
    //C_PROVINCE  关注人省份
    private String province;
    
    //C_CITY   城市
    private String city;
    
    //C_COUNTRY   国家
    private String country;
    
    //C_IMAGE_URL  关注人头像图片地址
    private String headimgurl;
    private String privilege;
    private String unionid;
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
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String anNickname) {
        this.nickname = anNickname;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String anSex) {
        this.sex = anSex;
    }
    public String getProvince() {
        return this.province;
    }
    public void setProvince(String anProvince) {
        this.province = anProvince;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String anCity) {
        this.city = anCity;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String anCountry) {
        this.country = anCountry;
    }
    public String getHeadimgurl() {
        return this.headimgurl;
    }
    public void setHeadimgurl(String anHeadimgurl) {
        this.headimgurl = anHeadimgurl;
    }
    public String getPrivilege() {
        return this.privilege;
    }
    public void setPrivilege(String anPrivilege) {
        this.privilege = anPrivilege;
    }
    public String getUnionid() {
        return this.unionid;
    }
    public void setUnionid(String anUnionid) {
        this.unionid = anUnionid;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
        result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
        result = prime * result + ((this.headimgurl == null) ? 0 : this.headimgurl.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.nickname == null) ? 0 : this.nickname.hashCode());
        result = prime * result + ((this.openid == null) ? 0 : this.openid.hashCode());
        result = prime * result + ((this.privilege == null) ? 0 : this.privilege.hashCode());
        result = prime * result + ((this.province == null) ? 0 : this.province.hashCode());
        result = prime * result + ((this.sex == null) ? 0 : this.sex.hashCode());
        result = prime * result + ((this.unionid == null) ? 0 : this.unionid.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PublicSingalPerson other = (PublicSingalPerson) obj;
        if (this.city == null) {
            if (other.city != null) return false;
        }
        else if (!this.city.equals(other.city)) return false;
        if (this.country == null) {
            if (other.country != null) return false;
        }
        else if (!this.country.equals(other.country)) return false;
        if (this.headimgurl == null) {
            if (other.headimgurl != null) return false;
        }
        else if (!this.headimgurl.equals(other.headimgurl)) return false;
        if (this.id == null) {
            if (other.id != null) return false;
        }
        else if (!this.id.equals(other.id)) return false;
        if (this.nickname == null) {
            if (other.nickname != null) return false;
        }
        else if (!this.nickname.equals(other.nickname)) return false;
        if (this.openid == null) {
            if (other.openid != null) return false;
        }
        else if (!this.openid.equals(other.openid)) return false;
        if (this.privilege == null) {
            if (other.privilege != null) return false;
        }
        else if (!this.privilege.equals(other.privilege)) return false;
        if (this.province == null) {
            if (other.province != null) return false;
        }
        else if (!this.province.equals(other.province)) return false;
        if (this.sex == null) {
            if (other.sex != null) return false;
        }
        else if (!this.sex.equals(other.sex)) return false;
        if (this.unionid == null) {
            if (other.unionid != null) return false;
        }
        else if (!this.unionid.equals(other.unionid)) return false;
        return true;
    }
    @Override
    public String toString() {
        return "PublicSingalPerson [id=" + this.id + ", openid=" + this.openid + ", nickname=" + this.nickname + ", sex=" + this.sex + ", province="
                + this.province + ", city=" + this.city + ", country=" + this.country + ", headimgurl=" + this.headimgurl + ", privilege="
                + this.privilege + ", unionid=" + this.unionid + "]";
    }

    
    
    

}
