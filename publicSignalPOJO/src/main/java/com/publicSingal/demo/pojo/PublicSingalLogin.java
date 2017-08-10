package com.publicSingal.demo.pojo;

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

    /**
     * CREATE TABLE `t_weixin_publicsingal_login` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Id只增长',
  `C_APP_ID` varchar(100) DEFAULT NULL COMMENT '公众号Id',
  `L_OPER_ID` varchar(100) DEFAULT NULL COMMENT '个人Id',
  `D_REG_DATE` char(8) DEFAULT NULL COMMENT '注册日期',
  `T_REG_TIME` char(6) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

     * 
     */
    
    // ID Id只增长  
    private Long id;
    private String appid;
    private String openid;
    private String regDate;
    private String regTime;
    
   
    
}
