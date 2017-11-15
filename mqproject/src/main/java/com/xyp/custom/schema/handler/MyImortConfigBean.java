package com.xyp.custom.schema.handler;

import java.io.Serializable;

public class MyImortConfigBean implements Serializable {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;
    private String resource;
    private String profile;
    private String encord;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEncord() {
        return encord;
    }

    public void setEncord(String encord) {
        this.encord = encord;
    }

    @Override
    public String toString() {
        return "MyImortConfigBean [resource=" + resource + ", profile=" + profile + ", encord=" + encord + "]";
    }

}
