package Class3_2208_2;

public class Team {
    private final String name;
    private final String baseLocation;
    private final String coachName;
    private final Player[] playerArray;
    private int playerCount;
    private Player captain;
    private final int MAX_PLAYERS = 18;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.playerArray = new Player[MAX_PLAYERS];
        this.playerCount = 0;
    }

    public void addPlayer(Player player){
        if (playerCount < MAX_PLAYERS){
            playerArray[playerCount] = player;
            playerCount++;
        } else {
            System.out.printf("Team %s is full! Player was not added.%n", name);
        }
    }

    public void removePlayer(Player player){
        boolean found = false;
        if (playerCount > 0){
            for (int i = 0; i < playerCount; i++){
                if (playerArray[i] == player){
                    found = true;
                    for (int j = i; j <playerCount - 1; j++){
                        playerArray[j] = playerArray[j+1];
                    }
                    playerCount--;
                    break;
                }
            }
            if (!found){
                System.out.printf("Player was not found in team %s!.%n", name);
            }
        } else {
            System.out.printf("Team %s is empty!", name);
        }
    }

    public void substitute(Player substitute, Player starter){
        boolean found = false;
        if (playerCount > 0){
            for (int i = 0; i < playerCount; i++){
                if (playerArray[i] == starter){
                    found = true;
                    starter.outfieldIt();
                    substitute.fieldIt();
                    addPlayer(substitute);
                    break;
                }
            }
            if (!found){
                System.out.printf("Starter player was not found in team %s!.%n", name);
            }
        } else {
            System.out.printf("Team %s is empty!", name);
        }
    }

    public void setCaptain(Player captain){
        this.captain = captain;
    }

    public Player getCaptain(){
        return captain;
    }

    public Player[] getFieldedPlayers(){
        Player[] fieldedPlayers = new Player[playerCount];
        for (int i = 0; i < playerCount; i++){
            if (playerArray[i].getIsFielded()){
                fieldedPlayers[i] = playerArray[i];
            }
        }
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers(){
        Player[] outfieldedPlayers = new Player[playerCount];
        for (int i = 0; i < playerCount; i++){
            if (!playerArray[i].getIsFielded()){
                outfieldedPlayers[i] = playerArray[i];
            }
        }
        return outfieldedPlayers;
    }

    public String getStateAsString(){
        return String.format("Name: %s%nBaseLocation: %s%nCoachName: %s%n", name, baseLocation, coachName);
    }
}
