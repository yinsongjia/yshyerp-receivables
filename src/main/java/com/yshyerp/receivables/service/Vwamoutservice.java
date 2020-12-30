package com.yshyerp.receivables.service;

import com.yshyerp.receivables.entity.vw_amount;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.response.dto.DropDownBoxDTO;

import java.util.List;

public interface Vwamoutservice {
    /**
     * 查询Vw_amout视图查看所有信息
     * @param req
     * @return
     */
    Response getVwamount(Request<vw_amount> req);

    /**
     * 根据id查询Vw_amout视图查看所有信息
     * @param id
     * @return
     */
    Response getVwamountById(Integer id);
    /**
     * 根据Name带出一条单位(查询)
     * @param name
     * @return
     */
    Response getbyName(String name);

    /**
     * 根据合同号带出日期(查询)
     * @param contracti
     * @return
     */
    Response getBycontracti(String contracti);

    /**
     * 客户下拉框初始化
     * @return
     */
    Response query();

    /**
     * 服务项目下拉框
     * @return
     */
    Response queryname();

    /**
     * 合同号
     * @return
     */
    Response querycontracti();

}
