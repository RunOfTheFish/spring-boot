package com.example.three.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.three.bean.entity.SysRole;
import com.example.three.bean.entity.SysUserRole;
import com.example.three.bean.entity.UserInfo;
import com.example.three.mapper.SysRoleMapper;
import com.example.three.mapper.SysUserRoleMapper;
import com.example.three.mapper.UserInfoMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@Service
@Transactional
public class UserInfoService {

	@Resource
	private UserInfoMapper userInfoMapper;
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;
	@Resource
	private SysRoleMapper sysRoleMapper;

	public UserInfo findByUsername(String username) {
		return userInfoMapper.findByUsername(username);
	}

	public Page<UserInfo> selectUserPage(Page<UserInfo> page) {

		page.setRecords(userInfoMapper.selectUserList(page));
		return page;
	}

	@Transactional(readOnly = false)
	public void insertUser(UserInfo userInfo) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = secureRandomNumberGenerator.nextBytes().toHex();
		String password_cipherText = new Md5Hash(userInfo.getPassword(), userInfo.getUsername() + salt, 2).toHex();
		userInfo.setPassword(password_cipherText);
		userInfo.setSalt(salt);
		userInfoMapper.insert(userInfo);

		for (String roleId : userInfo.getRoles()) {
			int relation = sysUserRoleMapper.selectCount(new EntityWrapper<SysUserRole>().eq("role_id", roleId)
					.eq("user_id", userInfo.getId()));

			if (relation == 0) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setRoleId(roleId);
				sysUserRole.setUserId(String.valueOf(userInfo.getId()));
				sysUserRoleMapper.insert(sysUserRole);
			}
		}
	}

	public UserInfo userInfoRevise(long id) {

		UserInfo user = userInfoMapper.selectById(id);
		List<SysRole> roles = sysRoleMapper.getSysRoleListByUserId(id);
		user.setRoleList(roles);

		return user;
	}

	@Transactional(readOnly = false)
	public void reviseUser(UserInfo userInfo) {

		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = secureRandomNumberGenerator.nextBytes().toHex();
		String password_cipherText = new Md5Hash(userInfo.getPassword(), userInfo.getUsername() + salt, 2).toHex();
		userInfo.setPassword(password_cipherText);
		userInfo.setSalt(salt);
		userInfoMapper.updateById(userInfo);

		sysUserRoleMapper.delete(new EntityWrapper<SysUserRole>().eq("user_id", userInfo.getId()));

		for (String roleId : userInfo.getRoles()) {
			int relation = sysUserRoleMapper.selectCount(new EntityWrapper<SysUserRole>().eq("role_id", roleId)
					.eq("user_id", userInfo.getId()));

			if (relation == 0) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setRoleId(roleId);
				sysUserRole.setUserId(String.valueOf(userInfo.getId()));
				sysUserRoleMapper.insert(sysUserRole);
			}
		}
	}

}
