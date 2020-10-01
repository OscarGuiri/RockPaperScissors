package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private ImageView mystery;

    private Button rock;
    private Button paper;
    private Button scissors;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1 for ROCK, 2 for PAPER, 3 por SCISSORS


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mystery = findViewById(R.id.iMystery);
        result = findViewById(R.id.tvResult);
        rock = findViewById(R.id.bRock);
        paper = findViewById(R.id.bPaper);
        scissors = findViewById(R.id.bScissors);

        // Boton del roca
        rock.setOnClickListener(new View.OnClickListener() {
            Random r = new Random();
            int userDecition = 0;
            int cpuDecition = 0;
            @Override
            public void onClick(View v) {
                userDecition = 1;
                cpuDecition = r.nextInt(4 - 1) + 1;
                setMystery(cpuDecition);
                result.setText(getResult(userDecition, cpuDecition));

            }
        });
        //Boton de papel
        paper.setOnClickListener(new View.OnClickListener() {
            Random r = new Random();
            int userDecition = 0;
            int cpuDecition = 0;
            @Override
            public void onClick(View v) {
                userDecition = 2;
                cpuDecition = r.nextInt(4 - 1) + 1;

                setMystery(cpuDecition);
                result.setText(getResult(userDecition, cpuDecition));

            }
        });
        //boton de tijeras
        scissors.setOnClickListener(new View.OnClickListener() {
            Random r = new Random();
            int userDecition = 0;
            int cpuDecition = 0;
            @Override
            public void onClick(View v) {
                userDecition = 3;
                cpuDecition = r.nextInt(4 - 1) + 1;
                setMystery(cpuDecition);
                result.setText(getResult(userDecition, cpuDecition));

            }
        });

    }

    /**
     * cambia el icono de la imagen dependiendo del decicion de cpu
     * @param cpuDecition
     */
    public void setMystery(int cpuDecition) {
        final int idMystery = getResources().getIdentifier("mystery", "drawable", getPackageName());
        final int idRock = getResources().getIdentifier("rock", "drawable", getPackageName());
        final int idPaper = getResources().getIdentifier("paper", "drawable", getPackageName());
        final int idScissors = getResources().getIdentifier("scissors", "drawable", getPackageName());

        if (cpuDecition == 1) {
            mystery.setImageResource(idRock);
        } else if (cpuDecition == 2) {
            mystery.setImageResource(idPaper);

        } else if (cpuDecition == 3) {
            mystery.setImageResource(idScissors);

        } else {
            mystery.setImageResource(idMystery);
        }
    }

    /**
     * Consigue le resultado de los deciciones
     * @param userDecition
     * @param cpuDecition
     * @return
     */
    public String getResult(int userDecition, int cpuDecition) {

        if (userDecition == cpuDecition) {
            return "EMPATE!";
        } else if (userDecition == 1 && cpuDecition == 2) {
            return "HAS PERDIDO";
        } else if (userDecition == 2 && cpuDecition == 1) {
            return "HAS GANADO";
        } else if (userDecition == 3 && cpuDecition == 1) {
            return "HAS PERDIDO";
        } else if (userDecition == 1 && cpuDecition == 3) {
            return "HAS GANADO";
        } else if (userDecition == 2 && cpuDecition == 3) {
            return "Has perdido";
        } else if (userDecition == 3 && cpuDecition == 2) {
            return "Has ganado!";
        }
        return "ERROR GET RESULT";
    }
}