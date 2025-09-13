
package com.ocado.basket;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/* https://github.com/WerWojtas/Basket-Project/blob/master/src/test/java/com/ocado/basket/BasketSplitterTest.java*/

public class BasketSplitterTest {

    @Test
    public void getSubsetsTest(){
        BasketSplitter splitter = new BasketSplitter("src/main/resources/config.json");
        List<String>[] subsets = splitter.getSubsets();
        List<String> result = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        assertEquals(subsets[0], result);
        List<String> result_2 = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "12", "13", "14", "15", "16", "17", "18", "19", "23", "24", "25", "26", "27", "28", "29", "34", "35", "36", "37", "38", "39", "45", "46", "47", "48", "49", "56", "57", "58", "59", "67", "68", "69", "78", "79", "89");
        assertEquals(subsets[1], result_2);
        assertEquals(subsets[2].size(), 120);
        assertEquals(subsets[7].get(11),"01235679");
    }

}
