package com.yshyerp.receivables.service;

import com.yshyerp.receivables.entity.Usequantity;
import com.yshyerp.receivables.request.Request;
import com.yshyerp.receivables.response.Response;

import java.util.List;

public interface Usequantityservice {
    /**
     * 查询服务项目使用量
     * @param req
     * @return
     */
    Response getusequantity(Request<Usequantity> req);

    /**
     * 添加服务项目使用量
     * @param usequantity
     * @return
     */
    Response  addUsequantity(Request  usequantity);

    /**
     * 修改服务项目使用量
     * @param usequantity
     * @return
     */
    Response  updateUsequantity(Request  usequantity);

    /**
     * 根据id多删除(修改状态)
     * @param id
     * @return
     */
    Response deleteUsequantity(List<Integer> id);
}
