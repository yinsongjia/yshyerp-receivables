package com.yshyerp.receivables.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.receivables.controller.common.ControllerTemplate;
import com.yshyerp.receivables.entity.Usequantity;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Usequantityservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/12/7
 * @Description:
 */
@RequestMapping("usequantity/")
@RestController
@Slf4j
public class UsequantityController implements ControllerTemplate<Usequantity> {
    @Autowired
    private Usequantityservice usequantityservice;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request request) {
        log.info("addUsequantity Response报文:{}",JSON.toJSONString(request));
        Response response=usequantityservice.addUsequantity(request);
        log.info("addUsequantity Response报文:{}",JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("deleteUsequantity 报文:{}",JSON.toJSONString(request));
        List<Integer> list=JSON.parseArray(JSON.toJSONString(request.getData()),Integer.class);
        Response response=usequantityservice.deleteUsequantity(list);
        log.info("deleteUsequantity 报文:{}",JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request request) {
        log.info("updateUsequantity Response报文:{}",JSON.toJSONString(request));
        Response response=usequantityservice.updateUsequantity(request);
        log.info("updateUsequantity Response报文:{}",JSON.toJSONString(response));
        return response;
    }



    @Override
    public Response getDropDownInit() {
        return null;
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @Override
    public Response postListInit(Request<Usequantity> request) {
        log.info("getusequantity Response报文:{}", JSON.toJSONString(request));
        Response response =usequantityservice.getusequantity(request);
        log.info("getusequantity Response报文:{}",JSON.toJSONString(response));
        return response;
    }
}
