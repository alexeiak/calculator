package controller;

public class Utils {
    public static String deleteAllSpaces(String expression) {
        return expression.replaceAll("\\s+", "");
    }
}
