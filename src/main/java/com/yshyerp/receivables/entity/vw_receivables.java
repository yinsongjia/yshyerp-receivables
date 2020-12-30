package com.yshyerp.receivables.entity;

import java.math.BigDecimal;
import java.util.Date;

public class vw_receivables {
    private Integer id;

    private Integer billid;

    private String contractI;

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

    private BigDecimal total2;

    private BigDecimal pailweight;

    private BigDecimal deductmoney;

    private String deductreason;

    private String invoiceno;

    private Date invoicedate;

    private String operatorid;

    private Date createdate;

    private Integer type;

    private Integer state;

    private String remarks;

    private String name;

    private String unit;

    private Integer chargetype;

    private String cName;

    private BigDecimal amount;

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

    public String getContractI() {
        return contractI;
    }

    public void setContractI(String contractI) {
        this.contractI = contractI == null ? null : contractI.trim();
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

    public BigDecimal getTotal2() {
        return total2;
    }

    public void setTotal2(BigDecimal total2) {
        this.total2 = total2;
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

    public Integer getChargetype() {
        return chargetype;
    }

    public void setChargetype(Integer chargetype) {
        this.chargetype = chargetype;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}