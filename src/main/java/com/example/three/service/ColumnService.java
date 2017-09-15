package com.example.three.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.three.bean.entity.Column;
import com.example.three.bean.entity.UserInfo;
import com.example.three.mapper.ColumnMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/9/12.
 */
@Service
@Transactional
public class ColumnService {

	@Autowired
	private ColumnMapper columnMapper;

	public Page<Column> selectColumnPage(Page<Column> page) {

		Subject currentUser = SecurityUtils.getSubject();
		UserInfo user = (UserInfo) currentUser.getPrincipal();

		page.setRecords(columnMapper.selectColumnList(page, user.getId()));
		return page;
	}

	@Transactional(readOnly = false)
	public void saveColumn(Column column) {
		columnMapper.insert(column);
	}
}
