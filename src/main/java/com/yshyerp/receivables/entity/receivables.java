package com.yshyerp.receivables.entity;

import java.math.BigDecimal;
import java.util.Date;

public class receivables {
    private Integer id;

    private Integer billid;

    private String receivablesid;

    private String no;

    private String commodity;

    private String serviceid;

    private String customer;

    private String tank;

    private Date occurdate;

    private BigDecimal price;

    private BigDecimal cent;

    private BigDecimal taxrate;

    private BigDecimal number;

    private BigDecimal pailweight;

    private BigDecimal deductmoney;

    private String deductreason;

    private BigDecimal amount;

    private String invoiceno;

    private Date invoicedate;

    private String operatorid;

    private Date createdate;

    private Integer type;

    private Integer state;

    private String remarks;

    private String d;

    private Long groupreceivablesid;

    private Integer paymode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getReceivablesid() {
        return receivablesid;
    }

    public void setReceivablesid(String receivablesid) {
        this.receivablesid = receivablesid == null ? null : receivablesid.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity == null ? null : commodity.trim();
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank == null ? null : tank.trim();
    }

    public Date getOccurdate() {
        return occurdate;
    }

    public void setOccurdate(Date occurdate) {
        this.occurdate = occurdate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCent() {
        return cent;
    }

    public void setCent(BigDecimal cent) {
        this.cent = cent;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getPailweight() {
        return pailweight;
    }

    public void setPailweight(BigDecimal pailweight) {
        this.pailweight = pailweight;
    }

    public BigDecimal getDeductmoney() {
        return deductmoney;
    }

    public void setDeductmoney(BigDecimal deductmoney) {
        this.deductmoney = deductmoney;
    }

    public String getDeductreason() {
        return deductreason;
    }

    public void setDeductreason(String deductreason) {
        this.deductreason = deductreason == null ? null : deductreason.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno == null ? null : invoiceno.trim();
    }

    public Date getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(Date invoicedate) {
        this.invoicedate = invoicedate;
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid == null ? null : operatorid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Long getGroupreceivablesid() {
        return groupreceivablesid;
    }

    public void setGroupreceivablesid(Long groupreceivablesid) {
        this.groupreceivablesid = groupreceivablesid;
    }

    public Integer getPaymode() {
        return paymode;
    }

    public void setPaymode(Integer paymode) {
        this.paymode = paymode;
    }
}