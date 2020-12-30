package com.yshyerp.receivables.service;


import com.yshyerp.receivables.entity.vw_receivables;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;

public interface Vwreceivablesservice {
    /**
     * 查询合同应收账款情况(视图)
     * @param req
     * @return
     */
    Response getVwreceivables(Request<vw_receivables> req);

    /**
     * 根据id查询合同应收账款情况(视图)
     * @param id
     * @return
     */
    Response getVwreceivablesById(Integer id);
}
