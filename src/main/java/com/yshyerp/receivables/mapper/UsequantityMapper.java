package com.yshyerp.receivables.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.receivables.entity.Usequantity;

import java.util.List;

public interface UsequantityMapper extends BaseMapper<Usequantity> {

    /**
     * 查询服务项目使用量
     * @param usequantity
     * @return
     */
    Integer getusequantity(Usequantity usequantity);

    /**
     * 添加服务项目使用量
     * @param usequantity
     * @return
     */
    Integer  addUsequantity(Usequantity usequantity);

    /**
     * 修改服务项目使用量
     * @param usequantity
     * @return
     */
    Integer  updateUsequantity(Usequantity usequantity);

    /**
     * 根据id多删除(修改状态)
     * @param id
     * @return
     */
    Integer deleteUsequantity(List<Integer> id);
}