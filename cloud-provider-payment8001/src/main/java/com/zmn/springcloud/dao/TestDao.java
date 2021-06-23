package com.zmn.springcloud.dao;

import com.zmn.springcloud.entities.Test;
import com.zmn.springcloud.entities.TitleBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {
    public Test getProjectById(@Param("projectId") Integer projectId);
    public Test getById(@Param("projectId") Integer projectId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<TitleBean> getItemListById(Integer projectId);
    Map<String,Object> getMap(Integer id);
    List<Map<String, Object>> getListMap(List<Integer> ids);
}
