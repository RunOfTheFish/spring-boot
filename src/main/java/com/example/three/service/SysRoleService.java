package com.example.three.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.three.bean.entity.SysRole;
import com.example.three.mapper.SysRoleMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@Service
public class SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	public List<SysRole> getSysRoleListByUserId(Long userId) {
		return sysRoleMapper.getSysRoleListByUserId(userId);
	}

	public List<SysRole> selectRoleList() {
		return sysRoleMapper.selectList(new EntityWrapper<SysRole>());
	}
}
