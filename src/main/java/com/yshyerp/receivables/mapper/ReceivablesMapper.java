package com.yshyerp.receivables.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.receivables.entity.receivables;

import java.util.List;

public interface ReceivablesMapper extends BaseMapper<receivables> {
    /**
     * 查询合同该收账款信息
     * @param receivables
     * @return
     */
    Integer getREceivables(receivables receivables);


    /**
     *多选根据id修改状态state=10
     * @param id
     * @return
     */
    Integer updateREceivablesById(List<Integer> id);

    /**
     * 根据id修改减免费用 DeductMoney 和加收费用Cent等于总费用amount
     * @param receivables
     * @return
     */
   Integer updateReceivablesByIddca(receivables receivables);

    /**
     *  多删除 修改应收账款情况
     * @param no
     * @return
     */
    Integer deleteReceivables(List<String> no);
}