package com.example.android.kjsce;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Profile extends AppCompatActivity {

    double ans;
    int trait;
    int rno;
    int rno1;
    int sem;
    int year;
    int adyear;
    int field;
    int t;
    double cgpi1, cgpi2, cgpi3, cgpi4, cgpi5, cgpi6, cgpi7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "X-axis : Semester\nY-axis : Pointers", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_profile);
        Bundle abcd = getIntent().getExtras();
        if (abcd != null) {
            rno = (abcd.getInt("rno123"));
            ans = (abcd.getDouble("pointers"));
            System.out.println("check\t"+rno+"\t"+ans);

        }
        fetch();
        EditText a1 = (EditText)findViewById(R.id.rno123);
        a1.setText(""+rno);
        new AsyncT().execute();
/*
        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(3,cgpi3),
                new DataPoint(4,cgpi4),
                new DataPoint(5,cgpi5),
                new DataPoint(6,cgpi6),
                new DataPoint(7,cgpi7),
                new DataPoint(8,ans)

        });
        graph.addSeries(series);
*/
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
    public void profile1(View view){
        Intent i = new Intent(this, Profile2.class);
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
    private class AsyncT extends AsyncTask<Void, String, Void> {
        @Override
        public Void doInBackground(Void... params) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://192.168.0.106:3306/it data", "trial", "root");
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                if (sem == 8) {


                    ResultSet rs1 = stmt.executeQuery("select * from 2013cgpi WHERE Rollno='" + rno + "'");
                    while (rs1.next()) {
                        cgpi3 = rs1.getDouble("SEM 3");
                        cgpi4 = rs1.getDouble("SEM 4");
                        cgpi5 = rs1.getDouble("SEM 5");
                        cgpi6 = rs1.getDouble("SEM 6");
                        cgpi7 = rs1.getDouble("SEM 7");
                        trait = rs1.getInt("Traits");
                    }
                    System.out.println("check connection\t"+cgpi3+cgpi4);


                }
                else if ((sem == 6) || (sem == 7)) {
                    ResultSet rs = stmt.executeQuery("select * from 2014cgpi WHERE Rollno='" + rno + "'");
                    if (sem == 6) {

                        while (rs.next())

                        {
                            cgpi3 = rs.getDouble("Sem 3");
                            cgpi4 = rs.getDouble("Sem 4");
                            cgpi5 = rs.getDouble("Sem 5");


                        }


                    }


                }
                else if (sem == 4){
                    ResultSet rs = stmt.executeQuery("select * from 2015cgpinew WHERE Rollno='" + rno + "'");
                    while (rs.next()){
                        cgpi1 = rs.getDouble("sem1");
                        cgpi2 = rs.getDouble("sem2");
                        cgpi3 = rs.getDouble("sem3");
                    }
                }

                con.close();


            } catch (SQLException e) {

                Log.e("Database", "Connection Failed! Check output console");
                e.printStackTrace();
            }


            return null;

        }
        @Override
        public void onPostExecute(Void v){
            super.onPostExecute(v);
            if (sem ==8 ) {
                GraphView graph = (GraphView) findViewById(R.id.graph);

                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(3, cgpi3),
                        new DataPoint(4, cgpi4),
                        new DataPoint(5, cgpi5),
                        new DataPoint(6, cgpi6),
                        new DataPoint(7, cgpi7),
                        new DataPoint(8, ans)

                });
                graph.addSeries(series);
                graph.getViewport().setMinX(2);
                graph.getViewport().setMaxX(8);
                graph.getViewport().setMinY(4);
                graph.getViewport().setMaxY(10);

                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setXAxisBoundsManual(true);
            }

            else if (sem == 6){
                GraphView graph = (GraphView) findViewById(R.id.graph);

                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(3, cgpi3),
                        new DataPoint(4, cgpi4),
                        new DataPoint(5, cgpi5),
                        new DataPoint(6, ans)

                });
                graph.addSeries(series);
                graph.getViewport().setMinX(2);
                graph.getViewport().setMaxX(6);
                graph.getViewport().setMinY(4);
                graph.getViewport().setMaxY(10);

                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setXAxisBoundsManual(true);
            }
            else {
                GraphView graph = (GraphView) findViewById(R.id.graph);

                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(1, cgpi1),
                        new DataPoint(2, cgpi2),
                        new DataPoint(3, cgpi3),
                        new DataPoint(4, ans)

                });
                graph.addSeries(series);
                graph.getViewport().setMinX(1);
                graph.getViewport().setMaxX(5);
                graph.getViewport().setMinY(4);
                graph.getViewport().setMaxY(10);

                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setXAxisBoundsManual(true);
            }




        }
    }

}
