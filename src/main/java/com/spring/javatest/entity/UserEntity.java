package com.spring.javatest.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Objects;

/**
 * com.spring.entity
 * @author chengjian
 * 2017/12/23
 **/
@XmlRootElement(name = "user")
@XmlType(propOrder = {"userid","username","userpwd","realname"})
public class UserEntity implements Serializable {
    private String userid;
    private String username;
    private String userpwd;
    private String realname;

    @XmlElement(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @XmlElement(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement(name = "userpwd")
    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @XmlElement(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userid, that.userid) &&
                Objects.equals(username, that.username) &&
                Objects.equals(userpwd, that.userpwd) &&
                Objects.equals(realname, that.realname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid, username, userpwd, realname);
    }
}
