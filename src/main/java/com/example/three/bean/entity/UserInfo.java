package com.example.three.bean.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@TableName("user_info")
public class UserInfo extends BaseEntity<UserInfo> {

	private static final long serialVersionUID = -6435149180607492235L;
	//帐号
	@TableField("user_name")
	private String username;
	//名称（昵称或者真实姓名，不同系统不同定义）
	private String name;
	//头像
	@TableField("head_img")
	private String headImg;
	//密码;
	@TableField("pass_word")
	private String password;
	//加密密码的盐
	private String salt;
	//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
	private byte state;
	// 一个用户具有多个角色
	@TableField(exist = false)
	private List<SysRole> roleList;
	@TableField(exist = false)
	private List<String> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	/**
	 * 密码盐.
	 *
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.username + this.salt;
	}

}
