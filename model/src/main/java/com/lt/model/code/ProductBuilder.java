package com.lt.model.code;

/**
 * @Author: LT
 * @Date: 2019/10/10 19:44
 * @Description:
 * @Version 1.0
 */
public abstract class ProductBuilder {
    Product meal = new Product();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Product getMeal(){
        return meal;
    }
}
