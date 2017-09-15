package com.example.three.bean.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * Created by admin on 2017/9/12.
 */
@TableName("cms_column")
public class Column extends BaseEntity<Column>{
	private static final long serialVersionUID = 2979140401104430918L;

	private String name;
	private String type;
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
