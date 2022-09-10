package com.example.cuocduakithu;
import android.view.View;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity2 extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton ibtnplay;
    int SoDiem=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
        txtDiem.setText(SoDiem+"");
        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                //Kiem tra
                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity2.this, "0ne Win ", Toast.LENGTH_SHORT).show();
                    if(cbOne.isChecked() ){
                        SoDiem += 10;
                        Toast.makeText(MainActivity2.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        SoDiem -=5;
                        Toast.makeText(MainActivity2.this, "Bạn đóan sai rồi ", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem +"");
                    EnableCheckBox();
                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity2.this, "Two Win ", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked() ){
                        SoDiem += 10;
                        Toast.makeText(MainActivity2.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        SoDiem -=5;
                        Toast.makeText(MainActivity2.this, "Bạn đóan sai rồi ", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem +"");
                    EnableCheckBox();
                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity2.this, "three Win ", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked() ){
                        SoDiem += 10;
                        Toast.makeText(MainActivity2.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        SoDiem -=5;
                        Toast.makeText(MainActivity2.this, "Bạn đóan sai rồi ", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem +"");
                    EnableCheckBox();
                }

                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };


        ibtnplay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                    skOne.setProgress(0);
                skTwo.setProgress(0);
                skThree.setProgress(0);
                ibtnplay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
                    DisableCheckBox();

            }
            else

            {
                Toast.makeText(MainActivity2.this, "Vui lòng đặt cước trước khi chơi ", Toast.LENGTH_SHORT).show();
            }

        }
    });
          cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              if(b){
                  cbTwo.setChecked(false );
                  cbThree.setChecked(false);
              }
              }
          });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false );
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false );
                    cbOne .setChecked(false);
                }
            }
        });

    }
        private void EnableCheckBox(){
            cbOne.setEnabled(true);
            cbTwo.setEnabled(true);
            cbThree.setEnabled(true);
        }
        private void DisableCheckBox(){
            cbOne.setEnabled(false);
            cbTwo.setEnabled(false);
            cbThree.setEnabled(false);
        }



        private void AnhXa () {
            txtDiem = (TextView) findViewById(R.id.textviewDiemSo);
            ibtnplay = (ImageButton) findViewById(R.id.buttonplay);
            cbOne = (CheckBox) findViewById(R.id.checkboxOne);
            cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
            cbThree = (CheckBox) findViewById(R.id.checkboxThree);
            skOne = (SeekBar) findViewById(R.id.seekbarOne);
            skTwo = (SeekBar) findViewById(R.id.seekbarTwo);
            skThree = (SeekBar) findViewById(R.id.seekbarThree);
        }
    }




