package com.yshyerp.receivables.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.receivables.controller.common.ControllerTemplate;
import com.yshyerp.receivables.entity.Amount;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Amountservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Administrator
 * @Data: 2020/12/4
 * @Description:
 */
@RequestMapping("amount/")
@RestController
@Slf4j
public class AmountController implements ControllerTemplate<Amount> {
    @Autowired
    private Amountservice amountservice;
    @Override
    public Response getDetail(String request) {

        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<Amount> request) {
        log.info("addAmount Response报文:{}", JSON.toJSONString(request));
        Response response=amountservice.addAmount(request);
        log.info("addAmount Response报文:{}",JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
       log.info("deleteAmount Response报文:{}",JSON.toJSONString(request));
       List<Integer> list= JSON.parseArray(JSON.toJSONString(request.getData()),Integer.class);
       Response response=amountservice.deleteAmount(list);
       log.info("deleteAmount Response报文:{}",JSON.toJSONString(response));
       return response;
    }

    @Override
    public Response updatePut(Request<Amount> request) {
        log.info("updateAmount Response报文:{}",JSON.toJSONString(request));
        Response response=amountservice.updateAmount(request);
        log.info("updateAmount Response报文:{}", JSON.toJSONString(response));
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
    public Response postListInit(Request<Amount> request) {
        log.info("getAmount Response报文:{}",JSON.toJSONString(request));
        Response response=amountservice.getAmount(request);
        log.info("getAmount Response报文:{}", JSON.toJSONString(response));
        return response;
    }
}
