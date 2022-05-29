package com.acme.dbo.txlog.message;

public class DefaultMessages implements Message {

    @Override
    public String decorate() {
        return null;
    }

    @Override
    public boolean isSame(Message message) {
        return true;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }
}
