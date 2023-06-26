package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TMA_ProfileTab extends AppCompatActivity {

    Button tests_tab;
    Button support_tab;
    Button results_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tma_profile_tab);

        tests_tab = (Button) findViewById(R.id.tests_btn);
        tests_tab.setVisibility(View.VISIBLE);
        tests_tab.setBackgroundColor(Color.TRANSPARENT);
        support_tab = (Button) findViewById(R.id.support_btn2);
        support_tab.setVisibility(View.VISIBLE);
        support_tab.setBackgroundColor(Color.TRANSPARENT);
        results_tab = (Button) findViewById(R.id.results_btn2);
        results_tab.setVisibility(View.VISIBLE);
        results_tab.setBackgroundColor(Color.TRANSPARENT);
    }
    public void onClickTests(View view) {
        Intent intent = new Intent(this, TrueMainActivity.class);
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
    public void onClickResults(View view) {
        Intent intent = new Intent(this, TMA_ResultsTab.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0,0);
    }
}