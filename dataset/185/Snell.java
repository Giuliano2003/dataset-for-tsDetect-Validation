public class Bus {

  private Person[] passengers;

  public Bus() {
    this.passengers = new Person[18];
  }

  public int passengerCount() {
    int numberOfPassengers = 0;
    for (Person person : this.passengers) {
      if (person != null) {
        numberOfPassengers++;
      }
    }
    return numberOfPassengers;
  }

  public void addPassenger(Person person) {
    if (isBusFull()) return;
    int index = passengerCount();
    this.passengers[index] = person;
  }

  public boolean isBusFull() {
    return passengerCount() == this.passengers.length;
  }

  public void empty() {
    for (int i = 0; i < this.passengers.length; i++) {
      this.passengers[i] = null;
    }
  }
}