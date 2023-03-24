package com.github.zipcodewilmington;

import java.io.FileNotFoundException;


public class MainApplication {
    public static void main(String[] args) throws FileNotFoundException {
        Casino main = new Casino();

        main.read();
    main.mainMenu();


    }
}