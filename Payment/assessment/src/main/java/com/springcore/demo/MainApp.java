package com.springcore.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Default Bean (CreditCardPayment because of @Primary)
        
        Payment payment = context.getBean(Payment.class);
        payment.pay(5000);

        System.out.println("---- Prototype Scope Check ----");

        UpiPayment upi1 = context.getBean(UpiPayment.class);
        UpiPayment upi2 = context.getBean(UpiPayment.class);

        System.out.println(upi1);
        System.out.println(upi2);

        context.close();
    }
}
