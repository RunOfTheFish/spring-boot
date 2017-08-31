package com.example.three.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.three.bean.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

	UserInfo findByUsername(@Param("username") String username);

	List<UserInfo> selectUserList(Pagination page);
}
