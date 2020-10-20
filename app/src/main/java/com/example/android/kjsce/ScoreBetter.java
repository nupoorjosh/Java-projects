package com.example.android.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ScoreBetter extends AppCompatActivity {

    double m44;
    double m45;
    double m46;
    double m47;
    double m48;
    double m49;
    double m410;
    double ca40;
    int rno;
    int rno1;
    int sem;
    int year;
    int adyear;
    int field;
    int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_better);
        Bundle abcd = getIntent().getExtras();
        if(abcd != null) {
            rno = (abcd.getInt("rno123"));
        }
        fetch();
    }

    public void fetch (){
        rno1 = rno/1000;
        field = rno1%10;
        adyear = rno1/100;
        t = rno1/10;
        t = t%10;
        year = 17 - adyear;
        if (t == 2){
            year = year + 1;
        }
        sem = year*2;
    }

    public void trends(View view){
        Intent i = new Intent(this, Trends.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }
    public void gohome(View view){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
    public void cgpi(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }
    public void news(View view){
        Intent i = new Intent(this, News.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }
    public void others(View view){
        Intent i = new Intent(this, Others.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }
    public double sandas(String abc)
    {
        if(abc.equals(""))
        {
            Toast.makeText(this, "On entering no marks, 20/40 will be considered", Toast.LENGTH_SHORT).show();
            return 20;
        }
        return Double.parseDouble(abc);
    }
    public void submitSB(View view){

        EditText camarks = (EditText) findViewById(R.id.camarks);
        ca40 = sandas(camarks.getText().toString());
        if (ca40 > 40){
            Toast.makeText(this, "You have entered marks above 40, so we'll consider it 40(max)", Toast.LENGTH_SHORT).show();
            ca40 = 40;
            camarks.setText("40");
        }
        m44 = 40 - ca40;
        m44 = m44/0.6;
        m44 = Math.round(m44);
        if (m44 < 30){
            m44 = 30;
        }
        EditText pmarks = (EditText) findViewById(R.id.pmarks);
        pmarks.setText(""+m44);
        EditText mf4 = (EditText)findViewById(R.id.mf4);
        mf4.setText(""+m44);
        m45 = 45 - ca40;
        m45 = m45/0.6;
        m45 = Math.round(m45);
        if (m45 < 30){
            m45 = 30;
        }
        EditText a = (EditText)findViewById(R.id.mf5);
        a.setText(""+m45);
        m46 = 50 - ca40;
        m46 = m46/0.6;
        m46 = Math.round(m46);
        if (m46 < 30){
            m46 = 30;
        }
        EditText mf6 = (EditText)findViewById(R.id.mf6);
        mf6.setText(""+m46);
        m47 = 60 - ca40;
        m47 = m47/0.6;
        m47 = Math.round(m47);
        EditText mf7 = (EditText)findViewById(R.id.mf7);
        mf7.setText(""+m47);
        m48 = 70 - ca40;
        m48 = m48/0.6;
        m48 = Math.round(m48);
        if (m48 > 100){
            EditText mf8 = (EditText)findViewById(R.id.mf8);
            mf8.setText("Sorry");
        }
        else {
            EditText mf8 = (EditText)findViewById(R.id.mf8);
            mf8.setText(""+m48);
        }
        m49 = 75 - ca40;
        m49 = m49/0.6;
        m49 = Math.round(m49);
        if (m49 > 100){
            EditText mf9 = (EditText)findViewById(R.id.mf9);
            mf9.setText("Sorry");
        }
        else {
            EditText mf9 = (EditText)findViewById(R.id.mf9);
            mf9.setText(""+m49);
        }
        m410 = 85 - ca40;
        m410 = m410/0.6;
        m410 = Math.round(m410);
        if (m410 > 100){
            EditText mf10 = (EditText)findViewById(R.id.mf10);
            mf10.setText("Sorry");
        }
        else {
            EditText mf10 = (EditText)findViewById(R.id.mf10);
            mf10.setText(""+m410);
        }
        Toast.makeText(this, "All the marks required are out of 100", Toast.LENGTH_LONG).show();
    }

    public void reset1(View view) {
        EditText camarks = (EditText) findViewById(R.id.camarks);
        camarks.setText("");
        EditText pmarks = (EditText) findViewById(R.id.pmarks);
        pmarks.setText("");
        EditText mf4 = (EditText)findViewById(R.id.mf4);
        mf4.setText("");
        EditText mf5 = (EditText)findViewById(R.id.mf5);
        mf5.setText("");
        EditText mf6 = (EditText)findViewById(R.id.mf6);
        mf6.setText("");
        EditText mf7 = (EditText)findViewById(R.id.mf7);
        mf7.setText("");
        EditText mf8 = (EditText)findViewById(R.id.mf8);
        mf8.setText("");
        EditText mf9 = (EditText)findViewById(R.id.mf9);
        mf9.setText("");
        EditText mf10 = (EditText)findViewById(R.id.mf10);
        mf10.setText("");
    }
}
