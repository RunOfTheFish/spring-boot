package com.example.three.bean.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@TableName("sys_role")
public class SysRole extends BaseEntity<SysRole> {

	private static final long serialVersionUID = 7794248834655993103L;
	// 角色标识程序中判断使用,如"admin",这个是唯一的:
	private String role;
	// 角色描述,UI界面显示使用
	private String description;
	// 是否可用,如果不可用将不会添加给用户
	private Boolean available = Boolean.FALSE;
	//角色 -- 权限关系：多对多关系;
	@TableField(exist = false)
	private List<SysPermission> permissions;
	// 用户 - 角色关系定义;
	@TableField(exist = false)
	private List<UserInfo> userInfos;// 一个角色对应多个用户
	@TableField(exist = false)
	private boolean checked;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
