package com.yshyerp.receivables.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.receivables.controller.common.ControllerTemplate;
import com.yshyerp.receivables.entity.receivables;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Receivablesservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/12/8
 * @Description:
 */
@RequestMapping("receivables/")
@RestController
@Slf4j
public class ReceivablesController implements ControllerTemplate<receivables> {

    @Autowired
    private Receivablesservice receivablesservice;
    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<receivables> request) {
        return null;
    }

    @Override
    public Response delete(Request request) {
        log.info("delete Response报文:{}",JSON.toJSONString(request));
                Response response=null;
        try {
            List<String> list= JSON.parseArray(JSON.toJSONString(request.getData()),String.class);
            response=receivablesservice.deleteReceivables(list);
            log.info("delete Response报文:{}",JSON.toJSONString(response));
        } catch (Exception e) {
            response=Response.error(MessageEnum.DELETE_ERROR.getVal());
        }
        return  response;
    }

    @PutMapping("updateReceivablesByIddca")
    public  Response updateReceivablesByIddca(Request<receivables> request){
        log.info("updateReceivablesByIddca Response报文:{}",JSON.toJSONString(request));
        Response response= null;
        try {
            response = receivablesservice.updateReceivablesByIddca(request);
            log.info("updateReceivablesByIddca Response报文:{}",JSON.toJSONString(response));
        } catch (Exception e) {
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response updatePut(Request request) {
        log.info("updateREceivablesById Response报文:{}",JSON.toJSONString(request));
        List<Integer> list= JSON.parseArray(JSON.toJSONString(request.getData()),Integer.class);
        Response response=receivablesservice.updateREceivablesById(list);
        log.info("updateREceivablesById Response报文:{}",JSON.toJSONString(response));
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
    public Response postListInit(Request<receivables> request) {
        log.info("getREceivables Response报文:{}", JSON.toJSONString(request));
        Response response=receivablesservice.getREceivables(request);
        log.info("getREceivables Response报文:{}",JSON.toJSONString(response));
        return response;
    }
}
