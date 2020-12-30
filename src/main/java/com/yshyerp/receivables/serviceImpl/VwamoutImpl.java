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
import com.yshyerp.receivables.entity.vw_amount;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.mapper.vw_amountMapper;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.response.dto.DropDownBoxDTO;
import com.yshyerp.receivables.service.Vwamoutservice;
import com.yshyerp.receivables.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Author: Administrator
 * @Data: 2020/12/3
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class VwamoutImpl  implements Vwamoutservice {
    @Autowired
    private vw_amountMapper  vwamountMapper;
    @Override
    public Response getVwamount(Request<vw_amount> req) {
        Response response=null;
        //判断是否分页,否则查所有
        if(!StringUtils.isEmpty(req.getPageNum())&& !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(),req.getPageSize());
        try {
            //执行sql操作
            QueryWrapper<vw_amount> qw= Wrappers.query();
            //自写sql语句不需要这个
            qw.select("*,id [key]");
            if(!StringUtils.isEmpty(req.getData().getAmountno())) qw.eq("amountno",req.getData().getAmountno());
            if(!StringUtils.isEmpty(req.getData().getCustomer())) qw.eq("customer",req.getData().getCustomer());
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),new PageInfo<>(vwamountMapper.selectList(qw)));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response getVwamountById(Integer id) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),vwamountMapper.selectById(id));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response getbyName(String name) {
        Response response=null;
        try {
            response =Response.success(MessageEnum.SELECT_SUCCESS.getVal(),vwamountMapper.getbyName(name));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response getBycontracti(String contracti) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(), vwamountMapper.getBycontracti(contracti));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response query() {
        JSONObject jsonObject=new JSONObject();
        String strcustomer= JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON(vwamountMapper.query()), SerializerFeature.QuoteFieldNames).replace("\\s","");
        jsonObject.put("customerList", JSON.parse(strcustomer, Feature.OrderedField));
        String strnameList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSONKey
                (vwamountMapper.queryname()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("nameList", JSON.parse(strnameList, Feature.OrderedField));
        String strList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSONKey
                (vwamountMapper.querycontracti()), SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames).replaceAll("\\s", "");
        jsonObject.put("contractiList", JSON.parse(strList, Feature.OrderedField));
        return Response.success("查询成功", jsonObject);
    }

    @Override
    public Response queryname() {
        return null;
    }

    @Override
    public Response querycontracti() {
        return null;
    }
}
