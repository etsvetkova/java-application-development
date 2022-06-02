package com.acme.dbo.txlog.saver;

public class SaverWrapper {
    private Saver saver;

    public SaverWrapper(Saver saver) {
        this.saver = saver;
    }

    public void save(String message) throws SaveException{
        saver.save(message);
    }
}
