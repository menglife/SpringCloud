package com.zmn.springcloud.service.impl;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.zmn.springcloud.CodeEnum;
import com.zmn.springcloud.dao.TestDao;
import com.zmn.springcloud.entities.Payment;
import com.zmn.springcloud.entities.Test;
import com.zmn.springcloud.entities.TitleBean;
import com.zmn.springcloud.exception.BusinessException;
import com.zmn.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl  implements TestService {
    @Autowired
    TestDao testDao;

    @Override
    public Object getById(Integer projectId,Integer classId ,Integer pageNum, Integer pageSize) {
        Test test=testDao.getProjectById(projectId);
        if (test == null){
            throw new BusinessException(CodeEnum.FAIL.getValue(),"工程不存在");
        }
        //表头
        JSONObject result = new JSONObject();
        JSONArray titles = new JSONArray();
        JSONObject title = null;
//        result.put("title",title);
        switch (test.getProjectId()){
            case 1:
                List<TitleBean> titleBeanList = testDao.getItemListById(test.getProjectId());
                title = new JSONObject();
                title.put("title","发生时间");
                titles.add(title);
                title = new JSONObject();
                for (TitleBean titleBean:titleBeanList){
                    title.put("item",titleBean.getItemName());

                }
                titles.add(title);
        }
        return result;
    }

    @Override
    public Map<String, Object> getMap(Integer id) {
        Map<String, Object> map=testDao.getMap(id);
        Long idL = 0L;
        //逻辑从数据库获取数据要进行null判定
        if(map != null){
            //属性判断
            if (map.get("id") != null){
                String idStr = map.get("id").toString();
                    idL = Long.valueOf(idStr);


            }

        }
        return map;
    }

    @Override
    public List<Map<String, Object>> getListMap(List<Integer> ids) {
        return testDao.getListMap(ids);
    }
    public List<Payment> getPage(Integer pageSize,Integer pageNumber,String searchKey){

        return  null;

    }


}
