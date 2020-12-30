package com.yshyerp.receivables.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.receivables.entity.vw_usequantity;
import com.yshyerp.receivables.response.dto.DropDownBoxDTO;

import java.util.List;

public interface vw_usequantityMapper extends BaseMapper<vw_usequantity> {

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
     String getBycontract_i(String contracti);
    /**
     * 查询服务项目使用量情况
     * @param vwusequantity
     * @return
     */
    Integer getVusequantity(vw_usequantity vwusequantity);

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
     * 根据ID查询服务项目使用量一条详细信息
     * @param id
     * @return
     */
    Integer getVusequantityById(Integer id);
}