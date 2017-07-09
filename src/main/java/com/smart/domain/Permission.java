package com.smart.domain;

/**
 * Created by 占大帅 on 2017/7/8.
 */

/**
 * 权限表
 */
public class Permission {
    private int id;
    private String token;
    private String theurl;
    private String description;
    private int roleId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTheurl() {

        return theurl;
    }

    public void setTheurl(String theurl) {
        this.theurl = theurl;
    }

    public int getRoleId() {

        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toString(){
        return "["+id+","+theurl+"]";
    }
}
