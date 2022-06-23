package com.sxw.learn.juc.future;

import lombok.Data;

import java.util.Random;

@Data
public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    private Random random = new Random();
    /**
     * 根据产品名查找价格
     * */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 计算价格
     *
     * @param product
     * @return
     * */
    private double calculatePrice(String product) {
        delay();
        //random.nextDouble()随机返回折扣
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 通过睡眠模拟其他耗时操作
     * */
    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
