package com.example.three.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.three.bean.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/8/11.
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

	UserInfo findByUsername(@Param("username") String username);
}
