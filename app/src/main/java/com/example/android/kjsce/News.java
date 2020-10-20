package com.example.android.kjsce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
    public void trends(View view){
        Intent i = new Intent(this, Trends.class);
        startActivity(i);
    }
    public void cgpi(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void scorebetter(View view){
        Intent i = new Intent(this, ScoreBetter.class);
        startActivity(i);
    }
    public void others(View view){
        Intent i = new Intent(this, Others.class);
        startActivity(i);
    }
}
