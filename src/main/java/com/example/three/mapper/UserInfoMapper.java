package com.example.three.mapper;

import com.example.three.bean.entity.UserInfo;
import com.piaoniu.pndao.annotations.DaoGen;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/8/11.
 */
public interface UserInfoMapper {

	UserInfo findByUsername(@Param("username") String username);
}
