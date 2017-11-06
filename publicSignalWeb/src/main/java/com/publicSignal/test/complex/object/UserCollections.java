/**   
 * @Title: UserCollections.java 
 * @Package com.publicSignal.test.complex.object 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月6日 上午9:12:56  
 */
package com.publicSignal.test.complex.object;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: UserCollections 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年11月6日 上午9:12:56 
 *  
 */
public class UserCollections {

    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return this.userList;
    }

    public void setUserList(List<User> anUserList) {
        this.userList = anUserList;
    }

    @Override
    public String toString() {
        return "UserCollections [userList=" + this.userList + "]";
    }

}
