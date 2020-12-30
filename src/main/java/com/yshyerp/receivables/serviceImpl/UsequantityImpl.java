package com.yshyerp.receivables.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.receivables.entity.Usequantity;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Usequantityservice;
import  com.yshyerp.receivables.mapper.UsequantityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/12/7
 * @Description:
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UsequantityImpl implements Usequantityservice {
   @Autowired
   private  UsequantityMapper usequantityMapper;
    @Override
    public Response getusequantity(Request<Usequantity> req) {
        Response response=null;
        //判断是否分页,否则查所有
        if(!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(),req.getPageSize());
        try {
            //执行sql操作
            QueryWrapper<Usequantity> qw= Wrappers.query();
            //自写sql语句不需要这个
//            qw.select("*,id [key]");
            qw.apply("ISNULL(d,'')=''");
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),new PageInfo<>(usequantityMapper.selectList(qw)));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response addUsequantity(Request usequantity) {
        Response response=null;
        try {
            Usequantity usequantity1 = JSON.parseObject(JSON.toJSONString(usequantity.getData()),Usequantity.class);
            response=Response.success(MessageEnum.INSERT_SUCCESS.getVal(),usequantityMapper.insert(usequantity1));
        }catch (Exception e){
            log.info("addUsequantity接口操作失败",e.getMessage());
            response=Response.error(MessageEnum.INSERT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateUsequantity(Request request) {
        Response response=null;
        try {
            Usequantity usequantity =  JSON.parseObject(JSON.toJSONString(request.getData()),Usequantity.class);
            response=Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), usequantityMapper.updateById(usequantity));
        }catch (Exception e){
            log.info("updateUsequantity接口操作失败",e.getMessage());
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteUsequantity(List<Integer> id) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.DELETE_SUCCESS.getVal(), usequantityMapper.deleteUsequantity(id));
        }catch (Exception e){
            log.info("deleteUsequantity接口操作失败",e.getMessage());
            response =Response.error(MessageEnum.DELETE_ERROR.getVal());
        }
        return response;
    }
}
