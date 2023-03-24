package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class ApplicationRunnerTest {

    @org.junit.jupiter.api.Test


    @Test
    void deposit() {
        //given
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        hiep.deposit(500);
        int expected = 1500;

        //then
        Assert.assertEquals(expected, hiep.getBalance());

    }

    @Test
    void getUserName() {
        //given
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        String expected = "ZipCode";


        //then
        Assert.assertEquals(expected, hiep.getUserName());
    }

    @Test
    void getPassword() {
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        String expected = "rocks";


        //then
        Assert.assertEquals(expected, hiep.getPassword());
    }

    @Test
    void getAccount() {
        ArrayList <CasinoAccount> tiger = new ArrayList<>();
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        tiger.add(hiep);
        String expected = "ZipCode,rocks,1000";
        String actual = hiep.getAccount().toString();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        ArrayList <CasinoAccount> tiger = new ArrayList<>();
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        tiger.add(hiep);
        String expected = "ZipCode,rocks,1000";
        String actual = hiep.getAccount().toString();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getBalance() {
        ArrayList <CasinoAccount> tiger = new ArrayList<>();
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        tiger.add(hiep);
        Integer expected = 1000;
        Integer actual = hiep.getBalance();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void setBalance() {
        ArrayList <CasinoAccount> tiger = new ArrayList<>();
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        tiger.add(hiep);
        Integer expected = 1500;
        hiep.setBalance(1500);
        Integer actual = hiep.getBalance();

        //then
        Assert.assertEquals(expected, actual);

    }


}
