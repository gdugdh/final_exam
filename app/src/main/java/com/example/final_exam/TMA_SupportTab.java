package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TMA_SupportTab extends AppCompatActivity {

    Button tests_tab;
    Button results_tab;
    Button profile_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tma_support_tab);

        tests_tab = (Button) findViewById(R.id.tests_btn3);
        tests_tab.setVisibility(View.VISIBLE);
        tests_tab.setBackgroundColor(Color.TRANSPARENT);
        results_tab = (Button) findViewById(R.id.results_btn3);
        results_tab.setVisibility(View.VISIBLE);
        results_tab.setBackgroundColor(Color.TRANSPARENT);
        profile_tab = (Button) findViewById(R.id.profile_btn3);
        profile_tab.setVisibility(View.VISIBLE);
        profile_tab.setBackgroundColor(Color.TRANSPARENT);
    }

    public void onClickTests(View view) {
        Intent intent = new Intent(this, TrueMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0,0);
    }
    public void onClickResults(View view) {
        Intent intent = new Intent(this, TMA_ResultsTab.class);
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
}