package com.yshyerp.receivables.service;

import com.yshyerp.receivables.entity.Amount;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;

import java.util.List;

public interface Amountservice {


    /**
     * 查询服务项目金额确认
     * @param req
     * @return
     */
    Response getAmount(Request<Amount> req);
    /**
     * 添加服务项目金额确认
     * @param amount
     * @return
     */
    Response addAmount(Request<Amount> amount);

    /**
     * 修改服务项目金额确认
     * @param amount
     * @return
     */
    Response updateAmount(Request<Amount>  amount);

    /**
     *  多删除 修改状态服务项目金额确认
     * @param id
     * @return
     */
    Response deleteAmount(List<Integer> id);
}
