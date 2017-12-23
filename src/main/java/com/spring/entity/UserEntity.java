package com.spring.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * com.spring.entity
 * cj
 * 2017/12/23
 **/
@Entity
@Table(name = "user", schema = "spring", catalog = "")
public class UserEntity {
    private String userid;
    private String realname;
    private String usercol;

    @Id
    @Column(name = "userid", nullable = false, length = 50)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "realname", nullable = true, length = 200)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "usercol", nullable = true, length = 45)
    public String getUsercol() {
        return usercol;
    }

    public void setUsercol(String usercol) {
        this.usercol = usercol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userid, that.userid) &&
                Objects.equals(realname, that.realname) &&
                Objects.equals(usercol, that.usercol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid, realname, usercol);
    }
}
