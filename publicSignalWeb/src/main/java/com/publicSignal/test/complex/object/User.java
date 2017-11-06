/**   
 * @Title: User.java 
 * @Package com.publicSignal.test.complex.object 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月6日 上午9:11:34  
 */
package com.publicSignal.test.complex.object;

/** 
 * @ClassName: User 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年11月6日 上午9:11:34 
 *  
 */
public class User {

    private String username;

    private String passwd;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String anUsername) {
        this.username = anUsername;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String anPasswd) {
        this.passwd = anPasswd;
    }

    @Override
    public String toString() {
        return "User [username=" + this.username + ", passwd=" + this.passwd + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.passwd == null) ? 0 : this.passwd.hashCode());
        result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (this.passwd == null) {
            if (other.passwd != null) {
                return false;
            }
        } else if (!this.passwd.equals(other.passwd)) {
            return false;
        }
        if (this.username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!this.username.equals(other.username)) {
            return false;
        }
        return true;
    }

}
