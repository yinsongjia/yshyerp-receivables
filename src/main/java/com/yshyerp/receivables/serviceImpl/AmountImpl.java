package com.yshyerp.receivables.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.receivables.entity.Amount;
import com.yshyerp.receivables.entity.vw_amount;
import com.yshyerp.receivables.enums.MessageEnum;
import com.yshyerp.receivables.mapper.AmountMapper;
import com.yshyerp.receivables.mapper.ReceivablesMapper;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.service.Amountservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Administrator
 * @Data: 2020/12/4
 * @Description:
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class AmountImpl implements Amountservice {
    @Autowired
    private ReceivablesMapper receivablesMapper; //合同应收账款
      @Autowired
    private AmountMapper amountMapper;

    @Override
    public Response getAmount(Request<Amount> req) {
        Response response=null;
        //判断是否分页,否则查所有
        if(!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(),req.getPageSize());
        try {
            //执行sql操作
            QueryWrapper<Amount> qw= Wrappers.query();
            qw.apply("ISNULL(d,'')=''");
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(),new PageInfo<>(amountMapper.selectList(qw)));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response addAmount(Request<Amount> amount) {
        Response response=null;
        try {
            //exec Sav_Receivables 0,'AM','txtamountno','dvcname','',''
            if(amountMapper.insert(amount.getData())!=0){
                response=Response.success(MessageEnum.INSERT_SUCCESS.getVal(),
                        amountMapper.exec(amount.getData().getAmountno(),"admin"));

//                     amountMapper.execwno(amount.getData().getAmountno());
            }
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.INSERT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateAmount(Request<Amount> amount) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), amountMapper.updateById(amount.getData()));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteAmount(List<Integer> id) {
        Response response=null;
//        Map<String,Object> map=new HashMap<>();
        try {
//            QueryWrapper qw=Wrappers.query();
//            qw.eq("id",id);

            response=Response.success(MessageEnum.DELETE_SUCCESS.getVal(), amountMapper.deleteAmount(id));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.DELETE_ERROR.getVal());
        }
        return response;
    }
}
