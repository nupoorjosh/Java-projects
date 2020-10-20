package com.example.android.kjsce;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import static com.example.android.kjsce.Inverse.Multiplication;


public class Others extends AppCompatActivity {

    int rno;
    int rno1;
    int sem;
    int year;
    int adyear;
    int field;
    int t;
    int cs = 0 ;
    int reg = 0;
    int l = 145, col = 1;
    double ans;
    double x[][];
    double y[][];
    double b[][];
    double a[] = new double[l];
    double c[] = new double[l];
    double d[] = new double[l];
    double h[] = new double[l];
    double f[] = new double[l];
    double g[] = new double[l];
    double tx[][]= new double[reg][l];
    int i = 0, j;
    double cgpi3, cgpi4, cgpi5, cgpi6, cgpi7;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        Bundle abcd = getIntent().getExtras();
        if (abcd != null) {
            rno = (abcd.getInt("rno123"));
        }

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
        cs = sem;
        //reg = cs-2;
        if (cs == 8)
            reg = 6;
        else if (cs == 6)
            reg = 4;
        else if (cs == 4)
            reg = 4;
        x = new double[l][reg];
        y = new double[l][col];
        b = new double[reg][col];
        System.out.println("merebaapchal"+cs+"\t"+reg);

        EditText sem3 = (EditText)findViewById(R.id.sem3cgpi);
        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Others.this, "Your Sem 3 CGPI", Toast.LENGTH_LONG).show();
            }
        });

        EditText sem4 = (EditText)findViewById(R.id.sem4cgpi);
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Others.this, "Your Sem 4 CGPI", Toast.LENGTH_LONG).show();
            }
        });

        EditText sem5 = (EditText)findViewById(R.id.sem5cgpi);
        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Others.this, "Your Sem 5 CGPI", Toast.LENGTH_LONG).show();
            }
        });

        EditText sem6 = (EditText)findViewById(R.id.sem6cgpi);
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Others.this, "Your Sem 6 CGPI", Toast.LENGTH_LONG).show();
            }
        });

        EditText sem7 = (EditText)findViewById(R.id.sem7cgpi);
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Others.this, "Your Sem 7 CGPI", Toast.LENGTH_LONG).show();
            }
        });


        EditText a9 = (EditText)findViewById(R.id.rno123);
        a9.setText(""+rno);
        /*
        Button b = (Button) findViewById(R.id.here);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncT().execute();
            }
        });
        */
        new AsyncT().execute();

    }
    public void reset3(View v){
        EditText a3 = (EditText) findViewById(R.id.sem3cgpi);
        a3.setText("" );
        EditText a4 = (EditText) findViewById(R.id.sem4cgpi);
        a4.setText("" );
        EditText a5 = (EditText) findViewById(R.id.sem5cgpi);
        a5.setText("" );
        EditText a6 = (EditText) findViewById(R.id.sem6cgpi);
        a6.setText("" );
        EditText a7 = (EditText) findViewById(R.id.sem7cgpi);
        a7.setText("" );
        EditText a8 = (EditText) findViewById(R.id.predict);
        a8.setText("" );
    }


    public void setmarks (){
        EditText a3 = (EditText) findViewById(R.id.sem3cgpi);
        a3.setText(""+cgpi3);
        EditText a4 = (EditText) findViewById(R.id.sem4cgpi);
        a4.setText(""+cgpi4 );
        EditText a5 = (EditText) findViewById(R.id.sem5cgpi);
        a5.setText(""+cgpi5 );
        EditText a6 = (EditText) findViewById(R.id.sem6cgpi);
        a6.setText(""+cgpi6 );
        EditText a7 = (EditText) findViewById(R.id.sem7cgpi);
        a7.setText(""+cgpi7 );
        //EditText a8 = (EditText) findViewById(R.id.predict);
        //a8.setText("" );
    }

    public void changemarks(View view){
        EditText a3 = (EditText) findViewById(R.id.sem3cgpi);
        cgpi3 = clear(a3.getText().toString());
        EditText a4 = (EditText) findViewById(R.id.sem4cgpi);
        cgpi4 = clear(a4.getText().toString());
        EditText a5 = (EditText) findViewById(R.id.sem5cgpi);
        cgpi5 = clear(a5.getText().toString());
        EditText a6 = (EditText) findViewById(R.id.sem6cgpi);
        cgpi6 = clear(a6.getText().toString());
        EditText a7 = (EditText) findViewById(R.id.sem7cgpi);
        cgpi7 = clear(a7.getText().toString());

        tx = Inverse.Matrixtranspose(x);
        double yt[][]= Inverse.Matrixtranspose(y);
        double mult[][] = Multiplication(tx,x);
        double inv[][]= Inverse.invert(mult);

        double product1[][]= new double[reg][l];
        product1 = Multiplication(inv,tx);
        double regpar[][] = Multiplication(product1,y);

        for (i=0;i<regpar.length;i++) {
            for (j=0;j<regpar[i].length;j++) {
                System.out.println(regpar[i][j]);
            }
            if(cs==4){
                System.out.println("enter the marks from sem 3 to sem 5:");

                double sem1 = cgpi3;
                double sem2 = cgpi4;
                double sem3 = cgpi5;
                double sem4 = regpar[0][0]+ regpar[1][0]*sem1 + regpar[2][0]*sem2 + regpar[3][0]*sem3;
                System.out.println("Sem 6 marks "+sem4);
                ans = sem4;
                break;
            }

            if(cs==6){
                System.out.println("enter the marks from sem 3 to sem 5:");

                double sem3 = cgpi3;
                double sem4 = cgpi4;
                double sem5 = cgpi5;
                double sem6 = regpar[0][0]+ regpar[1][0]*sem3 + regpar[2][0]*sem4 + regpar[3][0]*sem5;
                System.out.println("Sem 6 marks "+sem6);
                ans = sem6;
                break;
            }
            else if(cs==7){
                System.out.println("enter the marks from sem 3 to sem 6:");
                double sem36 = cgpi3;
                double sem46 = cgpi4;
                double sem56 = cgpi5;
                double sem66 = cgpi6;
                double sem76 = regpar[0][0]+ regpar[1][0]*sem36 + regpar[2][0]*sem46+ regpar[3][0]*sem56 + regpar[4][0]*sem66;
                System.out.println("sem 7 marks:"+sem76);
                ans = sem76;
                break;
            }
            else if(cs==8){
                System.out.println("enter the marks from sem 3 to sem 7:");
                double sem37 = cgpi3;
                double sem47 = cgpi4;
                double sem57 = cgpi5;
                double sem67 = cgpi6;
                double sem77 = cgpi7;
                double sem87 = regpar[0][0]+ regpar[1][0]*sem37 + regpar[2][0]*sem47 + regpar[3][0]*sem57 + regpar[4][0]*sem67 + regpar[5][0]*sem77;
                System.out.println("sem 8 marks:"+sem87);
                ans = sem87;
                break;

            }


        }

        EditText et = (EditText)findViewById(R.id.predict);
        ans =Double.parseDouble(new DecimalFormat("##.##").format(ans));
        et.setText(""+ans);
    }

    public double clear(String abc) {
        if (abc.equals("")) {
            return 0;
        }
        return Double.parseDouble(abc);
    }

    public void fetch() {
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

    public void trends(View view) {
        Intent i = new Intent(this, Trends.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }
    public void profiletab(View view){
        Intent i = new Intent(this, Profile.class);
        i.putExtra("rno123", rno);
        i.putExtra("pointers", ans);
        System.out.println("check 2\t"+ans);
        startActivity(i);
    }

    public void gohome(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void cgpi(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }


    public void scorebetter(View view) {
        Intent i = new Intent(this, ScoreBetter.class);
        i.putExtra("rno123", rno);
        startActivity(i);
    }

    private class AsyncT extends AsyncTask<Void, String, Void>
    {
        @Override
        public Void doInBackground(Void... params){


            try {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e)
            {

                e.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://192.168.0.106:3306/it data", "trial", "root");
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                if (cs == 8) {
                    ResultSet rs = stmt.executeQuery("select * from 2012cgpi");
                    while (rs.next() && i < l)

                    {

                        a[i] = rs.getDouble(2);
                        g[i] = rs.getDouble(3);
                        c[i] = rs.getDouble(4);
                        d[i] = rs.getDouble(5);
                        h[i] = rs.getDouble(6);
                        f[i] = rs.getDouble(7);
                        i++;

                    }

                    ResultSet rs1 = stmt.executeQuery("select * from 2013cgpi WHERE Rollno='"+rno+"'");
                    while (rs1.next()){
                        cgpi3 = rs1.getDouble("SEM 3");
                        cgpi4 = rs1.getDouble("SEM 4");
                        cgpi5 = rs1.getDouble("SEM 5");
                        cgpi6 = rs1.getDouble("SEM 6");
                        cgpi7 = rs1.getDouble("SEM 7");
                    }



                    for (i = 0, j = 0; i < l; i++) {
                        x[i][j] = 1;
                    }
                    for (j = 1, i = 0; i < l; i++) {
                        x[i][j] = a[i];
                    }
                    for (j = 2, i = 0; i < l; i++) {
                        x[i][j] = g[i];
                    }
                    for (j = 3, i = 0; i < l; i++) {
                        x[i][j] = c[i];
                    }
                    for (j = 4, i = 0; i < l; i++) {
                        x[i][j] = d[i];
                    }
                    for (j = 5, i = 0; i < l; i++) {
                        x[i][j] = h[i];
                    }
                    for (j = 0, i = 0; i < l; i++) {
                        y[i][j] = f[i];
                    }


                }
                else if ((cs == 6) || (cs == 7)) {
                    ResultSet rs = stmt.executeQuery("select * from 2013cgpi");
                    if (cs == 6) {

                        while (rs.next() && i < l)

                        {

                            a[i] = rs.getDouble(2);
                            g[i] = rs.getDouble(3);
                            c[i] = rs.getDouble(4);
                            d[i] = rs.getDouble(5);
                            i++;

                        }
                        ResultSet rs1 = stmt.executeQuery("select * from 2014cgpi WHERE Rollno='"+rno+"'");
                        while (rs1.next()){
                            cgpi3 = rs1.getDouble("SEM 3");
                            cgpi4 = rs1.getDouble("SEM 4");
                            cgpi5 = rs1.getDouble("SEM 5");


                        }
                        for (i = 0, j = 0; i < l; i++) {
                            x[i][j] = 1;
                        }
                        for (j = 1, i = 0; i < l; i++) {
                            x[i][j] = a[i];
                        }
                        for (j = 2, i = 0; i < l; i++) {
                            x[i][j] = g[i];
                        }
                        for (j = 3, i = 0; i < l; i++) {
                            x[i][j] = c[i];
                        }
                        for (j = 0, i = 0; i < l; i++) {
                            y[i][j] = d[i];
                        }


                    }
                    else {

                        while (rs.next() && i < l)

                        {

                            a[i] = rs.getDouble(2);
                            g[i] = rs.getDouble(3);
                            c[i] = rs.getDouble(4);
                            d[i] = rs.getDouble(5);
                            h[i] = rs.getDouble(6);
                            i++;

                        }
                        for (i = 0, j = 0; i < l; i++) {
                            x[i][j] = 1;
                        }
                        for (j = 1, i = 0; i < l; i++) {
                            x[i][j] = a[i];
                        }
                        for (j = 2, i = 0; i < l; i++) {
                            x[i][j] = g[i];
                        }
                        for (j = 3, i = 0; i < l; i++) {
                            x[i][j] = c[i];
                        }
                        for (j = 4, i = 0; i < l; i++) {
                            x[i][j] = d[i];
                        }

                        for (j = 0, i = 0; i < l; i++) {
                            y[i][j] = h[i];
                        }
                    }


                }
                else if (cs == 4){
                    ResultSet rs = stmt.executeQuery("select * from 2014cgpinew");


                        while (rs.next() && i < l)

                        {

                            a[i] = rs.getDouble(2);
                            g[i] = rs.getDouble(3);
                            c[i] = rs.getDouble(4);
                            d[i] = rs.getDouble(5);
                            i++;

                        }
                        ResultSet rs1 = stmt.executeQuery("select * from 2015cgpinew WHERE Rollno='"+rno+"'");
                        while (rs1.next()){
                            cgpi3 = rs1.getDouble("sem1");
                            cgpi4 = rs1.getDouble("sem2");
                            cgpi5 = rs1.getDouble("sem3");


                        }
                        for (i = 0, j = 0; i < l; i++) {
                            x[i][j] = 1;
                        }
                        for (j = 1, i = 0; i < l; i++) {
                            x[i][j] = a[i];
                        }
                        for (j = 2, i = 0; i < l; i++) {
                            x[i][j] = g[i];
                        }
                        for (j = 3, i = 0; i < l; i++) {
                            x[i][j] = c[i];
                        }
                        for (j = 0, i = 0; i < l; i++) {
                            y[i][j] = d[i];
                        }



                }
                con.close();


            }
            catch (SQLException e)
            {

                Log.e("Database","Connection Failed! Check output console");
                e.printStackTrace();
            }


            return null;

        }
        @Override
        public void onPostExecute(Void v){
            super.onPostExecute(v);

            setmarks();




        }
    }

}














































class Inverse
{
    public static double[][] Matrixtranspose(double x[][]) {
        double tx[][]= new double[x[0].length][x.length];
        for (int i=0;i<x.length;i++) {
            for (int j=0;j<x[i].length;j++) {
                tx[j][i]=x[i][j];
            }
        }
        return tx;

    }

    public static double[][] Multiplication(double a[][],double b[][]){
        double mult = 0;
        double c[][] = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b[i].length; j++)
            {
                for (int k = 0; k < a[i].length; k++)
                {
                    mult = mult + a[i][k] * b[k][j];
                }
                c[i][j]=mult;
                mult=0;
            }
        }


        return c;
    }
    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
}
