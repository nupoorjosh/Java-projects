package com.example.android.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

public class Profile3 extends AppCompatActivity {
    int rno;
    double ans;
    double lv;
    double uv;
    int trait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile3);
        Bundle abcd = getIntent().getExtras();
        if (abcd != null) {
            rno = (abcd.getInt("rno123"));
            ans = (abcd.getDouble("pointers"));
            trait = (abcd.getInt("traits"));
            System.out.println("check3\t"+trait);
        }

        EditText a9 = (EditText)findViewById(R.id.predict);
        a9.setText(""+ans);
        TextView abc = (TextView)findViewById(R.id.fc);
        switch (trait){
            case 0 : abc.setText("Since you weren't monitored there is no relational prediction available");
                break;
            case 1 : lv = ans - 0.5;
                lv = parseDouble(new DecimalFormat("##.##").format(lv));
                uv = ans + 0.5;
                uv = parseDouble(new DecimalFormat("##.##").format(uv));

                abc.setText("However because your Personality is Openness, your score is likely to vary between "+lv+" and "+uv);
                break;
            case 2 : lv = ans - 0.25;
                lv = parseDouble(new DecimalFormat("##.##").format(lv));
                uv = ans + 0.25;
                uv = parseDouble(new DecimalFormat("##.##").format(uv));
                abc.setText("However because your Personality is Conscientious, your score is likely to vary between "+lv+" and "+uv);
                break;
            case 3 : lv = ans - 0.55;
                lv = parseDouble(new DecimalFormat("##.##").format(lv));
                uv = ans + 0.55;
                uv = parseDouble(new DecimalFormat("##.##").format(uv));
                abc.setText("However because your Personality is Extraversion, your score is likely to vary between "+lv+" and "+uv);
                break;
            case 4 : lv = ans - 0.4;
                lv = parseDouble(new DecimalFormat("##.##").format(lv));
                uv = ans + 0.4;
                uv = parseDouble(new DecimalFormat("##.##").format(uv));
                abc.setText("However because your Personality is Agreeable, your score is likely to vary between "+lv+" and "+uv);
                break;
            case 5 : lv = ans - 0.5;
                lv = parseDouble(new DecimalFormat("##.##").format(lv));
                uv = ans + 0.5;
                uv = parseDouble(new DecimalFormat("##.##").format(uv));
                abc.setText("However because your Personality is Neuroticism, your score is likely to vary between "+lv+" and "+uv);
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
    public void score(View view){
        Intent i = new Intent(this, Profile2.class);
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
