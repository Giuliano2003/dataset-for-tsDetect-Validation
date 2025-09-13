public class BusStop {

  private Person[] queue;

  public BusStop() {
    this.queue = new Person[10];
  }

  public int queueCount() {
    int lengthOfQueue = 0;
    for (Person person : this.queue) {
      if (person != null) {
        lengthOfQueue++;
      }
    }
    return lengthOfQueue;
  }

  public void addPerson(Person person) {
    if (isBusStopFull()) return;
    int index = queueCount();
    this.queue[index] = person;
  }

  public boolean isBusStopFull() {
    return queueCount() == this.queue.length;
  }

  public void removePerson() {
    if (queueCount() == 0) return;
    int index = queueCount() - 1;
    this.queue[index] = null;
  }

  public void addPassengerToBus(Bus bus, Person person) {
    removePerson();
    bus.addPassenger(person);
  }

  public void addWholeQueueToBus(Bus bus, Person person) {
    int index = queueCount() - 1;
    for (Person person : this.queue) {
      if (this.queue[index] != null) {
        addPassengerToBus(bus, person);
      }  
    } 
  }
}