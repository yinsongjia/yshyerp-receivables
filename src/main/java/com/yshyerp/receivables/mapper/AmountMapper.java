package com.yshyerp.receivables.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.receivables.entity.Amount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmountMapper extends BaseMapper<Amount> {

    /**
     * 查询服务项目金额确认
     * @param amount
     * @return
     */
    Integer getAmount(Amount amount);

    /**
     * 调用Sav_Receivables存储过程amountno单据号 cname 用户名
     * @param amountno
     * @param cname
     * @return
     */
    Integer exec(@Param("amountno") String amountno , @Param("cname") String cname);

    /**
     * 调用存储过程w_no
     * @param amountno
     * @return
     */
    Integer execwno(@Param("amountno")String amountno);
    /**
     * 添加服务项目金额确认
     * @param amount
     * @return
     */
    Integer addAmount(Amount amount);

    /**
     * 修改服务项目金额确认
     * @param amount
     * @return
     */
    Integer updateAmount(Amount amount);

    /**
     *  多删除 修改状态服务项目金额确认
     * @param id
     * @return
     */
     Integer deleteAmount(List<Integer> id);
}