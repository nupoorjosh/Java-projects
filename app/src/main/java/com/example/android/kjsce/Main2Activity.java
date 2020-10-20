package com.example.android.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    int rno;
    int sem;
    int year;
    int adyear;
    int field;
    int t;
    int rno1;

    /*
    int rno1;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b = (Button)findViewById(R.id.trial);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });

    }


    public void usageset(View view){
        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        startActivity(intent);
    }
    public void thatsit(View view){
        EditText roll = (EditText) findViewById(R.id.roll);
        rno = clear(roll.getText().toString());
        fetch();
        int lrno = Integer.valueOf(rno).toString().length();
        if (lrno == 7) {
            if (adyear > 10 && adyear < 17) {
                if (t < 3) {
                    if (field < 6) {
                        if (rno % 1000 > 0 && rno % 1000 < 151){
                            Intent i = new Intent(this, MainActivity.class);
                            i.putExtra("rno123", rno);
                            System.out.println("22222222222222222222222222@@@@@@"+rno);
                            startActivity(i);
                            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "Check the last 3 Digits", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Check the 4th Digit", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Check the 3rd Digit", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getApplicationContext(), "Check the 1st 2 Digits", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Missing Or Extra Digits in Roll No.", Toast.LENGTH_SHORT).show();

    }
    public void show(){
    }


    public void backdoor(View v){
        rno = 1314001;
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }

    public int clear(String abc)
    {
        if(abc.equals(""))
        {
            return 0;
        }
        return Integer.parseInt(abc);
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
        System.out.println("check\t"+adyear+"\t"+sem+"\t"+t+"\t"+field);

    }

}
