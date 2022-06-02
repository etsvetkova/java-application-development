package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.DefaultMessages;
import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.saver.LogOperationException;
import com.acme.dbo.txlog.saver.SaveException;
import com.acme.dbo.txlog.saver.SaverWrapper;

public class LogService {
    private final SaverWrapper saver;
    private Message currentAccumulatedMessage;

    public LogService(SaverWrapper saver) {
        this.saver = saver;
        this.currentAccumulatedMessage = new DefaultMessages();
    }

    public void log(Message message) throws LogOperationException {
        try {

            if (currentAccumulatedMessage.isSame(message)) {
                currentAccumulatedMessage = currentAccumulatedMessage.accumulate(message);
            } else {
                saver.save(currentAccumulatedMessage.decorate());
                currentAccumulatedMessage = message;
            }

        } catch (SaveException e) {
            e.printStackTrace();
            throw new LogOperationException("message" + message, e);
        }
    }

    public void flush() throws LogOperationException{
        try {
            saver.save(currentAccumulatedMessage.decorate());
            currentAccumulatedMessage = new DefaultMessages();
        } catch (SaveException e) {
            e.printStackTrace();
            throw new LogOperationException("message is null", e);
        }
    }
}