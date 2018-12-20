package com.springboot.transaction.provider.transaction;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.transaction.api.ServerAPI;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service(interfaceClass = ServerAPI.class)
public class TransactionStartImpl implements ServerAPI {
   @Override
   @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", transactionContextEditor = DubboTransactionContextEditor.class)
   @Transactional
    public String sendMessage(String message) {
        String str="-------quick start provider---"+message;
        System.out.println("this is sendMessage------"+message);
        return str;
    }

    public String confirmSendMessage(String message) {
        String str="-------quick start provider---"+message;
        System.out.println("this is confirmSMessage------"+message);

        return str;
    }

    public String cancleSendMessage(String message) {
        System.out.println("this is cancleSendMessage------"+message);

        return null;
    }
}
