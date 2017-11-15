package com.xyp.custom.schema.handler;

import java.io.Serializable;

public class MyBeanConfigBean implements Serializable {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;
    private String cla;
    private String name;
    private String id;
    private String scope;

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "MyBeanConfigBean [cla=" + cla + ", name=" + name + ", id=" + id + ", scope=" + scope + "]";
    }

}
