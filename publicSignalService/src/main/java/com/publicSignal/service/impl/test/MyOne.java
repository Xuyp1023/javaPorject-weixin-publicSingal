package com.publicSignal.service.impl.test;

import org.springframework.stereotype.Service;

@Service
public class MyOne {
    
    private String userName;
    private int age;
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String anUserName) {
        this.userName = anUserName;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int anAge) {
        this.age = anAge;
    }
    @Override
    public String toString() {
        return "MyOne [userName=" + this.userName + ", age=" + this.age + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.age;
        result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MyOne other = (MyOne) obj;
        if (this.age != other.age) return false;
        if (this.userName == null) {
            if (other.userName != null) return false;
        }
        else if (!this.userName.equals(other.userName)) return false;
        return true;
    }
    
    

}
