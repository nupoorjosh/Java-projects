package com.example.android.kjsce;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Profile2 extends AppCompatActivity {
int rno;
    double ans;
    int trait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile2);
        Bundle abcd = getIntent().getExtras();
        if (abcd != null) {
            rno = (abcd.getInt("rno123"));
            ans = (abcd.getDouble("pointers"));
            trait = (abcd.getInt("traits"));

        }
        Button b1 = (Button)findViewById(R.id.t1);
        Button b2 = (Button)findViewById(R.id.t2);
        Button b3 = (Button)findViewById(R.id.t3);
        Button b4 = (Button)findViewById(R.id.t4);
        Button b5 = (Button)findViewById(R.id.t5);
        switch (trait){
            case 1 : b1.setBackgroundColor(Color.RED);
                break;
            case 2 : b2.setBackgroundColor(Color.RED);
                break;
            case 3 : b3.setBackgroundColor(Color.RED);
                break;
            case 4 : b4.setBackgroundColor(Color.RED);
                break;
            case 5 : b5.setBackgroundColor(Color.RED);
                break;
        }

    }
    public void profile1(View view){
        Intent i = new Intent(this, Profile.class);
        i.putExtra("rno123", rno);
        i.putExtra("pointers",ans);
        i.putExtra("traits", trait);
        startActivity(i);

    }
    public void help (View view){
        Intent i = new Intent(this, Help.class);
        i.putExtra("rno123", rno);
        i.putExtra("pointers",ans);
        i.putExtra("traits", trait);
        startActivity(i);

    }
    public void score(View view){
        Intent i = new Intent(this, Profile3.class);
        i.putExtra("rno123", rno);
        i.putExtra("pointers",ans);
        i.putExtra("traits", trait);
        startActivity(i);

    }
    public void back(View view){
        Intent i = new Intent(this, Others.class);
        i.putExtra("rno123", rno);
        i.putExtra("pointers",ans);
        startActivity(i);

    }
}
