package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.DefaultMessages;
import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.saver.ConsoleSaver;
import com.acme.dbo.txlog.saver.Saver;

public class LogService {
    private final Saver saver;
    private Message currentAccumulatedMessage;

    public LogService(Saver saver) {
        this.saver = saver;
        this.currentAccumulatedMessage = new DefaultMessages();
    }

    public void log(Message message) {
        if (currentAccumulatedMessage.isSame(message)) {
            currentAccumulatedMessage = currentAccumulatedMessage.accumulate(message);
        } else {
            saver.save(currentAccumulatedMessage.decorate());
            currentAccumulatedMessage = message;
        }
    }

    public void flush() {
        saver.save(currentAccumulatedMessage.decorate());
        currentAccumulatedMessage = new DefaultMessages();
    }
}