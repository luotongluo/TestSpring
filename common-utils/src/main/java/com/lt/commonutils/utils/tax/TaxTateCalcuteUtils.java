package com.lt.commonutils.utils.tax;

import com.lt.commonutils.bean.TaxRateBean;
import com.lt.commonutils.expcetion.UseException;
import com.lt.commonutils.utils.ValidateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author tong.luo
 * @description TaxTateCalcute
 * calcute
 * （不含税金额 - 不含税差额） / (1 + 税率)  = 含税金额
 * （不含税金额 - 不含税差额） - 含税金额 = 税额
 * @date 2021/6/1 16:45
 */
public class TaxTateCalcuteUtils {
    /**
     * 计算主体
     *
     * @param taxRateBeans
     * @return
     */
    public static List<TaxRateBean> calcuteMon(List<TaxRateBean> taxRateBeans) {
        if (CollectionUtils.isEmpty(taxRateBeans)) {
            throw new UseException("传入数据不能为空");
        }
        StringBuffer throwBuff = new StringBuffer();
        taxRateBeans.stream().forEach(a -> {
            String validateModel = ValidateUtils.validateModel(a);
            if (StringUtils.isNotEmpty(validateModel)) {
                throwBuff.append(validateModel + "\r\n");
            }
        });
        if (StringUtils.isNotEmpty(throwBuff.toString())) {
            throw new UseException(throwBuff.toString());
        }
        for (int i = 0; i < taxRateBeans.size(); i++) {
            TaxRateBean taxRateBean = taxRateBeans.get(i);
            taxRateBean.setDeductionAmount(taxRateBean.getDeductionAmount() == null ? BigDecimal.ZERO : taxRateBean.getDeductionAmount());
            //是否含税 1含税，2不含税
            if (taxRateBean.getTaxInclude() == 1) {
                calcuteRateMon(taxRateBean);
            } else if (taxRateBean.getTaxInclude() == 2) {
                calcuteNoRateMon(taxRateBean);
            }

        }

        return null;
    }

    /**
     * 含税的计算
     *
     * @param taxRateBeans
     * @return
     */
    public static TaxRateBean calcuteRateMon(TaxRateBean taxRateBeans) {
        //是否折扣行 1是折扣行 2非折扣行
        Integer disCountLine = taxRateBeans.getDisCountLine();
        BigDecimal sumMon = null;
        if(disCountLine == 2){
            sumMon = taxRateBeans.getSkuAmount().subtract(taxRateBeans.getDeductionAmount());
        }else if(disCountLine == 1){
            sumMon = taxRateBeans.getDisCountMon();
        }
        BigDecimal noTaxTateMon = sumMon.divide(BigDecimal.ONE.add(taxRateBeans.getRateValue()));
        taxRateBeans.setNoTaxTateMon(noTaxTateMon);
        taxRateBeans.setTaxMon(sumMon.subtract(noTaxTateMon));
        taxRateBeans.setTaxTateMon(taxRateBeans.getSkuAmount());
        return taxRateBeans;
    }

    /**
     * 不含税的计算
     *
     * @param taxRateBeans
     * @return
     */
    public static TaxRateBean calcuteNoRateMon(TaxRateBean taxRateBeans) {
        //是否折扣行 1是折扣行 2非折扣行
        Integer disCountLine = taxRateBeans.getDisCountLine();
        BigDecimal rateMon = null;
        if(disCountLine == 2){
             rateMon = (taxRateBeans.getSkuAmount().subtract(taxRateBeans.getDeductionAmount())).multiply(taxRateBeans.getRateValue());
        }else if(disCountLine == 1){
             rateMon = taxRateBeans.getDisCountMon().multiply(taxRateBeans.getRateValue());
        }
        taxRateBeans.setTaxMon(rateMon);
        return taxRateBeans;
    }
}
