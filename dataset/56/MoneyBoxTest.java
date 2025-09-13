package com.techelevator.view;

import com.techelevator.MoneyBox;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyBoxTest {



    @Test
    public void MoneyBox_FeedMoney_ResetToZero(){
        MoneyBox moneyBox = new MoneyBox();
        moneyBox.addMoney(BigDecimal.valueOf(10));
        moneyBox.makeChange();
        BigDecimal bd = BigDecimal.valueOf(0.00);

        assertTrue(bd.compareTo(moneyBox.getMoneyHeld()) == 0);
    }

}