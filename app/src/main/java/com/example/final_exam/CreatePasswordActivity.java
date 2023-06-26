package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    Button skiip;
    int count;
    ImageView dots_again_now_theres_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        dots_again_now_theres_four = (ImageView) findViewById(R.id.passw_dots);
        skiip = (Button) findViewById(R.id.skipf_btn);
        skiip.setVisibility(View.VISIBLE);
        skiip.setBackgroundColor(Color.TRANSPARENT);
    }

    public void onClickSkip(View view) {
        Intent intent = new Intent(this, CreateCardActivity.class);
        startActivity(intent);
    }
    public void onClickAdd(View view) {
        count++;
        setImg(count);
    }
    public void onClickTakeAway(View view) {
        if (count>=0){
        count--;
        setImg(count);}
    }

    private void setImg(int count) {
        if (count==0){
            dots_again_now_theres_four.setImageResource(R.drawable.dots_passw0);
        }
        else if (count==1){
            dots_again_now_theres_four.setImageResource(R.drawable.dots_passw1);
        }
        else if (count==2){
            dots_again_now_theres_four.setImageResource(R.drawable.dots_passw2);
        }
        else if (count==3){
            dots_again_now_theres_four.setImageResource(R.drawable.dots_passw3);
        }
        else if (count==4){
            dots_again_now_theres_four.setImageResource(R.drawable.dots_passw4);
            Toast.makeText(this, "Пароль сохранен. (ложь)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CreateCardActivity.class);
            startActivity(intent);
        }

    }
}