package com.example.three.util;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.example.three.bean.entity.UserInfo;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by admin on 2017/8/29.
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

	/**
	 * 测试 user 表 name 字段为空自动填充
	 */
	@Override
	public void insertFill(MetaObject metaObject) {

		Subject currentUser = SecurityUtils.getSubject();
		UserInfo user = (UserInfo) currentUser.getPrincipal();

		Object createBy = metaObject.getValue("createBy");
		Object createTime = metaObject.getValue("createTime");
		Object flag = metaObject.getValue("flag");

		if (createBy == null) {
			if(user == null) {
				metaObject.setValue("createBy", "api");
			}else {
				metaObject.setValue("createBy", String.valueOf(user.getId()));
			}
		}
		if (createTime == null) {
			metaObject.setValue("createTime", new Date());
		}
		if (flag == null) {
			metaObject.setValue("flag", 1);
		}

	}

	@Override
	public void updateFill(MetaObject metaObject) {

		Subject currentUser = SecurityUtils.getSubject();
		UserInfo user = (UserInfo) currentUser.getPrincipal();

		if(user == null) {
			metaObject.setValue("updateBy", "api");
		}else {
			metaObject.setValue("updateBy", String.valueOf(user.getId()));
		}

		metaObject.setValue("updateTime", new Date());
	}

}
