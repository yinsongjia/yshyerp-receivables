package com.yshyerp.receivables.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.util.Date;

public class vw_usequantity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    //使用注解表明该字段不是数据库的字段
    @TableField(exist = false)
    private  Integer key;

    private String useno;

    private Date date;

    private String customer;

    private Integer billid;

    private String serviceid;

    private BigDecimal quantity;

    private String remarks;

    private Date enDate;

    private String name;

    private String unit;

    private BigDecimal price;

    private String contractI;

    private BigDecimal taxrate;

    private Integer state;

    private BigDecimal miniquan;

    private BigDecimal freequan;

    private Boolean isnum;

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

    public Date getEnDate() {
        return enDate;
    }

    public void setEnDate(Date enDate) {
        this.enDate = enDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContractI() {
        return contractI;
    }

    public void setContractI(String contractI) {
        this.contractI = contractI == null ? null : contractI.trim();
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getMiniquan() {
        return miniquan;
    }

    public void setMiniquan(BigDecimal miniquan) {
        this.miniquan = miniquan;
    }

    public BigDecimal getFreequan() {
        return freequan;
    }

    public void setFreequan(BigDecimal freequan) {
        this.freequan = freequan;
    }

    public Boolean getIsnum() {
        return isnum;
    }

    public void setIsnum(Boolean isnum) {
        this.isnum = isnum;
    }
}