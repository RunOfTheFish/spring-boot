package com.example.three.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.three.bean.entity.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2017/9/12.
 */
@Mapper
public interface ColumnMapper extends BaseMapper<Column>{

	List<Column> selectColumnList(Pagination page, @Param("userId") Long userId);

}
