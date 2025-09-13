public class Bus{

  private Person[] passengers;

  public Bus(int size){
    this.passengers = new Person[size];
  }

  public int getPassengerCount(){
    int count = 0;
    for(int j=0; j<passengers.length; j++){
      if(passengers[j] == null){
        break;
      }
      count += 1;
    }
    return count;
  }

  public void add(Person person){
    int count = getPassengerCount();
    this.passengers[count] = person;
  }

  public Person removePassenger(){
    int index = getPassengerCount()-1;
    if(index < 0){
      return null;
    }
    Person tempPerson = this.passengers[index];
    this.passengers[index] = null;
    return tempPerson;
  }

  public boolean isBusFull(){
    return getPassengerCount() == this.passengers.length;
  }
}