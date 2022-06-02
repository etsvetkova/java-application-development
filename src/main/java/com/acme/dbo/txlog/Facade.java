package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.saver.ConsoleSaver;
import com.acme.dbo.txlog.saver.LogOperationException;
import com.acme.dbo.txlog.saver.SaverWrapper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import static com.acme.dbo.txlog.MessageDecorator.decorateMessageWithPostfix;
import static com.acme.dbo.txlog.MessageDecorator.decorateMessageWithPrefix;
import static com.acme.dbo.txlog.Printer.printToConsole;

public class Facade {
    private static String currentStrMessage = "";
    private static int currentIntMessage = 0;
    private static int strCounter = 0;
    private static int intCounter = 0;

    private static LogService service = new LogService(new SaverWrapper(new ConsoleSaver()));

    public static void log(int intMessage) throws LogOperationException {
        service.log(new IntMessage(intMessage));
    }

    public static void log(String strMessage) throws LogOperationException{
        service.log(new StringMessage(strMessage));
    }

    public static void printAndFlushInt() throws LogOperationException{
      service.flush();
    }

    public static void printAndFlushStr() throws LogOperationException {
        printAndFlushInt();
    }

    public static void log(byte message) {
        printToConsole(decorateMessageWithPrefix(message));
    }

    public static void log(char message) {
        printToConsole(decorateMessageWithPrefix(message));
    }

    public static void log(boolean message) {
        printToConsole(decorateMessageWithPrefix(message));
    }

    public static void log(Object message) {
        printToConsole(decorateMessageWithPrefix(message));
        if (message instanceof int [][][][]) {
            printToConsole(decorateMessageWithPrefix((int[][][][]) message));
        } if (message instanceof int [][]) {
            printToConsole(decorateMessageWithPrefix((int [][])message));
        } else {
            printToConsole(decorateMessageWithPrefix(message));
        }
    }

    public static void close() throws LogOperationException {
        printAndFlushInt();
    }

    public static void log(int[][] message) {
        printToConsole(decorateMessageWithPrefix(message));
    }

    public static void log(int[][][][] message) {
        printToConsole(decorateMessageWithPrefix(message));
    }

    public static void log(String ... message) {
        for (String str : message) {
            printToConsole(str);
        }
    }

    public static void log (int ... message) {
        printToConsole(decorateMessageWithPrefix(message));
    }

}
