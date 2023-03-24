package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.ChuckaLuck.ChuckaLuck;
import com.github.zipcodewilmington.casino.games.ChuckaLuck.ChuckaLuckPlayer;
import com.github.zipcodewilmington.casino.games.Klondike.Klondike;
import com.github.zipcodewilmington.casino.games.RPS.RPS;
//import com.github.zipcodewilmington.casino.games.RPS.RpsPlayer;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Casino{
    char input1;
    static Scanner input = new Scanner(System.in);
    private String userName2;
    private String password2;
    public final String ANSI_RED = "\u001B[31m";

    Casino casino;



    public void mainMenu() {



       CasinoAccount newAccount = new CasinoAccount();

        System.out.print("======================\n" +
                "=     Main Menu      =\n"
                + "======================\n"
                + "=      (L)ogin       =\n"
                + "=  (C)reate Account  =\n"
                + "=    (M)ore Info     =\n"
                + "======================\n");


        delay();


        System.out.println("Please input an option");

        while (true) {
            try {
                input1 = input.next().toLowerCase().charAt(0);
                switch (input1) {
                    case 'c':
                        newAccount = CasinoAccountManager.createAccount();
                        mainMenu();
                        break;
                    case 'm':
                        moreInfo();
                        break;
                    case 'l':
                        login();
                        break;

                    default:
                        System.out.println("Invalid Input");

                }


            } catch (InputMismatchException e) {
                System.out.print("Invalid number, Please input Number: ");
                input.nextLine();
            }
        }
    }

    public void moreInfo() {
        System.out.println(
                "=================================\n"
                        + "        Crystal Casino\n"
                        + "          Created by  \n"
                        + "Christa, Tim, Hiep, Andre, Jake\n"
                        + "\n"
                        + "    ZipCode Wilmington 9.4");

        //waits 1 second for next message

        delay();

        //asks user for input

        System.out.println("Press any key to continue");


        while (true) {
            input.next();
            break;
        }
        mainMenu();
    }

    public void login() {


        System.out.println("Welcome to Crystal Casino!");
        CasinoAccountManager account = null;


        // while (true) {
        System.out.print(ANSI_RED + "Please enter your username:");
        userName2 = input.next();

        delay();

        System.out.print(ANSI_RED + "Please enter your password:");
        password2 = input.next();

        boolean loginCheck = false;
        int index = 0;

        for (int i = 0; i < CasinoAccountManager.accountList.size(); i++) {
            if (userName2.equals(CasinoAccountManager.accountList.get(i).getUserName())) {
                if (password2.equals(CasinoAccountManager.accountList.get(i).getPassword())) {
                    loginCheck = true;
                    index = i;
                    break;
                }
            }
        }

        if (loginCheck) {
            System.out.println("Login successful");
            delay();
            checkinLobby(CasinoAccountManager.accountList.get(index).getAccount());
        } else {
            System.out.println("Username or password is incorrect");
            mainMenu();
        }
    }


    public void checkinLobby(CasinoAccount account) {
        CasinoAccount z = account;
        System.out.print(
                "==============================\n"
                        + "=  Welcome to Check in Desk  =\n"
                        + "==============================\n"
                        + "= (E)nter Casino Game Lobby  =\n"
                        + "=       (G)et Balance        =\n"
                        + "=      (D)eposit Money       =\n"
                        + "=        (M)ain Menu         =\n"
                        + "=      (Q)uit and Save       =\n"
                        + "==============================\n");

        delay();

        // asks user for input

        System.out.println("Please input an option");

        input1 = input.next().toLowerCase().charAt(0);
        switch (input1) {
            case 'm':
                mainMenu();
                break;

            case 'g':
                System.out.println("Your balance is: " + account.getBalance());
                delay();
                checkinLobby(z);
                break;

            case 'd':
                System.out.println("How much do you want to deposit?");
                int deposit = input.nextInt();
                account.deposit(deposit);
                System.out.println("Your balance is: " + account.getBalance());
                update(account);
                System.out.println(CasinoAccountManager.accountList);
                delay();
                checkinLobby(z);
                break;

            case 'e':
                gameLobby(z);
                break;
            case 'q':

                quit();
                break;

            default:
                System.out.println("Invalid input");

        }


    }

    public void gameLobby(CasinoAccount account) {
        CasinoAccount z = account;
        System.out.println(z.getBalance());
        System.out.print(
                "=================================\n"
                        + "=     Welcome to Casino Lobby   =\n"
                        + "=================================\n"
                        + "=          (B)lack Jack         =\n"
                        + "=             (S)lots           =\n"
                        + "=          (C)huckALuck         =\n"
                        + "=           (R)oulette          =\n"
                        + "=           (K)londike          =\n"
                        + "=       (P)aperScissorRocks     =\n"
                        + "=        (M)ain Menu/Quit       =\n"
                        + "=================================\n");

        delay();

        // asks user for input

        System.out.println(ANSI_RED + "Please input an option");


        input1 = input.next().toLowerCase().charAt(0);
        switch (input1) {
            case 'm':
                mainMenu();
                break;

            case 'b':
//                BlackJackPlayer blackJackPlayer = new BlackJackPlayer(z);
//                play(new BlackJackGame(), blackJackPlayer);
//                z.setBalance(blackJackPlayer.getBalance());
                break;

            case 's':
                SlotsPlayer slotsPlayer = new SlotsPlayer(z);
                play(new SlotsGame(), slotsPlayer);
                z.setBalance(slotsPlayer.getBalance());
                break;

            case 'c':
                ChuckaLuckPlayer chuckaLuckPlayer = new ChuckaLuckPlayer(z);
                play(new ChuckaLuck(), chuckaLuckPlayer);
                z.setBalance(chuckaLuckPlayer.getBalance());
                break;

            case 'r':
                RoulettePlayer roulettePlayer = new RoulettePlayer(z);
                play(new RouletteGame(), roulettePlayer);
                z.setBalance(roulettePlayer.getBalance());
                break;

            case 'k':
                Klondike klondike = new Klondike();
                klondike.playGame(z);
                break;

            case 'p':
//                RpsPlayer rpsPlayer = new RpsPlayer(z);
//                play(new RPS(), rpsPlayer);
//                z.setBalance(rpsPlayer.getBalance());
//                break;

            default:
                System.out.println("Invalid Input");

        }
    }


    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }


    public static void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + input.next() + "\" isn't a number!\n");
            }
        }
    }

    public void quit() {
        try {
            File file = new File("hiep.txt");
            PrintStream writer = new PrintStream(file);
            for(CasinoAccount s : CasinoAccountManager.accountList){
                if(s != null) {
                    writer.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public void update(CasinoAccount account) {
        for (int i = 0; i < CasinoAccountManager.accountList.size(); i++) {
            if (userName2.equals(CasinoAccountManager.accountList.get(i).getUserName())) {
                CasinoAccountManager.accountList.set(i, account);
            }
        }
    }

    public void read() throws FileNotFoundException {
        Scanner read = new Scanner(new File("hiep.txt"));
        String[] line;

        String username;
        String password;
        Integer balance = 0;

        while(read.hasNext()) {
            line = read.next().split(",");

            username = line[0];
            password = line[1];
            balance = Integer.parseInt(line[2]);
            CasinoAccount account = new CasinoAccount(username, password, balance);
            CasinoAccountManager.accountList.add(account);

        }

    }



}
