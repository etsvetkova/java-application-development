package com.acme.dbo.txlog.saver;

import java.io.IOException;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String message) throws SaveException{
        if (message == null) {
            throw new SaveException("message is null");
        }
        System.out.println(message);
    }
}
