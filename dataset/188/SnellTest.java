import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BusTest{

  private Bus bus;
  private Person person;

  @Before
  public void setup(){
    this.bus = new Bus(10);
    this.person = new Person("Andrew");
  }

  @Test
  public void getPassengerCount(){
    assertEquals(0, bus.getPassengerCount());
  }

  @Test
  public void addToBus(){
    bus.add(person);
    assertEquals(1, bus.getPassengerCount());
  }

  @Test
  public void checkIfBusIsFull(){
    for(int j=0; j<9; j++){
      bus.add(person);
    }
    assertEquals(false, bus.isBusFull());
    bus.add(person);
    assertEquals(true, bus.isBusFull());
  }

  @Test
  public void getPersonOffBus(){
    bus.add(person);
    int preRemoveCount = bus.getPassengerCount();
    bus.removePassenger();
    assertEquals(preRemoveCount-1, bus.getPassengerCount());
  }

}