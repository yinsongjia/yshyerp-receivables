package com.yshyerp.receivables.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Usequantity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String useno;

    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date date;


    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    @TableField(exist = false)
    private Date enDate;

    private String customer;

    private Integer billid;

    private String serviceid;

    private BigDecimal quantity;

    private String remarks;

    private String d;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseno() {
        return useno;
    }

    public void setUseno(String useno) {
        this.useno = useno == null ? null : useno.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }
}