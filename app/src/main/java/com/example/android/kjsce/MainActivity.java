package com.example.android.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    double [] subject1 = new double[20];
    double [] subject2 = new double[20];
    double [] subject3 = new double[20];
    double [] subject4 = new double[20];
    double [] subject5 = new double[20];
    double [] subject6 = new double[20];
    double totalearned = 0;
    double totalcredits = 0;
    double finalcgpa = 0;

    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s6;
    int rno;
    int rno1;
    int sem;
    int year;
    int adyear;
    int field;
    int t;
    int xyz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle abcd = getIntent().getExtras();
        if(abcd != null) {
            rno = (abcd.getInt("rno123"));
            System.out.println("###################---" + rno);
        }
        fetch();
        if (sem == 8)
        sem8();
        else if (sem == 6)
            sem6();
        else if (sem == 4)
            sem4();
        else
            sem2();
    }

    public void fetch (){
        rno1 = rno/1000;
        field = rno1%10;
        adyear = rno1/100;
        t = rno1/10;
        t = t%10;
        /*
        Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
        */
        year = 17 - adyear;
        if (t == 2){
            year = year + 1;
        }
        /*
        if (month > 0 && month < 7){
            sem = year*2;
        }
        else
            sem = year*2 + 1;
        */
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
    public void scorebetter(View view){
        Intent i = new Intent(this, ScoreBetter.class);
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

    public void validateCA(double a[]){
    }
    public void submitcgpi(View view) {

        EditText num = (EditText) findViewById(R.id.CA1);
        subject1[1] = sandas( num.getText().toString() );
        if (subject1[1]>40){
            subject1[1] = 40;
            num.setText("40");
        }

        EditText num1 = (EditText) findViewById(R.id.CA2);
        subject2[1] = sandas( num1.getText().toString() );
        if (subject2[1]>40){
            subject2[1] = 40;
            num1.setText("40");
        }

        EditText num2 = (EditText) findViewById(R.id.CA3);
        subject3[1] = sandas( num2.getText().toString() );
        if (subject3[1]>40){
            subject3[1] = 40;
            num2.setText("40");
        }

        EditText num3 = (EditText) findViewById(R.id.CA4);
        subject4[1] = sandas( num3.getText().toString() );
        if (subject4[1]>40){
            subject4[1] = 40;
            num3.setText("40");
        }

        EditText num4 = (EditText) findViewById(R.id.CA5);
        subject5[1] = sandas( num4.getText().toString() );

        EditText num5 = (EditText) findViewById(R.id.CA6);
        subject6[1] = sandas( num5.getText().toString() );

        EditText a = (EditText) findViewById(R.id.ESE1);
        subject1[2] = sandas( a.getText().toString() );
        if (subject1[2]>100){
            subject1[2] = 100;
            a.setText("100");
        }
        addfilter(subject1);

        EditText a1 = (EditText) findViewById(R.id.ESE2);
        subject2[2] = sandas( a1.getText().toString() );
        if (subject2[2]>100){
            subject2[2] = 100;
            a1.setText("100");
        }
        addfilter(subject2);

        EditText a2 = (EditText) findViewById(R.id.ESE3);
        subject3[2] = sandas( a2.getText().toString() );
        if (subject3[2]>100){
            subject3[2] = 100;
            a2.setText("100");
        }
        addfilter(subject3);

        EditText a3 = (EditText) findViewById(R.id.ESE4);
        subject4[2] = sandas( a3.getText().toString() );
        if (subject4[2]>100){
            subject4[2] = 100;
            a3.setText("100");
        }
        addfilter(subject4);

        EditText a4 = (EditText) findViewById(R.id.ESE5);
        subject5[2] = sandas( a4.getText().toString() );
        addfilter(subject5);

        EditText a5 = (EditText) findViewById(R.id.ESE6);
        subject6[2] = sandas( a5.getText().toString() );
        addfilter(subject6);

        EditText b = (EditText) findViewById(R.id.TW1);
        subject1[3] = sandas( b.getText().toString() );
        if (subject1[3]>100){
            subject1[3] = 100;
            b.setText("100");
        }

        EditText b1 = (EditText) findViewById(R.id.TW2);
        subject2[3] = sandas( b1.getText().toString() );
        if (subject2[3]>100){
            subject2[3] = 100;
            b1.setText("100");
        }

        EditText b2 = (EditText) findViewById(R.id.TW3);
        subject3[3] = sandas( b2.getText().toString() );
        if (subject3[3]>100){
            subject3[3] = 100;
            b2.setText("100");
        }

        EditText b3 = (EditText) findViewById(R.id.TW4);
        subject4[3] = sandas( b3.getText().toString() );
        if (subject4[3]>100){
            subject4[3] = 100;
            b3.setText("100");
        }

        EditText b4 = (EditText) findViewById(R.id.TW5);
        subject5[3] = sandas( b4.getText().toString() );
        if (subject5[3]>100){
            subject5[3] = 100;
            b4.setText("100");
        }

        EditText b5 = (EditText) findViewById(R.id.TW6);
        subject6[3] = sandas(b5.getText().toString());

        if (sem == 8)
            sem8();
        else if (sem == 6)
            sem6();
        else if (sem == 4)
            sem4();
        else
            sem2();
        EditText cgpis = (EditText) findViewById(R.id.cgpis);
        cgpis.setText(""+finalcgpa);
    }

    public void sem8(){

        totalcredits = 26;
        s1 = "BDA";
        s2 = "SNMR";
        s3 = "CSM";
        s4 = "Electives";
        s5 = "Project 2";

        TextView sub1 = (TextView) findViewById(R.id.sub1);
        sub1.setText(""+s1);

        TextView sub2 = (TextView) findViewById(R.id.sub2);
        sub2.setText(""+s2);

        TextView sub3 = (TextView) findViewById(R.id.sub3);
        sub3.setText(""+s3);

        TextView sub4 = (TextView) findViewById(R.id.sub4);
        sub4.setText(""+s4);

        TextView sub5 = (TextView) findViewById(R.id.sub5);
        sub5.setText(""+s5);

        TextView sub6 = (TextView) findViewById(R.id.sub6);
        sub6.setText("--");

        EditText abc = (EditText) findViewById(R.id.ESE5);
        abc.setText("0");

        EditText ab = (EditText) findViewById(R.id.TW5);
        ab.setText("0");

        subject1[5] = 4;
        subject2[5] = 4;
        subject3[5] = 4;
        subject4[5] = 4;
        subject5[5] = 6;
        grade(subject1);


        grade(subject2);
        grade(subject3);
        grade(subject4);
        grade(subject5);
        gradetw(subject1);
        gradetw(subject2);
        gradetw(subject3);
        gradetw(subject4);
        totalearned =
                subject1[7]+subject2[7]+subject3[7]+subject4[7]+subject5[7]+subject1[8]
        +subject2[8]+subject3[8]+subject4[8];
        finalcgpa = totalearned/totalcredits;
        finalcgpa = parseDouble(new DecimalFormat("##.##").format(finalcgpa));
    }
    public void addfilter(double subject[]){
        subject[2] = (subject[2]*0.6);
        subject[2] = Math.round(subject[2]);
        subject[4] = subject[1]+subject[2];
    }
    public void grade (double a[]){
        if (a[4] > 84){
            a[6] = 10;
          }
        else if (a[4] > 74){
            a[6] = 9;
        }
        else if (a[4] > 69) {
            a[6] = 8;
        }
        else if (a[4] > 59) {
            a[6] = 7;
        }
        else if (a[4] > 49) {
            a[6] = 6;
        }
        else if (a[4] > 44){
            a[6] = 5;
        }
        else if (a[4]>39){
            a[6] = 4;
        }
        else {
            a[6] = 0;
        }
        a[7] = a[5]*a[6];
    }
    public void gradetw(double b[]){
        if (b[3]<26)
            b[3]= b[3]*4;
        else if (b[3]<51)
            b[3]=b[3]*2;
        else
            b[3] = b[3]*1;
        //b[3] = b[3]*2;
        if (b[3] > 84){
            b[8] = 10;
        }
        else if (b[3] > 74){
            b[8] = 9;
        }
        else if (b[3] > 69){
            b[8] = 8;
        }
        else if (b[3] > 59){
            b[8] = 7;
        }
        else if (b[3] > 49){
            b[8] = 6;
        }
        else if (b[3] > 44){
            b[8] = 5;
        }
        else if (b[3] > 39){
            b[8] = 4;
        }
        else {
            b[8] = 0;
        }
    }
    public double sandas(String abc)
    {
        if(abc.equals(""))
        {
            return 0;
        }

        return parseDouble(abc);

    }
    public void reset2(View view){
        System.out.print("");
        EditText cgpis = (EditText) findViewById(R.id.cgpis);
        cgpis.setText("" );
        EditText CA1 = (EditText) findViewById(R.id.CA1);
        CA1.setText("");
        EditText CA2 = (EditText) findViewById(R.id.CA2);
        CA2.setText("");
        EditText CA3 = (EditText) findViewById(R.id.CA3);
        CA3.setText("");
        EditText CA4 = (EditText) findViewById(R.id.CA4);
        CA4.setText("");
        EditText CA5 = (EditText) findViewById(R.id.CA5);
        CA5.setText("");
        EditText CA6 = (EditText) findViewById(R.id.CA6);
        CA6.setText("");

        EditText ese1 = (EditText) findViewById(R.id.ESE1);
        ese1.setText("");
        EditText ese2 = (EditText) findViewById(R.id.ESE2);
        ese2.setText("");
        EditText ese3 = (EditText) findViewById(R.id.ESE3);
        ese3.setText("");
        EditText ese4 = (EditText) findViewById(R.id.ESE4);
        ese4.setText("");
        EditText ese5 = (EditText) findViewById(R.id.ESE5);
        ese5.setText("");
        EditText ese6 = (EditText) findViewById(R.id.ESE6);
        ese6.setText("");

        EditText tw1 = (EditText) findViewById(R.id.TW1);
        tw1.setText("");
        EditText tw2 = (EditText) findViewById(R.id.TW2);
        tw2.setText("");
        EditText tw3 = (EditText) findViewById(R.id.TW3);
        tw3.setText("");
        EditText tw4 = (EditText) findViewById(R.id.TW4);
        tw4.setText("");
        EditText tw5 = (EditText) findViewById(R.id.TW5);
        tw5.setText("");
        EditText tw6 = (EditText) findViewById(R.id.TW6);
        tw6.setText("");
    }



    public void sem6 (){

        totalcredits = 23;
        s1 = "INS";
        s2 = "MES";
        s3 = "DM";
        s4 = "DFW";
        s5 = "IDC";
        s6 = "Elective";
        TextView sub1 = (TextView) findViewById(R.id.sub1);
        sub1.setText(""+s1);

        TextView sub2 = (TextView) findViewById(R.id.sub2);
        sub2.setText(""+s2);

        TextView sub3 = (TextView) findViewById(R.id.sub3);
        sub3.setText(""+s3);

        TextView sub4 = (TextView) findViewById(R.id.sub4);
        sub4.setText(""+s4);

        TextView sub5 = (TextView) findViewById(R.id.sub5);
        sub5.setText(""+s5);

        TextView sub6 = (TextView) findViewById(R.id.sub6);
        sub6.setText(""+s6);

        EditText ab = (EditText) findViewById(R.id.TW5);
        ab.setText("0");

        subject1[5] = 3;
        subject2[5] = 3;
        subject3[5] = 3;
        subject4[5] = 3;
        subject5[5] = 3;
        subject6[5] = 3;
        grade(subject1);
        grade(subject2);
        grade(subject3);
        grade(subject4);
        grade(subject5);
        grade(subject6);
        gradetw(subject1);
        gradetw(subject2);
        gradetw(subject3);
        gradetw(subject4);
        gradetw(subject6);
        totalearned =
                subject1[7]+subject2[7]+subject3[7]+subject4[7]+subject5[7]+subject6[7]+subject1[8]
                        +subject2[8]+subject3[8]+subject4[8]+subject6[8];
        finalcgpa = totalearned/totalcredits;
        finalcgpa = parseDouble(new DecimalFormat("##.##").format(finalcgpa));
    }




    public void sem4 (){

        totalcredits = 24;
        s1 = "AM4";
        s2 = "DCM";
        s3 = "AOA";
        s4 = "COA";
        s5 = "WP1";
        s6 = "PCS";
        TextView sub1 = (TextView) findViewById(R.id.sub1);
        sub1.setText(""+s1);

        TextView sub2 = (TextView) findViewById(R.id.sub2);
        sub2.setText(""+s2);

        TextView sub3 = (TextView) findViewById(R.id.sub3);
        sub3.setText(""+s3);

        TextView sub4 = (TextView) findViewById(R.id.sub4);
        sub4.setText(""+s4);

        TextView sub5 = (TextView) findViewById(R.id.sub5);
        sub5.setText(""+s5);

        TextView sub6 = (TextView) findViewById(R.id.sub6);
        sub6.setText(""+s6);




        subject1[5] = 3;
        subject2[5] = 3;
        subject3[5] = 3;
        subject4[5] = 3;
        subject5[5] = 2;
        subject6[5] = 0;
        grade(subject1);
        grade(subject2);
        grade(subject3);
        grade(subject4);
        grade(subject5);
        grade(subject6);
        gradetw(subject1);
        gradetw(subject2);
        gradetw(subject3);
        gradetw(subject4);
        gradetw(subject6);
        totalearned =
                subject1[7]+subject2[7]+subject3[7]+subject4[7]+subject5[7]+subject6[7]+subject1[8]
                        +subject2[8]+subject3[8]+subject4[8]+subject6[8];
        finalcgpa = totalearned/totalcredits;
        finalcgpa = parseDouble(new DecimalFormat("##.##").format(finalcgpa));
    }



    public void sem2(){

        totalcredits = 26;
        s1 = "AM2";
        s2 = "PHY2";
        s3 = "CHEM2";
        s4 = "EM";
        s5 = "FCP";
        s6 = "EVS";
        TextView sub1 = (TextView) findViewById(R.id.sub1);
        sub1.setText(""+s1);

        TextView sub2 = (TextView) findViewById(R.id.sub2);
        sub2.setText(""+s2);

        TextView sub3 = (TextView) findViewById(R.id.sub3);
        sub3.setText(""+s3);

        TextView sub4 = (TextView) findViewById(R.id.sub4);
        sub4.setText(""+s4);

        TextView sub5 = (TextView) findViewById(R.id.sub5);
        sub5.setText(""+s5);

        TextView sub6 = (TextView) findViewById(R.id.sub6);
        sub6.setText(""+s6);



        subject1[5] = 4;
        subject2[5] = 3;
        subject3[5] = 3;
        subject4[5] = 4;
        subject5[5] = 4;
        subject6[5] = 2;
        grade(subject1);
        grade(subject2);
        grade(subject3);
        grade(subject4);
        grade(subject5);
        grade(subject6);
        gradetw(subject1);
        gradetw(subject2);
        gradetw(subject3);
        gradetw(subject4);
        gradetw(subject6);
        totalearned =
                subject1[7]+subject2[7]+subject3[7]+subject4[7]+subject5[7]+subject6[7]+subject1[8]
                        +subject2[8]+subject3[8]+subject4[8]+subject5[8]+subject6[8];
        finalcgpa = totalearned/totalcredits;
        finalcgpa = parseDouble(new DecimalFormat("##.##").format(finalcgpa));
    }
}
