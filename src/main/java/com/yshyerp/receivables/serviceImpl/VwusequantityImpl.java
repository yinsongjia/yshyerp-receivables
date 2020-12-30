package com.yshyerp.receivables.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.mapper.vw_usequantityMapper;
import com.yshyerp.receivables.entity.vw_usequantity;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.response.dto.DropDownBoxDTO;
import com.yshyerp.receivables.service.Vwusequantityservice;
import com.yshyerp.receivables.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.Na;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/12/4
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class VwusequantityImpl implements Vwusequantityservice {
       @Autowired
       private vw_usequantityMapper vwusequantityMapper;
    @Override
    public Response getVusequantity(Request<vw_usequantity> req) {
        Response response=null;
        //判断是否分页,否则查询所有
        if(!StringUtils.isEmpty(req.getPageNum())&& !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(),req.getPageSize());
        try {
            //执行sq操作
            QueryWrapper<vw_usequantity>qw= Wrappers.query();
            //自写sql语句不需要这个
            qw.select("*,id [key]");
//            req.getData().getUseno().substring(0, req.getData().getUseno().indexOf(" "));
              if(!StringUtils.isEmpty(req.getData().getUseno())) qw.eq("useno",req.getData().getUseno());
              if(!StringUtils.isEmpty(req.getData().getCustomer())) qw.eq("customer",req.getData().getCustomer());
              response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),new PageInfo<>(vwusequantityMapper.selectList(qw)));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override

    public Response getVusequantityById(Integer id) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),vwusequantityMapper.selectById(id));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override

    public Response query() {
        JSONObject jsonObject = new JSONObject();
        String strcustomer = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (vwusequantityMapper.query()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("customerList", JSON.parse(strcustomer, Feature.OrderedField));
        String strnameList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (vwusequantityMapper.queryname()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("nameList", JSON.parse(strnameList, Feature.OrderedField));

        String strList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (vwusequantityMapper.querycontracti()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("contractiList", JSON.parse(strList, Feature.OrderedField));
        return Response.success("查询成功", jsonObject);
    }

    @Override
    public Response getbyName(String name) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),vwusequantityMapper.getbyName(name));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response getBycontract_i(String contracti) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(), vwusequantityMapper.getBycontract_i(contracti));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response queryname() {
        JSONObject jsonObject = new JSONObject();
        String strList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (vwusequantityMapper.queryname()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("nameList", JSON.parse(strList, Feature.OrderedField));
        return Response.success("查询成功", jsonObject);
    }

    @Override
    public Response querycontracti() {
        JSONObject jsonObject = new JSONObject();
        String strList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (vwusequantityMapper.querycontracti()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("contractiList", JSON.parse(strList, Feature.OrderedField));
        return Response.success("查询成功", jsonObject);
    }
}
