package com.example.three.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.three.bean.entity.Impower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImpowerMapper extends BaseMapper<Impower> {

    List<Impower> selectPage(Pagination page);

}
