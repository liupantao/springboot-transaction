package com.springboot.transaction.api;

import org.mengyun.tcctransaction.api.Compensable;

public interface ServerAPI {

    @Compensable
    public String sendMessage(String message);
}
