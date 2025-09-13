import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class BusTest {
  Bus bus;
  Person person;

  @Before
  public void before() {
    bus = new Bus();
    person = new Person();
  }

  @Test
  public void busStartsEmpty() {
    assertEquals(0, bus.passengerCount());
  }

  @Test
  public void canAddPassenger() {
    bus.addPassenger(person);
    assertEquals(1, bus.passengerCount());
  }

  @Test
  public void busIsFull() {
    for (int i = 0; i < 18; i++) {
      bus.addPassenger(person);
    }
    assertEquals(true, bus.isBusFull());
  }

  @Test
  public void cannotAddPersonWhenBusIsFull() {
    for (int i = 0; i < 21; i++) {
      bus.addPassenger(person);
    }
    assertEquals(18, bus.passengerCount());
  }

  @Test
  public void busCanEmpty() {
    bus.addPassenger(person);
    bus.empty();
    assertEquals(0, bus.passengerCount());
  }
}