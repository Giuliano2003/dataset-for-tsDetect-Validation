public class BusStop{

  private Person[] people;
  private Bus busAtStop;

  public BusStop(){
    this.people = new Person[30];
  }

  public void setBusAtStop(Bus bus){
    this.busAtStop = bus;
  }

  public Bus getBusAtStop(){
    Bus tempBus = this.busAtStop;
    this.busAtStop = null;
    return tempBus;
  }

  public void addPerson(Person person){
    int index = countPeople();
    if(index < people.length){
      people[index] = person;
    }
  }

  public int countPeople(){
    int count = 0;
    for(int j=0; j<people.length; j++){
      if(people[j] == null){
        break;
      }
      count += 1;
    }
    return count;
  }

  public void getPersonOffBus(){
    int index = countPeople();
    people[index] = busAtStop.removePassenger();
  }

}