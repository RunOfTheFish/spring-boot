package com.example.three.service;

import com.example.three.bean.entity.SysPermission;
import com.example.three.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@Service
public class SysPermissionService {

	@Autowired
	private SysPermissionMapper sysPermissionMapper;

	public List<SysPermission> getSysPermissionListByRoleId(String roleId) {
		return sysPermissionMapper.getSysPermissionListByRoleId(roleId);
	}

}
