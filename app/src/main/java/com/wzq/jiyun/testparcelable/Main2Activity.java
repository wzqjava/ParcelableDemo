package com.wzq.jiyun.testparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<Parcelable> students = getIntent().getParcelableArrayListExtra("students");
        TextView textView = (TextView) findViewById(R.id.textView);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            stringBuilder.append(students.get(i).toString()+"\r\n");
            Log.e(TAG, students.get(i).toString());
        }
        textView.setText(stringBuilder);

    }
}
