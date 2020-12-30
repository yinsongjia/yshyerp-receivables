package com.yshyerp.receivables.service;

import com.yshyerp.receivables.entity.vw_usequantity;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;
import com.yshyerp.receivables.response.dto.DropDownBoxDTO;

import java.util.List;

public interface Vwusequantityservice {
    /**
     * 查询服务项目使用量情况
     * @param req
     * @return
     */
    Response getVusequantity(Request<vw_usequantity> req);

    /**
     * 根据ID查询服务项目使用量一条详细信息
     * @param id
     * @return
     */
    Response getVusequantityById(Integer id);

    /**
     * 客户下拉框初始化
     * @return
     */
    Response query();
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
    Response getBycontract_i(String contracti);

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
