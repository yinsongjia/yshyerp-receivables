package com.yshyerp.receivables.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.receivables.entity.vw_receivables;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.mapper.vw_receivablesMapper;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Vwreceivablesservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Author: Administrator
 * @Data: 2020/12/7
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class VwreceivablesImpl implements Vwreceivablesservice {
    @Autowired
    private vw_receivablesMapper vwreceivablesMapper;
    @Override
    public Response getVwreceivables(Request<vw_receivables> req) {
        Response response=null;
        if(!StringUtils.isEmpty(req.getPageNum())&& !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(),req.getPageSize());
        try {
            QueryWrapper<vw_receivables> qw= Wrappers.query();
            if(!StringUtils.isEmpty(req.getData().getContractI()))qw.eq("contract_i",req.getData().getContractI());
            if(!StringUtils.isEmpty(req.getData().getNo()))qw.eq("no",req.getData().getNo());
            if(!StringUtils.isEmpty(req.getData().getCommodity()))qw.eq("commodity",req.getData().getCommodity());
             response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo<>(vwreceivablesMapper.selectList(qw)));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response getVwreceivablesById(Integer id) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(), vwreceivablesMapper.selectById(id));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }
}
