package conda.example.rps_shoot;
import java.util.Random;

public class Computer extends Player {


    public String getComputerChoice() {

        Random rand = new Random();

        // 0, 1, 2
        int random_choice = rand.nextInt(3);

        switch(random_choice) {
            case 0:
                weapon = "rock";
                break;
            case 1:
                weapon = "paper";
                break;
            case 2:
                weapon = "scissors";
                break;
        }

        return weapon;
    }



}
