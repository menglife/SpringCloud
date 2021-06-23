package com.zmn.springcloud.service;

import java.util.List;
import java.util.Map;

public interface TestService {
    public Object getById( Integer projectId,Integer classId, Integer pageNum,Integer pageSize);
    Map<String,Object> getMap(Integer id);
    List<Map<String, Object>> getListMap(List<Integer> ids);
}
