package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class TrueMainActivity extends AppCompatActivity {

    Button results_tab;
    Button support_tab;
    Button profile_tab;

    Button add1;
    Button add2;
    Button add3;
    Button add4;

    Button filter_famous;
    Button filter_covid;
    Button filter_complex;
    Button filter_other;

    Boolean active1;
    Boolean active2;
    Boolean active3;
    Boolean active4;

    FrameLayout f1;
    FrameLayout f2;
    FrameLayout f3;
    FrameLayout f4;

    int am_added;
    ImageView cart;
    TextView total_am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_main);

        results_tab = (Button) findViewById(R.id.results_btn);
        results_tab.setVisibility(View.VISIBLE);
        results_tab.setBackgroundColor(Color.TRANSPARENT);
        support_tab = (Button) findViewById(R.id.support_btn);
        support_tab.setVisibility(View.VISIBLE);
        support_tab.setBackgroundColor(Color.TRANSPARENT);
        profile_tab = (Button) findViewById(R.id.profile_btn);
        profile_tab.setVisibility(View.VISIBLE);
        profile_tab.setBackgroundColor(Color.TRANSPARENT);

        add1 = (Button) findViewById(R.id.btn_add);
        add2 = (Button) findViewById(R.id.btn_add2);
        add3 = (Button) findViewById(R.id.btn_add3);
        add4 = (Button) findViewById(R.id.btn_add4);

        active1 = active2 = active3 = active4 = false;

        filter_famous = (Button) findViewById(R.id.btn_filter_famous);
        filter_covid = (Button) findViewById(R.id.btn_filter_covid);
        filter_complex = (Button) findViewById(R.id.btn_filter_complex);
        filter_other = (Button) findViewById(R.id.btn_filter_other);

        f1 = (FrameLayout) findViewById(R.id.frame1);
        f2 = (FrameLayout) findViewById(R.id.frame2);
        f3 = (FrameLayout) findViewById(R.id.frame3);
        f4 = (FrameLayout) findViewById(R.id.frame4);

        cart = (ImageView) findViewById(R.id.cart_img);
        cart.setVisibility(View.INVISIBLE);
        total_am = (TextView) findViewById(R.id.total_amount);

    }
    public void onClickResults(View view) {
        Intent intent = new Intent(this, TMA_ResultsTab.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0,0);
    }
    public void onClickSupport(View view) {
        Intent intent = new Intent(this, TMA_SupportTab.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0,0);
    }
    public void onClickProfile(View view) {
        Intent intent = new Intent(this, TMA_ProfileTab.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0,0);
    }

    public void onClickAdd(View view) {
        if(view.getId()==R.id.btn_add&&!active1){
                add1.setBackgroundColor(Color.parseColor("#ffffff"));
                add1.setTextColor(Color.parseColor("#1A6FEE"));
                add1.setText(getResources().getString(R.string.remove));
                active1=true;am_added+=2440;
            }
        else if (view.getId()==R.id.btn_add){
            add1.setBackgroundColor(Color.parseColor("#1A6FEE"));
            add1.setTextColor(Color.parseColor("#ffffff"));
            add1.setText(getResources().getString(R.string.add));
            active1=false;am_added-=2440;
        }
        else if(view.getId()==R.id.btn_add2&&!active2){
            add2.setBackgroundColor(Color.parseColor("#ffffff"));
            add2.setTextColor(Color.parseColor("#1A6FEE"));
            add2.setText(getResources().getString(R.string.remove));
            active2=true;am_added+=1800;
        }
        else if (view.getId()==R.id.btn_add2){
            add2.setBackgroundColor(Color.parseColor("#1A6FEE"));
            add2.setTextColor(Color.parseColor("#ffffff"));
            add2.setText(getResources().getString(R.string.add));
            active2=false;am_added-=1800;
        }
        else if(view.getId()==R.id.btn_add3&&!active3){
            add3.setBackgroundColor(Color.parseColor("#ffffff"));
            add3.setTextColor(Color.parseColor("#1A6FEE"));
            add3.setText(getResources().getString(R.string.remove));
            active3=true;am_added+=690;
        }
        else if (view.getId()==R.id.btn_add3){
            add3.setBackgroundColor(Color.parseColor("#1A6FEE"));
            add3.setTextColor(Color.parseColor("#ffffff"));
            add3.setText(getResources().getString(R.string.add));
            active3=false;am_added-=690;
        }
        else if(view.getId()==R.id.btn_add4&&!active4){
            add4.setBackgroundColor(Color.parseColor("#ffffff"));
            add4.setTextColor(Color.parseColor("#1A6FEE"));
            add4.setText(getResources().getString(R.string.remove));
            active4=true;am_added+=240;
        }
        else if (view.getId()==R.id.btn_add4){
            add4.setBackgroundColor(Color.parseColor("#1A6FEE"));
            add4.setTextColor(Color.parseColor("#ffffff"));
            add4.setText(getResources().getString(R.string.add));
            active4=false;am_added-=240;
        }
        if (am_added>0){
            total_am.setText(Integer.toString(am_added)+" Р");
            cart.setVisibility(View.VISIBLE);
        }
        else{
            total_am.setText("");
            cart.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickFilter(View view) {
        filter_covid.setBackgroundColor(Color.parseColor("#F5F5F9")); filter_covid.setTextColor(Color.parseColor("#939396"));
        filter_famous.setBackgroundColor(Color.parseColor("#F5F5F9")); filter_famous.setTextColor(Color.parseColor("#939396"));
        filter_complex.setBackgroundColor(Color.parseColor("#F5F5F9")); filter_complex.setTextColor(Color.parseColor("#939396"));
        filter_other.setBackgroundColor(Color.parseColor("#F5F5F9")); filter_other.setTextColor(Color.parseColor("#939396"));
        f1.setVisibility(View.VISIBLE); f2.setVisibility(View.VISIBLE); f3.setVisibility(View.VISIBLE); f4.setVisibility(View.VISIBLE);


        if (view.getId() == R.id.btn_filter_covid) {
            filter_covid.setBackgroundColor(Color.parseColor("#1A6FEE")); filter_covid.setTextColor(Color.parseColor("#ffffff"));
            f2.setVisibility(View.GONE); f3.setVisibility(View.GONE); f4.setVisibility(View.GONE);
        }
        else if (view.getId() == R.id.btn_filter_famous) {
            filter_famous.setBackgroundColor(Color.parseColor("#1A6FEE")); filter_famous.setTextColor(Color.parseColor("#ffffff"));
        }
        else if (view.getId() == R.id.btn_filter_complex) {
            filter_complex.setBackgroundColor(Color.parseColor("#1A6FEE")); filter_complex.setTextColor(Color.parseColor("#ffffff"));
            f1.setVisibility(View.GONE); f4.setVisibility(View.GONE);

        }
        else if (view.getId() == R.id.btn_filter_other) {
            filter_other.setBackgroundColor(Color.parseColor("#1A6FEE")); filter_other.setTextColor(Color.parseColor("#ffffff"));
            f1.setVisibility(View.GONE); f2.setVisibility(View.GONE);
        }

    }
}