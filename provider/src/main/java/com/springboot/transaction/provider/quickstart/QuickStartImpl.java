package com.springboot.transaction.provider.quickstart;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.transaction.api.ServerAPI;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = ServerAPI.class)
public class QuickStartImpl implements ServerAPI {
   @Override
    public String sendMessage(String message) {
        String str="-------quick start provider---"+message;
        return str;
    }
}
