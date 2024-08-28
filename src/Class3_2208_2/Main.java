package Class3_2208_2;

public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Loud", "Brazil", "Stardust");

        Player player1 = new Player("Robô", 1, "Top", true);
        Player player2 = new Player("Croc", 2, "Jungle", true);
        Player player3 = new Player("Tinows", 3, "Mid", true);
        Player player4 = new Player("Route", 4, "Adc", true);
        Player player5 = new Player("Redbert", 5, "Suporte", true);
        Player player6 = new Player("Ceos", 6, "Jungle", false);
        Player player7 = new Player("Mytka", 7, "Top", false);
        Player player8 = new Player("Storm", 8, "Suporte", false);

        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        team1.addPlayer(player5);
        team1.addPlayer(player6);
        team1.addPlayer(player7);

        team1.setCaptain(player1);

        System.out.println("Fielded Players:\n");
        for (Player player : team1.getFieldedPlayers()){
            if (player != null) {
                System.out.println(player.getStateAsString());
            }
        }

        System.out.println("=================================\n");

        System.out.println("Outfielded Players:\n");
        for (Player player : team1.getOutfieldedPlayers()){
            if (player != null) {
                System.out.println(player.getStateAsString());
            }
        }

        team1.removePlayer(player3);
        team1.removePlayer(player6);
        team1.substitute(player8, player5);

        System.out.println("=================================\n");

        System.out.println("Fielded Players:\n");
        for (Player player : team1.getFieldedPlayers()){
            if (player != null) {
                System.out.println(player.getStateAsString());
            }
        }

        System.out.println("=================================\n");

        System.out.println("Outfielded Players:\n");
        for (Player player : team1.getOutfieldedPlayers()){
            if (player != null) {
                System.out.println(player.getStateAsString());
            }
        }

        System.out.println("=================================\n");
        System.out.println("Capitão do time: ");
        System.out.println(team1.getCaptain().getStateAsString());
        System.out.println("Informações do time: ");
        System.out.println(team1.getStateAsString());
    }
}