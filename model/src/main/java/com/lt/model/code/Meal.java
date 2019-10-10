package com.lt.model.code;

/**
 * @Author: LT
 * @Date: 2019/10/10 19:45
 * @Description:
 * @Version 1.0
 */
public class Meal extends ProductBuilder{
    @Override
    public void buildFood() {
        meal.setFood("buildFood");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("buildDrink");
    }
}
