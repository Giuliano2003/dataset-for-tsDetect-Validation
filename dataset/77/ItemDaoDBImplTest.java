
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jimmy Cook
 */
public class ItemDaoDBImplTest {
    
    private ItemDao testDao;
    
    public ItemDaoDBImplTest() {
    }
    

    @Before
    public void setUp() {
        
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testDao = (ItemDao) ctx.getBean("itemDao");
        
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("DELETE FROM Items");
    }
    
    
    Item[] itemsForTesting = {
        new Item(-1, "Snickers", 1.75, 10),
        new Item(-1, "Chips", 2.75, 45),
        new Item(-1, "PayDay", 0.75, 3454),
        new Item(-1, "Cheese Crackers", 1.15, 12),
        new Item(-1, "Cookies", 1.25, 1),
        new Item(-1, "5th Avenue", 1.20, 0),
    };

    Item[] duplicateItems = {
        new Item(-1, "Snickers", 1.75, 10),
        new Item(-1, "Chips", 2.75, 45),
        new Item(-1, "PayDay", 0.75, 3454),
        new Item(-1, "Cheese Crackers", 1.15, 12),
        new Item(-1, "Cookies", 1.25, 1),
        new Item(-1, "5th Avenue", 1.20, 0),
    };

    Item[] similarItems = {
        new Item(-1, "Mars", 2.75, 3),
        new Item(-1, "M&Ms", 5.70, 8),
        new Item(-1, "Gummy Worms", 12.75, 4),
        new Item(-1, "Sour Patch Kids", 3.15, 0),
        new Item(-1, "Gum", 1.65, 7),
        new Item(-1, "Fastbreak", 1.24, 4),
    };
    
    @Test
    public void testAgainstEmptyDAO() {

        Assert.assertNull("Asking for a non existant item should return null.", testDao.getItemById(445));
        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' is nonzero with empty DAO.", 0, testDao.getAllItems().size());
    }

    @Test
    public void testAddOneItem() {
        Item itemToAdd = itemsForTesting[0];
        testDao.addItem(itemToAdd);

        Assert.assertEquals("Returned item does not match expected.", itemToAdd, testDao.getItemById(itemToAdd.getId()));
        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding one item.", 1, testDao.getAllItems().size());
        Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(itemToAdd));

    }


    
    
}
