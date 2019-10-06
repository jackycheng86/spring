package com.spring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserEntity {
    private String id;
    private String loginId;
    private String loginPwd;
    private String userName;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    @Basic
    @Column(name = "loginId", nullable = false, length = 50)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "loginPwd", nullable = false, length = 20)
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserName() {
        return userName;
    }

    @Basic
    @Column(name = "userName", length = 100)
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getLoginId(), that.getLoginId()) &&
                Objects.equals(getLoginPwd(), that.getLoginPwd()) &&
                Objects.equals(getUserName(), that.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLoginId(), getLoginPwd(), getUserName());
    }
}
