package com.example.lh.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this, "test");
        textView = (TextView)findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.i("lihang","test1");
                    dbHelper.test();
                    Log.i("lihang","test2");
                    Log.i("lihang","test3");
                } catch (NullPointerException e) {
                    Log.i("lihang","isnull");
                } finally {
                    Log.i("lihang","test finally");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}
