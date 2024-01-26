package conda.example.rps_shoot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageView rock_image, paper_image,scissors_image;
    public TextView playerChoiceTxtView, computerChoiceTxtView, gameOutcomeTxtView;
    public String computerWeapon;
    public Computer computer = new Computer();
    public Player player1 = new Player("player1");
    public boolean gameRoundPlayed = false;
    public Button endGameBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock_image = findViewById(R.id.rockImg);
        paper_image = findViewById(R.id.paperImg);
        scissors_image = findViewById(R.id.scissorsImg);

        playerChoiceTxtView = findViewById(R.id.playerChoiceTxtView);
        computerChoiceTxtView = findViewById(R.id.computerChoiceTxtView);
        gameOutcomeTxtView = findViewById(R.id.gameOutcome);
        endGameBtn = findViewById(R.id.endGameBtn);

        endGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearGame();
                String outcome;
                if(player1.score > computer.score) {
                    outcome = "You Won! Final Score: " + player1.score;
                }
                else if(player1.score < computer.score) {
                    outcome = "You Lose! Final Score: " + player1.score;
                }
                else {
                    outcome = "Tie Game!";
                }
                gameOutcomeTxtView.setText("Game Over! " + outcome);
                Toast.makeText(MainActivity.this, "Game Over! " + outcome, Toast.LENGTH_SHORT).show();


                // game over, reset score
                computer.score = 0;
                player1.score = 0;
            }
        });


        rock_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player1.weapon = "rock";
                if(gameRoundPlayed == true)
                {
                    clearGame();
                }
                playGame();
            }
        });


        paper_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player1.weapon = "paper";
                if(gameRoundPlayed == true)
                {
                    clearGame();
                }
                playGame();

            }
        });


        scissors_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player1.weapon = "scissors";
                if(gameRoundPlayed == true)
                {
                    clearGame();
                }
                playGame();

            }
        });

    }

    public void playGame() {

        computerWeapon = computer.getComputerChoice();

        playerChoiceTxtView.setText(playerChoiceTxtView.getText() + player1.weapon);
        computerChoiceTxtView.setText(computerChoiceTxtView.getText() + computerWeapon);
        gameRoundPlayed = true;

        gameLogic();

    }

    public void clearGame() {
        // clear the text on screen
        gameRoundPlayed = false;
        playerChoiceTxtView.setText("Player Choice: ");
        computerChoiceTxtView.setText("Computer Choice: ");
        gameOutcomeTxtView.setText("");

    }

    public void gameLogic() {

        if (player1.weapon == "rock") {

            if (computerWeapon == "rock") {

                gameOutcomeTxtView.setText("Tie!");
            }


            if (computerWeapon == "paper") {

                gameOutcomeTxtView.setText("You Lost!");
                computer.score += 1;

            }
            if (computerWeapon == "scissors") {

                gameOutcomeTxtView.setText("You Won!");
                player1.score += 1;

            }

        }

        if (player1.weapon == "paper") {

            if (computerWeapon == "paper") {

                gameOutcomeTxtView.setText("Tie!");
            }


            if (computerWeapon == "scissors") {

                gameOutcomeTxtView.setText("You Lost!");
                computer.score += 1;

            }
            if (computerWeapon == "rock") {

                gameOutcomeTxtView.setText("You Won!");
                player1.score += 1;

            }

        }

        if (player1.weapon == "scissors") {

            if (computerWeapon == "scissors") {

                gameOutcomeTxtView.setText("Tie!");
            }


            if (computerWeapon == "rock") {

                gameOutcomeTxtView.setText("You Lost!");
                computer.score += 1;

            }
            if (computerWeapon == "paper") {

                gameOutcomeTxtView.setText("You Won!");
                player1.score += 1;

            }

        }



    }




}