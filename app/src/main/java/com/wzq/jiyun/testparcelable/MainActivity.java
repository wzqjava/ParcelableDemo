package com.wzq.jiyun.testparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student("wzq" + i, i));
        }

    }

    /**
     * 点击事件,传递数据;
     *
     * @param view
     */
    public void sendParcle(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putParcelableArrayListExtra("students", students);
        startActivity(intent);
    }
}
