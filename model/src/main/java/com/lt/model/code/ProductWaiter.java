package com.lt.model.code;

/**
 * @Author: LT
 * @Date: 2019/10/10 19:47
 * @Description:
 * @Version 1.0
 */
public class ProductWaiter {
    private ProductBuilder productBuilder;

    public ProductWaiter(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product construct() {
        productBuilder.buildDrink();
        productBuilder.buildFood();
        return productBuilder.getMeal();
    }
}

 class Test {
    public static void main(String[] args) {
        Product meal = new Product();

        ProductWaiter productWaiter = new ProductWaiter(meal);
//        Meal construct = productWaiter.construct();

//        System.out.println(construct.getMeal());
    }
}
