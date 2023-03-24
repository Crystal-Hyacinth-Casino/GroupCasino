package com.github.zipcodewilmington.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Common {
    static Scanner scan = new Scanner(System.in);
    public static final String RESET = "\u001b[0m";
    public static final String BLACK = "\u001b[30m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String PURPLE = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";
    public static final String WHITE = "\u001b[37m";

    public static final String BLACK_BG = "\u001b[40m";
    public static final String RED_BG = "\u001b[41m";
    public static final String GREEN_BG = "\u001b[42m";
    public static final String YELLOW_BG = "\u001b[43m";
    public static final String BLUE_BG = "\u001b[44m";
    public static final String PURPLE_BG = "\u001b[45m";
    public static final String CYAN_BG = "\u001b[46m";
    public static final String WHITE_BG = "\u001b[47m";

    public static String black(String string) {
        return (BLACK + string + RESET);
    }
    public static String red(String string) {
        return (RED + string + RESET);
    }
    public static String green(String string) {
        return (GREEN + string + RESET);
    }
    public static String yellow(String string) {
        return (YELLOW + string + RESET);
    }
    public static String blue(String string) {
        return (BLUE + string + RESET);
    }
    public static String purple(String string) {
        return (PURPLE + string + RESET);
    }
    public static String cyan(String string) {
        return (CYAN + string + RESET);
    }
    public static String white(String string) {
        return (WHITE + string + RESET);
    }

    public static String blackBG(String string) {
        return (BLACK_BG + string + RESET);
    }
    public static String redBG(String string) {
        return (RED_BG + string + RESET);
    }
    public static String greenBG(String string) {
        return (GREEN_BG + string + RESET);
    }
    public static String yellowBG(String string) {
        return (YELLOW_BG + string + RESET);
    }
    public static String blueBG(String string) {
        return (BLUE_BG + string + RESET);
    }
    public static String purpleBG(String string) {
        return (PURPLE_BG + string + RESET);
    }
    public static String cyanBG(String string) {
        return (CYAN_BG + string + RESET);
    }
    public static String whiteBG(String string) {
        return (WHITE_BG + string + RESET);
    }

    public static int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scan.next() + "\" isn't a number!\n");
            }
        }
    }

    public static void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}