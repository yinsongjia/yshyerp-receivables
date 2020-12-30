package com.yshyerp.receivables.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.receivables.controller.common.ControllerTemplate;
import com.yshyerp.receivables.entity.vw_receivables;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Vwreceivablesservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Administrator
 * @Data: 2020/12/7
 * @Description:
 */
@RequestMapping("vwreceivables/")
@RestController
@Slf4j
public class VwreceivablesController implements ControllerTemplate<vw_receivables> {
    @Autowired
    private Vwreceivablesservice vwreceivablesservice;
    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<vw_receivables> request) {
        return null;
    }

    @Override
    public Response delete(Request request) {
        return null;
    }

    @Override
    public Response updatePut(Request<vw_receivables> request) {
        return null;
    }

    @Override
    public Response getDropDownInit() {
        return null;
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @GetMapping("getVwreceivablesById/{id}")
    public  Response getVwreceivablesById(@PathVariable Integer id){
        return vwreceivablesservice.getVwreceivablesById(id);
    }
    @Override
    public Response postListInit(Request<vw_receivables> request) {
        log.info("getVwreceivables Response报文:{}", JSON.toJSONString(request));
        Response response=vwreceivablesservice.getVwreceivables(request);
        log.info("getVwreceivables Response报文:{}",JSON.toJSONString(response));
        return response;
    }
}
