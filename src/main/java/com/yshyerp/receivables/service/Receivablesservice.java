package com.yshyerp.receivables.service;

import com.yshyerp.receivables.entity.receivables;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;

import java.util.List;

public interface Receivablesservice {
    /**
     * 查询合同该收账款信息
     * @param req
     * @return
     */
    Response getREceivables(Request<receivables> req);
    /**
     *多选根据id修改状态state=10
     * @param id
     * @return
     */
    Response updateREceivablesById(List<Integer> id);

    /**
     * 根据id修改减免费用 DeductMoney 和加收费用Cent等于总费用amount
     * @param receivables
     * @return
     */
    Response updateReceivablesByIddca(Request<receivables> receivables);


    /**
     *  多删除 修改应收账款情况
     * @param no
     * @return
     */
    Response deleteReceivables(List<String> no);
}
