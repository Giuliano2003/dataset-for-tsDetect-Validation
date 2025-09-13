import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BusStopTest{

  private BusStop busStop;
  private Bus bus;
  private Person person;

  @Before
  public void setup(){
    this.busStop = new BusStop();
    this.bus = new Bus(10);
    this.person = new Person("Andrew");
    this.bus.add(this.person);
  }

  @Test
  public void setAndGetBusAtStop(){
    busStop.setBusAtStop(bus);
    assertEquals(bus, busStop.getBusAtStop());
    assertEquals(null, busStop.getBusAtStop());
  }

  @Test
  public void checkNumberOfPeopleAtBusStop(){
    busStop.addPerson(person);
    assertEquals(1, busStop.countPeople());
    busStop.addPerson(person);
    assertEquals(2, busStop.countPeople());
  }

  @Test
  public void getPersonOffBus(){
    int preBusPassengerCount = bus.getPassengerCount();
    int preBusStopPeopleCount = busStop.countPeople();
    busStop.setBusAtStop(bus);
    busStop.getPersonOffBus();
    assertEquals(preBusPassengerCount - 1, bus.getPassengerCount());
    assertEquals(preBusStopPeopleCount + 1, busStop.countPeople());
  }


}