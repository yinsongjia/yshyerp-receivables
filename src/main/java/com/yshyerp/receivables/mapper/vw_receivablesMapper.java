package com.yshyerp.receivables.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.receivables.entity.vw_receivables;

public interface vw_receivablesMapper extends BaseMapper<vw_receivables> {
    /**
     * 查询合同应收账款情况(视图)
     * @param vwReceivables
     * @return
     */
    Integer getVwreceivables(vw_receivables vwReceivables);

    /**
     * 根据id查询合同应收账款情况(视图)
     * @param id
     * @return
     */
    Integer getVwreceivablesById(Integer id);

}