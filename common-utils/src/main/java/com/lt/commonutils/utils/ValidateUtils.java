package com.lt.commonutils.utils;

import com.google.common.base.Joiner;
import com.lt.commonutils.expcetion.UseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author tong.luo
 * @description ValidateUtils
 * @date 2021/6/1 17:19
 */
public class ValidateUtils {

    private  final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private ValidateUtils() {
        throw new UseException("工具类不能被实例化");
    }

    private static final Validator VALIDATOR;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        VALIDATOR = validatorFactory.getValidator();
    }

    /**
     * JSR303校验方法
     *
     * @param target 目标校验对象
     * @param groups 校验组，如果没有可不传
     * @param <T> 形式类型参数
     */
    public static <T> void validate(T target, Class<?>... groups)  {
        Set<ConstraintViolation<T>> validate = VALIDATOR.validate(target, groups);
        List<String> result = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : validate) {
            result.add(constraintViolation.getMessage());
        }
        if (!CollectionUtils.isEmpty(result)) {
            throw new UseException(Joiner.on("|").join(result));
        }
    }

    /**
     *
     * @param target 目标对象
     * @param groups 校验组
     * @param <T>
     * @return Set<String> 结果集
     */
    public static <T> String validateModel(T target, Class<?>... groups) {
        Set<ConstraintViolation<T>> result = VALIDATOR.validate(target, groups);
        StringBuffer massage = new StringBuffer();
        if (result != null && result.size() > 0) {
            int count = 0;
            for (ConstraintViolation<T> constraintViolation : result) {
                if(count != result.size()-1) {
                    massage = massage.append(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage())
                            .append("|");
                }else {
                    massage = massage.append(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
                }
                count++;
            }
        }
        return massage.toString();
    }

    /**
     * 校验目标类上带有JSR303校验规则的属性
     *
     * @param target
     *            校验目标类
     * @param groups
     *            分组
     * @return 校验不符合提示信息
     */
    public static List<String> validates(Object target, Class<?>... groups) {
        Set<ConstraintViolation<Object>> validate = VALIDATOR.validate(target, groups);
        List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        return collect;
    }

}
