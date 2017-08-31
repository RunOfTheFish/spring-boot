package com.example.three.bean.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/31.
 */
@TableName("sys_user_role")
public class SysUserRole implements Serializable{

	private static final long serialVersionUID = 9199929583360081801L;

	@TableField("role_id")
	private String roleId;

	@TableField("user_id")
	private String userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
