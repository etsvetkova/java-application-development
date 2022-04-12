package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.FormatMessage.*;

public class Facade {
    private static void printToConsole(String message) {
        System.out.println(message);
    }

    public static void log(int message) {
        printToConsole(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        printToConsole(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        printToConsole(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        printToConsole(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        printToConsole(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printToConsole(REFERENCE_PREFIX + message);
    }
}
