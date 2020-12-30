package com.yshyerp.receivables.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yshyerp.receivables.controller.common.ControllerTemplate;
import com.yshyerp.receivables.entity.vw_usequantity;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Vwusequantityservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: Administrato
 * @Data: 2020/12/7
 * @Description:
 */

@RequestMapping("vwusequantity/")
@RestController
@Slf4j
public class VwusequantityController implements ControllerTemplate<vw_usequantity> {

    @Autowired
    private Vwusequantityservice vwusequantityservice;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<vw_usequantity> request) {
        return null;
    }

    @Override
    public Response delete(Request request) {
        return null;
    }

    @Override
    public Response updatePut(Request<vw_usequantity> request) {
        return null;
    }

    @Override
    public Response getDropDownInit() {
        return vwusequantityservice.query();
    }
    @GetMapping("getDropDownInitname")
    public Response getDropDownInitname() {
        return vwusequantityservice.queryname();
    }
    @GetMapping("getDropDownInitcontracti")
    public Response getDropDownInitcontracti() {
        return vwusequantityservice.querycontracti();
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @GetMapping("getVusequantityById/{id}")
    public  Response getVusequantityById(@PathVariable Integer id){
        return vwusequantityservice.getVusequantityById(id);
    }


//    @GetMapping("getbyName/{name}")
//    public  Response getbyName(@PathVariable String name){
//        return vwusequantityservice.getbyName(name);
//    }

    @PostMapping("/getbyName")
    public Object getbyName(@RequestBody JSONObject jsonParam) {
        String name = jsonParam.get("name").toString();
        return vwusequantityservice.getbyName(name);
    }

//    @PostMapping(value = "getbyName")
//    public  Response getbyName(@RequestParam("name")String name){
//        return vwusequantityservice.getbyName(name);
//    }
    @GetMapping("getBycontract_i/{contracti}")
    public  Response getBycontract_i(@PathVariable String contracti){
        return  vwusequantityservice.getBycontract_i(contracti);
    }
    @Override
    public Response postListInit(Request<vw_usequantity> request) {
        log.info("getVusequantity Response报文:{}", JSON.toJSONString(request));
        Response response=vwusequantityservice.getVusequantity(request);
        log.info("getVusequantity Response报文:{}",JSON.toJSONString(response));
        return response;
    }
}
