package com.smart.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by 占大帅 on 2017/7/8.
 */

/**
 * 用户
 */
public class User {
    private int id;
    private String username;
    private String password;
    private boolean isDelete;
    private Date createDate;
    List<Role> userRoles;

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDelete() {

        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String toString(){
        return "["+id+","+username+","+password+"]";
    }
}
