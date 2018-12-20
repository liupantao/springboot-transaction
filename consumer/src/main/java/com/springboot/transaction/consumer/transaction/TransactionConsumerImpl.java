package com.springboot.transaction.consumer.transaction;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.transaction.api.ServerAPI;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionConsumerImpl {

    @Reference
    ServerAPI serverAPI;


    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", asyncConfirm = true)
    @Transactional
    public String sendMessage(String message) {
        String str="-------quick start customer---"+message;
        System.out.println("this is customer sendMessage------"+message);
        serverAPI.sendMessage(message);
        return str;
    }

    @Transactional
    public String confirmSendMessage(String message) {
        String str="-------quick start provider---"+message;
        System.out.println("this is customer confirmSMessage------"+message);

        return str;
    }

    @Transactional
    public String cancelSendMessage(String message) {
        System.out.println("this is customer cancleSendMessage------"+message);

        return message;
    }
}
