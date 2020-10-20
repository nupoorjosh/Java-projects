package com.example.android.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Trends extends AppCompatActivity {
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
        setContentView(R.layout.activity_trends);
        semesterchoice();

        Bundle abcd = getIntent().getExtras();
        if(abcd != null) {
            rno = (abcd.getInt("rno123"));
        }
        fetch();
    }

    public void fetch(){
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
    public void semesterchoice(){
        Spinner s2 = (Spinner)findViewById(R.id.spinner2);
        List<String> semnum = new ArrayList<>();
        semnum.add("Sem 1");
        semnum.add("Sem 2");
        semnum.add("Sem 3");
        semnum.add("Sem 4");
        semnum.add("Sem 5");
        semnum.add("Sem 6");
        semnum.add("Sem 7");
        semnum.add("Sem 8");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, semnum);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter);

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        sem1spinner();
                        break;
                    case 1 :
                        sem2spinner();
                        break;
                    case 2 :
                        sem3spinner();
                        break;
                    case 3 :
                        sem4spinner();
                        break;
                    case 4 :
                        sem5spinner();
                        break;
                    case 5 :
                        sem6spinner();
                        break;
                    case 6 :
                        sem7spinner();
                        break;
                    case 7 :
                        sem8spinner();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void sem8spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("SNMR");
        list.add("BDA");
        list.add("CSM");
        list.add("Electives 1 & 2");
        list.add("Electives 3 & 4");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :
                        abc.setImageResource(R.drawable.sem8snmr);
                        break;
                    case 1 :
                        abc.setImageResource(R.drawable.sem8bda);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem8csm);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem8gis);
                        abc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                abc.setImageResource(R.drawable.sem8erp);
                            }
                        });

                        break;
                    case 4 : abc.setImageResource(R.drawable.sem8sfc);
                        abc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                abc.setImageResource(R.drawable.sem8sqa);
                            }
                        });
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void scorebetter(View view){
        Intent i = new Intent(this, ScoreBetter.class);
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


    public void sem6spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("AIT");
        list.add("DMBI");
        list.add("DS");
        list.add("SE");
        list.add("SWS");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :

                        abc.setImageResource(R.drawable.sem6ait);
                        break;
                    case 1 : System.out.println("shreyank2"+id);
                        abc.setImageResource(R.drawable.sem6dmbi);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem6ds);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem6se);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem6sws);
                        break;
                    case 5 :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void sem4spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("AM4");
        list.add("AT");
        list.add("CN");
        list.add("COA");
        list.add("ITC");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :
                        abc.setImageResource(R.drawable.sem4am4);
                        break;
                    case 1 :
                        abc.setImageResource(R.drawable.sem4at);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem4cn);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem4coa);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem4itc);
                        break;
                    case 5 :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void sem2spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("AC2");
        list.add("AM2");
        list.add("AP2");
        list.add("CP");
        list.add("EM");
        list.add("EVS");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :
                        abc.setImageResource(R.drawable.sem2ac2);
                        break;
                    case 1 :
                        abc.setImageResource(R.drawable.sem2am2);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem2ap2);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem2cp);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem2em);
                        break;
                    case 5 : abc.setImageResource(R.drawable.sem2evs);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void sem1spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("AC1");
        list.add("AP1");
        list.add("AM1");
        list.add("BEE");
        list.add("EG");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :
                        abc.setImageResource(R.drawable.sem1ac1);
                        break;
                    case 1 :
                        abc.setImageResource(R.drawable.sem1ap1);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem1am1);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem1bee);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem1eg);
                        break;
                    case 5 :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void sem3spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("AM3");
        list.add("DLDA");
        list.add("DMS");
        list.add("DS");
        list.add("TOC");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :

                        abc.setImageResource(R.drawable.sem3am3);
                        break;
                    case 1 :
                        abc.setImageResource(R.drawable.sem3dlda);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem3dms);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem3ds);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem3toc);
                        break;
                    case 5 :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void sem5spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("ADMS");
        list.add("CGVR");
        list.add("MES");
        list.add("OS");
        list.add("OST");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :
                        abc.setImageResource(R.drawable.sem5adms);
                        break;
                    case 1 :
                        abc.setImageResource(R.drawable.sem5cgvr);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem5mes);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem5os);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem5ost);
                        break;
                    case 5 :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void sem7spinner(){
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("CC");
        list.add("IS");
        list.add("SPM");
        list.add("WT");
        list.add("Elective 1& 2");
        list.add("Elective 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final ImageView abc = (ImageView)findViewById(R.id.imagview1);
                switch (position){
                    case 0 :
                        System.out.println("shreyank"+id);
                        abc.setImageResource(R.drawable.sem7cc);
                        break;
                    case 1 : System.out.println("shreyank2"+id);
                        abc.setImageResource(R.drawable.sem7is);
                        break;
                    case 2 : abc.setImageResource(R.drawable.sem7spm);
                        break;
                    case 3 :
                        abc.setImageResource(R.drawable.sem7wt);
                        break;
                    case 4 : abc.setImageResource(R.drawable.sem7eceb);
                        abc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                abc.setImageResource(R.drawable.sem7ip);
                            }
                        });

                        break;
                    case 5 : abc.setImageResource(R.drawable.sem7swa);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}


