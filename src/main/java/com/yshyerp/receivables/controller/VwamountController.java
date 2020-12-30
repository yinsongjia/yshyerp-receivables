package com.yshyerp.receivables.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yshyerp.receivables.controller.common.ControllerTemplate;
import com.yshyerp.receivables.entity.vw_amount;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Vwamoutservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Administrator
 * @Data: 2020/12/3
 * @Description:
 */
@RequestMapping("vwamount/")
@RestController
@Slf4j
public class VwamountController implements ControllerTemplate<vw_amount> {
    @Autowired
    private Vwamoutservice vwamoutservice;
    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<vw_amount> request) {
        return null;
    }

    @Override
    public Response delete(Request request) {
        return null;
    }

    @Override
    public Response updatePut(Request<vw_amount> request) {
        return null;
    }

    @Override
    public Response getDropDownInit() {
        return vwamoutservice.query();
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @PostMapping("/getbyName")
    public Object getbyName(@RequestBody JSONObject jsonParam) {
        String name = jsonParam.get("name").toString();
        return vwamoutservice.getbyName(name);
    }
    @GetMapping("getBycontracti/{contracti}")
    public  Response getBycontracti(@PathVariable String contracti){
        return  vwamoutservice.getBycontracti(contracti);
    }
    //@PathVariable  接收请求路径中占位符的值
    @GetMapping("getVwamountById/{id}")
    public Response getVwamountById(@PathVariable Integer id){
        return  vwamoutservice.getVwamountById(id);
    }
    @Override
    public Response postListInit(Request<vw_amount> request) {
        log.info("getVwamount Response报文:{}", JSON.toJSONString(request));
        Response response=vwamoutservice.getVwamount(request);
        log.info("getVwamount Response报文:{}",JSON.toJSONString(response));
        return response;
    }
}
