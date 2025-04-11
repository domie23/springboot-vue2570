package com.dao;

import com.entity.YuyuebaoyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuebaoyangView;

/**
 * 预约保养 Dao 接口
 *
 * @author 
 */
public interface YuyuebaoyangDao extends BaseMapper<YuyuebaoyangEntity> {

   List<YuyuebaoyangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
