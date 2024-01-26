package conda.example.rps_shoot;

public class Player {

    protected String playerName;
    public String weapon;
    public int numOfWins = 0;
    public int score;


    Player(String name) {

        playerName = name;
    }

    Player() {}

}
