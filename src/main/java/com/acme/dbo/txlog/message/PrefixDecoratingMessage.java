package com.acme.dbo.txlog.message;

public abstract class PrefixDecoratingMessage  implements Message {
    private String prefix;

    protected PrefixDecoratingMessage(String prefix) {
        this.prefix = prefix;
    }

    protected String decorate(String value) {
        return this.prefix + value;
    }
}
