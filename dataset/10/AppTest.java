
package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

/* https://github.com/heischichou/IT3202-Testing-with-Java/blob/main/src/test/AppTest.java */

public class AppTest {
  @Test
  public void randomNumberDoesNotExceedCeiling(){
    int number = App.generateRand();

    assertTrue(number >= 0 && number <= 13);
  }
  
}
