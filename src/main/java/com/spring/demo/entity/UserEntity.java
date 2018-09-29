package com.spring.demo.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * com.spring.entity
 *
 * @author chengjian
 * 2017/12/23
 **/
@Entity
@Table(name = "user")
@XmlRootElement(name = "user")
@XmlType(propOrder = {"userid", "username", "userpwd", "realname"})
public class UserEntity implements Serializable {


    private String userid;
    private String username;
    private String userpwd;
    private String realname;

    public static final String USERENTITY_KEY = "UserEntity";

    @Id
    @Column(name = "userid", nullable = false, length = 50)
    @XmlElement(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    @XmlElement(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpwd", nullable = false, length = 50)
    @XmlElement(name = "userpwd")
    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Basic
    @Column(name = "realname", nullable = true, length = 200)
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
