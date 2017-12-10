package com.example.manuelcastillo.finalproject433;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by manuelcastillo on 12/5/17.
 */

public class ThirdScreen extends AppCompatActivity {

    SQLiteDatabase db;
    String l;
    String m;
    String n;
    String o;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);

        db = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);

        db.execSQL("DROP TABLE IF EXISTS Books");
        db.execSQL("CREATE TABLE Books (Bid INTEGER, Author TEXT, Title TEXT)");
        db.execSQL("INSERT INTO Books VALUES ('1','Bobir Mukamilov', 'The Free Market and You: All You Need to Know About Austrian Economics')");
        db.execSQL("INSERT INTO Books VALUES ('2','Nelya Topa', 'Pyschology For All: A Brief Study of the Human Mind')");
        db.execSQL("INSERT INTO Books VALUES ('3','Russell McIntosh', 'A Brief Look Into Philosophy: Solving Problems One Solution At a Time')");
        db.execSQL("INSERT INTO Books VALUES ('4','Gray Gilbert', 'A Brief Analysis of Zoroastrian Texts')");

        db.execSQL("DROP TABLE IF EXISTS Sellers");
        db.execSQL("CREATE TABLE Sellers (Username TEXT, Bid INTEGER, Department TEXT, Course INTEGER, Price INTEGER)");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob1','4', 'Religous Studies', '201', '35')");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob01','4', 'Religous Studies', '201', '32')");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob2','4', 'Religous Studies', '201', '37')");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob02','4', 'Religous Studies', '201', '34')");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob3','4', 'Religous Studies', '201', '30')");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob4','4', 'Religous Studies', '201', '39')");
        db.execSQL("INSERT INTO Sellers VALUES ('Bob04','4', 'Religous Studies', '201', '100')");

        db.execSQL("INSERT INTO Sellers VALUES ('Joe1','2', 'Pyschology', '109', '19')");
        db.execSQL("INSERT INTO Sellers VALUES ('Joe01','2', 'Pyschology', '109', '16')");
        db.execSQL("INSERT INTO Sellers VALUES ('Joe2','3', 'Philosophy', '101', '13')");
        db.execSQL("INSERT INTO Sellers VALUES ('Joe02','1', 'Economics', '205', '10')");
        db.execSQL("INSERT INTO Sellers VALUES ('Joe3','1', 'Economics', '205', '9')");
        db.execSQL("INSERT INTO Sellers VALUES ('Joe4','3', 'Philosophy', '101', '16')");
        db.execSQL("INSERT INTO Sellers VALUES ('Joe04','1', 'Economics', '205', '7')");

        Intent intent = getIntent();
        l = intent.getStringExtra(SecondScreen.BOOK_MESSAGE);
        m = intent.getStringExtra(SecondScreen.DEPT_MESSAGE);
        n = intent.getStringExtra(SecondScreen.COURSE_MESSAGE);
        o = intent.getStringExtra(SecondScreen.PRICE_MESSAGE);

        query();
    }


    public void query(){
        String w = "Select Sellers.Username, Books.Title, Sellers.Department, Sellers.Course, Sellers.Price FROM Sellers, Books Where Books.Bid = Sellers.Bid";

        if(l.length()>0) w = w + " AND Books.Title = '" + l + "'";

        if(m.length()>0) w = w + " AND Sellers.Department = '" + m + "'";

        if(n.length()>0) w = w + " AND Sellers.Course = '" + n + "'";

        if(o.length()>0) w = w + " AND Sellers.Price = '" + o + "'";




        Cursor c = db.rawQuery(w, null);

        TextView p = (TextView) findViewById(R.id.resultsBox);
        String u= "";


        if(c.moveToFirst())
            for (int x = 1; x <= c.getCount(); x++){

                for(int y=1; y <= c.getColumnCount(); y++){
                    if(y != c.getColumnCount())
                        u = u +  c.getString(y) + " " ;


                }
                u = u + "\n";
                c.moveToNext();
            }

        p.setText(u);
        p.invalidate();
    }


}
