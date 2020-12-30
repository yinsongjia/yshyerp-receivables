package com.yshyerp.receivables.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.receivables.entity.vw_amount;
import com.yshyerp.receivables.response.dto.DropDownBoxDTO;

import java.util.List;

public interface vw_amountMapper extends BaseMapper<vw_amount> {

    /**
     * 根据Name带出一条单位(查询)
     * @param name
     * @return
     */
    String getbyName(String name);

    /**
     * 根据合同号带出日期(查询)
     * @param contracti
     * @return
     */
    String getBycontracti(String contracti);

    /**
     * 客户下拉框初始化
     * @return
     */
    List<DropDownBoxDTO> query();

    /**
     * 服务项目下拉框
     * @return
     */
    List<DropDownBoxDTO> queryname();

    /**
     * 合同号
     * @return
     */
    List<DropDownBoxDTO> querycontracti();

    /**
     * 查询Vw_amout视图查看所有信息
     * @param vw_amount
     * @return
     */
    Integer getVwamount(vw_amount vw_amount);

    /**
     * 根据id查询Vw_amout视图查看所有信息
     * @param id
     * @return
     */
    Integer getVwamountById(Integer id);
}