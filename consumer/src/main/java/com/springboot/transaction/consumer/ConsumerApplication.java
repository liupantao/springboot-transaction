package com.springboot.transaction.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.springboot.transaction.consumer.transaction.TransactionConsumerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubboConfiguration
public class ConsumerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run =
                SpringApplication.run(ConsumerApplication.class, args);
      //  QuickStartImpl quickStartImpl = (QuickStartImpl) run.getBean("quickStartImpl");
       // quickStartImpl.sendMessage("你好呀--dubbo");

        TransactionConsumerImpl transactionConsumerImpl = (TransactionConsumerImpl) run.getBean("transactionConsumerImpl");
        transactionConsumerImpl.sendMessage("---------你好-分布式事务-transaction--");
    }

}

