package com.example.henry.lab13pulsor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    Contador counter;
    TextView textView,textView2,textView3;
    Button btn2,btn3;
    int puntuacion=0;
    String t= "TIEMPO AGOTADO! REINICIA";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button);



        counter = new Contador(100000,800);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView2.getText().equals(textView.getText())){
                    Toast toast1 = Toast.makeText(getApplicationContext(),"HAS ACERTADO!",Toast.LENGTH_SHORT);
                    toast1.show();
                    textView2.setText(null);
                    int ne = new Random().nextInt(10);
                    textView2.setText(ne+"");
                    puntuacion++;
                    textView3.setText("Puntuacion "+ puntuacion);
                }


            }
        });





        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().equals("TIEMPO AGOTADO! REINICIA")){
                    counter.cancel();
                    btn3.setText("COMENZAR");
                    puntuacion=0;
                    textView3.setText("Puntuacion "+ puntuacion);

                }
                counter.cancel();
                counter.start();
                int na = new Random().nextInt(10);
                textView2.setText(na+"");
                btn3.setText("REINICIAR");



            }
        });



    }

    public void fin(){
        textView.setText("TIEMPO AGOTADO! REINICIA");

    }
    public void cambio(){
        int n= new Random().nextInt(10);
        textView.setText(null);
        textView.setText(n+ "");
    }
    public class Contador extends CountDownTimer{
        public Contador(long millisInFuture, long countDownInterval){
            super(millisInFuture,countDownInterval);
        }
        @Override
        public void onFinish(){
            fin();
        }
        @Override
        public void onTick(long millisUntilFinished){
            cambio();
        }

    }
}
