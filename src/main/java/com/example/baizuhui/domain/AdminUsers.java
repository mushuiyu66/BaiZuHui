package com.example.baizuhui.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 后台系统用户表
 * @TableName admin_users
 */
@TableName(value ="admin_users")
public class AdminUsers implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long adminid;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 密码(加密存储)
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getAdminid() {
        return adminid;
    }

    /**
     * 
     */
    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    /**
     * 登录账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码(加密存储)
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码(加密存储)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminUsers other = (AdminUsers) that;
        return (this.getAdminid() == null ? other.getAdminid() == null : this.getAdminid().equals(other.getAdminid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminid() == null) ? 0 : getAdminid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminid=").append(adminid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}