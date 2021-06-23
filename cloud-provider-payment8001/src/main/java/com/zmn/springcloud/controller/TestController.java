package com.zmn.springcloud.controller;

import com.zmn.springcloud.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping(value = "/getObjList")
    @ApiOperation(value = "分页查询列表")
    public  Object getById(@RequestParam(defaultValue = "1") Integer projectId,@RequestParam Integer classId,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize){
        testService.getMap(projectId);
        return testService.getById(projectId,classId,pageNum,pageSize);
    }
    @RequestMapping(value = "/getMap")
    public Map<String, Object> getMap(@RequestParam("id") Integer id){
        Map<String, Object> map=testService.getMap(id);
        return  map;  //返回类型前端自动转json
    }
    @RequestMapping(value = "/getListMap",method = RequestMethod.POST)
    public List<Map<String, Object>> getMap(@RequestBody List<Integer> ids){
        List<Map<String, Object>> mapList=testService.getListMap(ids);
        System.out.println(mapList);
            return  mapList;  //返回类型集合中包对象
    }
}
