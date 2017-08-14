package com.example.three.mapper;

import com.example.three.bean.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
public interface SysRoleMapper {

	List<SysRole> getSysRoleListByUserId(@Param("userId") String userId);
}
