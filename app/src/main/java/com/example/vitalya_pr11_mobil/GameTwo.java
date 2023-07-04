package com.example.vitalya_pr11_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameTwo extends AppCompatActivity implements View.OnClickListener {
    public boolean Started = false;
    public boolean Finished = false;
    Button btn_start, gamer1, gamer2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_game_two);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_start = findViewById(R.id.button_start);
        btn_start.setOnClickListener(this);

        gamer1 = findViewById(R.id.button_onecar);
        gamer1.setOnClickListener(this);

        gamer2 = findViewById(R.id.button_twocar);
        gamer2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                if(!Finished){
                    if (!Started){
                        btn_start.setBackgroundColor(Color.RED);
                        btn_start.setText("Пауза");
                        Started = true;
                    }else if(Started){
                        btn_start.setBackgroundColor(Color.GREEN);
                        btn_start.setText("Старт");
                        Started = false;
                    }
                }
                else{
                    Intent intent = new Intent(GameTwo.this, GameTwo.class);
                    startActivity(intent);
                }
                break;
            case R.id.button_onecar:
                View Car1 = (View)findViewById(R.id.imageView11);
                result = (TextView)findViewById(R.id.result);
                if(Started && !Finished){
                    ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car1.getLayoutParams();
                    margin.leftMargin +=40;
                    margin.rightMargin -= 40;
                    Car1.requestLayout();
                    if (margin.rightMargin <= -1550){
                        result.setText("Победил Синий Игрок");
                        btn_start.setText("Заново");
                        result.setTextColor(Color.CYAN);
                        Finished = true;
                    }
                }
                break;
            case R.id.button_twocar:
                Button button = (Button)findViewById(R.id.button_start);
                View Car2 = (View)findViewById(R.id.imageView12);
                result = (TextView)findViewById(R.id.result);
                if(Started && !Finished){
                    ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car2.getLayoutParams();
                    margin.leftMargin +=40;
                    margin.rightMargin -= 40;
                    Car2.requestLayout();
                    if (margin.rightMargin <= -1550){
                        result.setText("Победил Белый Игрок");
                        button.setText("Заново");
                        result.setTextColor(Color.WHITE);
                        Finished = true;
                    }
                }
                break;
        }
    }
    public void Start(View view){
        Button button = (Button)findViewById(R.id.button_start);
        if(!Finished){
            if (!Started){
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }else if(Started){
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        }
        else{
            Intent intent = new Intent(GameTwo.this, GameTwo.class);
            startActivity(intent);
        }
    }
    public void Drive1(View view){
        Button button = (Button)findViewById(R.id.button_start);
        View Car = (View)findViewById(R.id.imageView11);
        TextView result = (TextView)findViewById(R.id.result);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin -= 40;
            Car.requestLayout();
            if (margin.rightMargin <= -100){
                result.setText("Победил Синий Игрок");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
    public void Drive2(View view){
        Button button = (Button)findViewById(R.id.button_start);
        View Car = (View)findViewById(R.id.imageView12);
        TextView result = (TextView)findViewById(R.id.result);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin -= 40;
            Car.requestLayout();
            if (margin.rightMargin <= -100){
                result.setText("Победил Белый Игрок");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
}