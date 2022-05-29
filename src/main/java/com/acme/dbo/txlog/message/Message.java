package com.acme.dbo.txlog.message;

public interface Message {

   String decorate();
   boolean isSame(Message message);
   Message accumulate(Message message);
}
