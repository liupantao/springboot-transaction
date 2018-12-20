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
    @Transactional
    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", transactionContextEditor = DubboTransactionContextEditor.class)
    public String sendMessage(String message) {
        System.out.println("this is sendMessage try message="+message);
        if(message.equals("123")){
            throw new NullPointerException();
        }

        return "quickstart-provider-message="+message;
    }

    @Transactional
    public String confirmSendMessage(String message) {
        String str="-------quick start provider---"+message;
        System.out.println("this is confirmSMessage------"+message);

        return str;
    }

    @Transactional
    public String cancelSendMessage(String message) {
        System.out.println("this is cancleSendMessage------"+message);

        return "989";
    }
}
