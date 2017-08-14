package com.example.three.service;

import com.example.three.bean.entity.SysRole;
import com.example.three.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@Service
public class SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	public List<SysRole> getSysRoleListByUserId(String userId) {
		return sysRoleMapper.getSysRoleListByUserId(userId);
	}
}
