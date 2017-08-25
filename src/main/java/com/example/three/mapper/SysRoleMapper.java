package com.example.three.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.three.bean.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
public interface SysRoleMapper extends BaseMapper<SysRole>{

	List<SysRole> getSysRoleListByUserId(@Param("userId") String userId);
}
