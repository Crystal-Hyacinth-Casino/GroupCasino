package com.github.zipcodewilmington;


import com.github.zipcodewilmington.casino.games.Chuckaluck.Chuckaluck;
import com.github.zipcodewilmington.casino.games.Klondike.Klondike;

import java.io.FileNotFoundException;


public class MainApplication {
    public static void main(String[] args) throws FileNotFoundException {
     Casino main = new Casino();
       main.read();
       main.mainMenu();


    }
}