package com.lt.commonutils.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author tong.luo
 * @description TaxRateBean
 * @date 2021/6/1 17:04
 */
public class TaxRateBean implements Serializable {
    private static final long serialVersionUID = -4580842386404520389L;
    @NotEmpty(message = "sku 不能为空")
    private String sku;
    private BigDecimal skuNum;
    private BigDecimal skuPrice;
    private BigDecimal skuAmount;
    /**
     * 税率 不含 %
     */
    @NotNull(message = "税率 不能为空")
    private BigDecimal rateValue;
    /**
     * 是否含税 1含税，2不含税
     */
    @NotNull(message = "含税标识 不能为空")
    private Integer taxInclude;
    /**
     * 是否折扣行 1是折扣行  2非折扣行
     */
    @NotEmpty(message = "是否折扣行标识 不能为空")
    private Integer disCountLine;
    /**
     * 折扣行金额
     */
    private BigDecimal disCountMon;
    /**
     * 含税金额
     */
    private BigDecimal taxTateMon;
    /**
     * 税额
     */
    private BigDecimal taxMon;
    /**
     * 不含税金额
     */
    private BigDecimal noTaxTateMon;
    /**
     * 扣除额
     */
    private BigDecimal deductionAmount;

    public BigDecimal getTaxMon() {
        return taxMon;
    }

    public void setTaxMon(BigDecimal taxMon) {
        this.taxMon = taxMon;
    }

    public BigDecimal getRateValue() {
        return rateValue;
    }

    public void setRateValue(BigDecimal rateValue) {
        this.rateValue = rateValue;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(BigDecimal skuNum) {
        this.skuNum = skuNum;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public BigDecimal getSkuAmount() {
        return skuAmount;
    }

    public void setSkuAmount(BigDecimal skuAmount) {
        this.skuAmount = skuAmount;
    }

    public Integer getTaxInclude() {
        return taxInclude;
    }

    public void setTaxInclude(Integer taxInclude) {
        this.taxInclude = taxInclude;
    }

    public Integer getDisCountLine() {
        return disCountLine;
    }

    public void setDisCountLine(Integer disCountLine) {
        this.disCountLine = disCountLine;
    }

    public BigDecimal getDisCountMon() {
        return disCountMon;
    }

    public void setDisCountMon(BigDecimal disCountMon) {
        this.disCountMon = disCountMon;
    }

    public BigDecimal getTaxTateMon() {
        return taxTateMon;
    }

    public void setTaxTateMon(BigDecimal taxTateMon) {
        this.taxTateMon = taxTateMon;
    }

    public BigDecimal getNoTaxTateMon() {
        return noTaxTateMon;
    }

    public void setNoTaxTateMon(BigDecimal noTaxTateMon) {
        this.noTaxTateMon = noTaxTateMon;
    }

    public BigDecimal getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(BigDecimal deductionAmount) {
        this.deductionAmount = deductionAmount;
    }
}
