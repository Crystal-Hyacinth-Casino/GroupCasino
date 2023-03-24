package com.github.zipcodewilmington.casino;



import java.util.Scanner;


public class CasinoAccount {


    private Integer balance;
    private String username;
    private String password;



    Integer balance;
    String username;
    String password;

    char input1 = 'Z';
    Scanner input = new Scanner(System.in);

    public CasinoAccount(){
    }


    public CasinoAccount(String username, String password, Integer balance){
        this.username = username;
        this.password = password;
        this.balance = balance;

    }

    public CasinoAccount(CasinoAccount casinoAccountOther) {
        this.username = casinoAccountOther.getUserName();
        this.password = casinoAccountOther.getPassword();
        this.balance = casinoAccountOther.getBalance();
    }

    public void deposit(int deposit){
        this.balance = balance + deposit;
    }

    public void remove(int remove) {this.balance = balance - remove; }
    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public CasinoAccount getAccount(){
        CasinoAccount account = new CasinoAccount(username, password, balance);
        return account;
    }

    public String toString(){
        return username + "," + password + "," + balance;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }



}

