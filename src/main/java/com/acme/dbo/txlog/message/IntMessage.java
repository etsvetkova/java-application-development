package com.acme.dbo.txlog.message;

public class IntMessage extends PrefixDecoratingMessage {
    private int value;

    public IntMessage(int value) {
        super("primitive: ");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String decorate() {
        return super.decorate(String.valueOf(value));
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public Message accumulate(Message message) {
        this.value += ((IntMessage)message).getValue();
        return this;
    }
}
