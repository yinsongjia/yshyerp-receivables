package com.yshyerp.receivables.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.receivables.entity.receivables;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.mapper.ReceivablesMapper;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Receivablesservice;
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
 * @Data: 2020/12/8
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class ReceivablesImpl implements Receivablesservice {

    @Autowired
    private ReceivablesMapper receivablesMapper;
    @Override
    public Response getREceivables(Request<receivables> req) {
        Response response=null;
        //判断是否分页,否则查询所有
        if(!StringUtils.isEmpty(req.getPageNum()) &&!StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(),req.getPageSize());
        try {
            //执行sql操作
            QueryWrapper<receivables> qw= Wrappers.query();
            //自写sql语句不需要这个
//            qw.select("*,id [key]");
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),new PageInfo<>(receivablesMapper.selectList(qw)));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateREceivablesById(List<Integer> id) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.UPDATE_SUCCESS.getVal(),receivablesMapper.updateREceivablesById(id));
        }catch (Exception e){
            log.info(e.getMessage());
            throw  new RuntimeException("ReceivablesImpl.updateREceivablesById error",e);
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateReceivablesByIddca(Request<receivables> receivables) {
        Response response=null;
        try {
            response =Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), receivablesMapper.updateReceivablesByIddca(receivables.getData()));
        }catch (Exception e){
            log.info(e.getMessage());
            throw  new RuntimeException("ReceivablesImpl.updateREceivablesById error",e);
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteReceivables(List<String> no) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.DELETE_SUCCESS.getVal(),receivablesMapper.deleteReceivables(no));
        }catch (Exception e){
            log.info(e.getMessage());
            throw  new RuntimeException("ReceivablesImpl.deleteReceivables error",e);
        }
        return response;
    }

}
