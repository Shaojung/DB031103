package com.example.teacher.db031103;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v)
    {
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (v.getId())
        {
            case R.id.lotto:
                ft.add(R.id.containerLayout, new LottoFragment());
                break;
        }
        ft.commit();
    }
}
