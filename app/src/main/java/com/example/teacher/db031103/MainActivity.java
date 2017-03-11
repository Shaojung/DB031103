package com.example.teacher.db031103;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv3 = (TextView) findViewById(R.id.textView3);
    }

    public void click(View v)
    {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        switch (v.getId())
        {
            case R.id.lotto:
                ft.add(R.id.containerLayout, new LottoFragment(), "f_lotto");
                break;
            case R.id.get:
                List<android.support.v4.app.Fragment> frags = getSupportFragmentManager().getFragments();
                Fragment f = fm.findFragmentByTag("f_lotto");
                TextView tv = (TextView) f.getView().findViewById(R.id.textView);
                String n = tv.getText().toString();
                tv3.setText(n);
                break;

        }
        ft.commit();
    }
}
