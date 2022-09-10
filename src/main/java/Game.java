import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<String> registeredPlayers = new ArrayList<>();
    public Player[] players = new Player[0];

    public void register(Player player) {
        registeredPlayers.add(player.getName());
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
    }

    public int str(String searchText) { //find strength from playerName
         for (Player player : players) {
            if (player.matches(player, searchText)) {
                return player.getStrength();
            }
        }
         return 0;
    }
    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        if (registeredPlayers.contains(playerName1) && registeredPlayers.contains(playerName2)) {
            if (str(playerName1) > str(playerName2)) {
                return 1;
            } else {
                if (str(playerName1) < str(playerName2)) {
                    return 2;
                } else {
                    return 0;
                }
            }
        } else {
            throw new NotRegisteredException(
              "Один из игроков не зарегистрирован"
            );
        }
    }
}