package com.lt.model.code;

/**
 * @Author: LT
 * @Date: 2019/10/10 19:45
 * @Description:
 * @Version 1.0
 */
public class MealB extends ProductBuilder{
    @Override
    public void buildFood() {
        System.out.println("buildFoodB");
        meal.setFood("buildFoodB");
    }

    @Override
    public void buildDrink() {
        System.out.println("buildDrinkB");
        meal.setDrink("buildDrinkB");
    }
}
