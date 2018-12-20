package com.springboot.transaction.consumer.quickstart;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.transaction.api.ServerAPI;
import org.springframework.stereotype.Component;

@Component
public class QuickStartImpl {

    @Reference
    ServerAPI serverAPI;


    public String sendMessage(String message){
        System.out.println("---------------consumer---"+message);
        System.out.println("---------------consumer-----"+serverAPI.sendMessage(message));
        return null;
    }
}
