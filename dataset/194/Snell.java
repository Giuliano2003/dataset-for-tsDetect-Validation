public class Club{

  private String name;
  private Player[] team;

  public Club(String name){
    this.name = name;
    this.team = new Player[13];
  }

  public String getName(){
    return this.name;
  }

  public int playerCount(){
    int counter = 0;  
    for(Player player : team){
      if(player != null){
        counter++;
      }
    } 
    return counter;
  }

  public void pick(Player player){
    if (teamComplete()) return;
   int playerCount = playerCount();
   team[playerCount] = player;
  }

  public boolean teamComplete(){
   return playerCount() == team.length;
  }

  public void postMatch(){
    for(int i = 0; i < team.length; i++){
      team[i] = null;
    } 
  }

}