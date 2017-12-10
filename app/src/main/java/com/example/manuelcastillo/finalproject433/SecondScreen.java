package com.example.manuelcastillo.finalproject433;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by manuelcastillo on 12/5/17.
 */

public class SecondScreen extends AppCompatActivity {
    public static final String BOOK_MESSAGE = "com.example.manuelcastillo.finalproject2.BOOK_MESSAGE";
    public static final String DEPT_MESSAGE = "com.example.manuelcastillo.finalproject2.DEPT_MESSAGE";
    public static final String COURSE_MESSAGE = "com.example.manuelcastillo.finalproject2.COURSE_MESSAGE";
    public static final String PRICE_MESSAGE = "com.example.manuelcastillo.finalproject2.PRICE_MESSAGE";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

    }


    public void third(View view) {

        Intent intent = new Intent(this, ThirdScreen.class);


        EditText editB = (EditText) findViewById(R.id.book);
        String book = editB.getText().toString();
        if(book != null && book.length() > 0) intent.putExtra(BOOK_MESSAGE, book);


        EditText editD = (EditText) findViewById(R.id.department);
        String dept = editD.getText().toString();
        if(dept != null && dept.length() > 0) intent.putExtra(DEPT_MESSAGE, dept);

        EditText editC = (EditText) findViewById(R.id.course);
        String course = editC.getText().toString();
        if(course != null&& course.length() > 0) intent.putExtra(COURSE_MESSAGE, course);


        EditText editP = (EditText) findViewById(R.id.price);
        String price = editP.getText().toString();
        if(price != null && price.length() > 0) intent.putExtra(PRICE_MESSAGE, price);

        startActivity(intent);
    }
}
