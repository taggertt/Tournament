import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Game {

    public HashMap<String, Integer> registeredPlayers = new HashMap<>();
    public Player[] players = new Player[0];

    public void register(Player player) {
        registeredPlayers.put(player.getName(), player.getStrength());
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        if (registeredPlayers.containsKey(playerName1) && registeredPlayers.containsKey(playerName2)) {
            if (registeredPlayers.get(playerName1) > registeredPlayers.get(playerName2)) {
                return 1;
            } else {
                if (registeredPlayers.get(playerName1) < registeredPlayers.get(playerName2)) {
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