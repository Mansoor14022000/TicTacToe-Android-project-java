package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btnrst;
    TextView headertxt;
    int player_X = 1;
    int player_O = 0;
    int activePlayer = player_O;

    int[] filledps = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headertxt = findViewById(R.id.textView);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btnrst= findViewById(R.id.btnrst);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

        btnrst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reStartGame();
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onClick(View v) {

        if (!isGameActive)
            return;
        Button clickedBtn = findViewById(v.getId());
        int clickedtag = Integer.parseInt(v.getTag().toString());

        if (filledps[clickedtag] != -1) {
            return;
        }
        filledps[clickedtag] = activePlayer;


        if (activePlayer == player_O) {
            clickedBtn.setText("O");
            activePlayer = player_X;
            headertxt.setText("X turn");
            clickedBtn.setBackground(getDrawable(android.R.color.holo_blue_bright));

        } else {
            clickedBtn.setText("X");
            activePlayer = player_O;
            headertxt.setText("O turn");
            clickedBtn.setBackground(getDrawable(android.R.color.holo_orange_light));

        }
     checkWin();
    }

    private void checkWin() {
        //winner check

        int[][] checkwinner = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        for (int i = 0; i < 8; i++) {
            int val0 = checkwinner[i][0];
            int val1 = checkwinner[i][1];
            int val2 = checkwinner[i][2];

            if (filledps[val0] == filledps[val1] && filledps[val1] == filledps[val2]) {
                if (filledps[val0] != -1) {
                    //game winner declare
                    isGameActive = false;
                    if (filledps[val0] == player_O)
                        showDialog("O is winner");

                    else
                        showDialog("X is Winner");


                }


            }

        }
    }

    private void showDialog(String winnerTxt){
        new AlertDialog.Builder(this)
                .setTitle(winnerTxt)
                .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     reStartGame();
                    }
                }).show();

    }

    private void  reStartGame(){
      activePlayer= player_O;
      filledps= new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       headertxt.setText("O turn");
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        isGameActive= true;
        btn0.setBackground(getDrawable(android.R.color.background_light));
        btn1.setBackground(getDrawable(android.R.color.background_light));
        btn2.setBackground(getDrawable(android.R.color.background_light));
        btn3.setBackground(getDrawable(android.R.color.background_light));
        btn4.setBackground(getDrawable(android.R.color.background_light));
        btn5.setBackground(getDrawable(android.R.color.background_light));
        btn6.setBackground(getDrawable(android.R.color.background_light));
        btn7.setBackground(getDrawable(android.R.color.background_light));
        btn8.setBackground(getDrawable(android.R.color.background_light));

    }





}
