package com.acme.dbo.txlog;

import java.util.Arrays;

public class MessageDecorator {

    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";
    private static final String PRIMITIVE_MULTI_MATRIX_PREFIX = "primitives multimatrix: ";
    private static final String STRING_POSTFIX = " (x";

    public static String decorateMessageWithPrefix(String message)
    {
        return STRING_PREFIX + message;
    }

    public static String decorateMessageWithPostfix(String message, int counter)
    {
        return message + STRING_POSTFIX + counter + ")";
    }

    public static String decorateMessageWithPrefix(char message)
    {
        return CHAR_PREFIX + message;
    }

    public static String decorateMessageWithPrefix(byte message)
    {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorateMessageWithPrefix(int message)
    {
        return PRIMITIVE_PREFIX + message;
    }
    public static String decorateMessageWithPrefix(boolean message)
    {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorateMessageWithPrefix(Object message)
    {
        return REFERENCE_PREFIX + message;
    }

    public static String decorateMessageWithPrefix(int [] message) {
        return PRIMITIVE_ARRAY_PREFIX + convertArrayToString(message);
    }

    public static String decorateMessageWithPrefix(int [][] message) {
        StringBuilder matrix = convertMatrixToString(message);

        return PRIMITIVE_MATRIX_PREFIX + matrix;
    }

    private static StringBuilder convertMatrixToString(int[][] message) {
        StringBuilder matrix = new StringBuilder();
        matrix.append("{\n");
        for (int [] array : message) {
            matrix.append(convertArrayToString(array));
            matrix.append("\n");
        }
        matrix.append("}");
        return matrix;
    }

    public static String decorateMessageWithPrefix(int [][][][] message) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (int [][][] multimatrix : message) {
            result.append("{\n");
            for (int [][] matrix : multimatrix) {
                result.append(convertMatrixToString(matrix));
                result.append("\n");
            }
            result.append("}\n");
        }
        result.append("}");

        return PRIMITIVE_MULTI_MATRIX_PREFIX + result;
    }


    private static String convertArrayToString(int[] array) {
        String intArrayString = Arrays.toString(array);
        intArrayString = intArrayString.replace("[", "{").replace("]","}");

        return intArrayString;
    }

}
