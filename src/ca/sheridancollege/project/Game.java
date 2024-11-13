package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;

    public Game(String name) {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
