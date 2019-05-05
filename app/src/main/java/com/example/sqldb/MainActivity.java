package com.example.sqldb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabase = openOrCreateDatabase("infini", Context.MODE_PRIVATE,null);


        sqLiteDatabase.execSQL("CREATE TABLE IF  NOT EXISTS test (ROLL_NO int(3),NAME varchar(20));");

        sqLiteDatabase.execSQL("INSERT INTO test (ROLL_NO, NAME) VALUES ('11', '77');");
        sqLiteDatabase.execSQL("INSERT INTO test (ROLL_NO, NAME) VALUES ('1', '7');");


        Cursor c =sqLiteDatabase.rawQuery("SELECT * FROM test;",null);

        if(c.getCount() == 0 ){
            Toast.makeText(this, "No data in database", Toast.LENGTH_SHORT).show();
        }
        int nRow = c.getCount();
        Toast.makeText(this,Integer.toString(nRow), Toast.LENGTH_SHORT).show();

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            buffer.append("NAME "+c.getString(1));
        }
        Toast.makeText(this,buffer.toString(), Toast.LENGTH_SHORT).show();
    }
}
