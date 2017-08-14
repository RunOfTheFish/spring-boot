package com.example.three.service;

import com.example.three.bean.entity.UserInfo;
import com.example.three.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/8/11.
 */
@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfo findByUsername(String username) {
		return userInfoMapper.findByUsername(username);
	}
}
