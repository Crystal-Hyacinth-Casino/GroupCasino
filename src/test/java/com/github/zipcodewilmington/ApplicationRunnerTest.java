package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 7/21/2020.
 */
public class ApplicationRunnerTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        //given
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when
        hiep.deposit(500);
        int expected = 1500;

        //then
        Assert.assertEquals(expected, hiep.getBalance());
    }

    @org.junit.jupiter.api.Test
    void getUserName() {
        //given
        CasinoAccount hiep = new CasinoAccount("ZipCode", "rocks", 1000);

        //when

        //then
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
    }

    @org.junit.jupiter.api.Test
    void getAccount() {

    @Test
    public void test() { // TODO - replace boiler-plate logic with business logic
        // given
        //Runnable runnable = new Casino();

        // when
        //runnable.run();

        // then
        //Assert.assertNotNull(runnable.toString());

    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
    }

    @Test
    void setBalance() {
    }

}
