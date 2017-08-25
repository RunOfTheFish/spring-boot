package com.example.three.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.three.bean.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

	List<SysPermission> getSysPermissionListByRoleId(@Param("roleId") String roleId);
}
