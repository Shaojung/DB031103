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
        List<android.support.v4.app.Fragment> frags = getSupportFragmentManager().getFragments();
        switch (v.getId())
        {
            case R.id.lotto:
                if (frags == null || frags.size() < 6)
                {
                    ft.add(R.id.containerLayout, new LottoFragment(), "f_lotto");
                    ft.addToBackStack(null);
                }

                break;
            case R.id.get:
                StringBuilder sb = new StringBuilder();
                for (Fragment f : frags)
                {
                    TextView tv = (TextView) f.getView().findViewById(R.id.textView);
                    sb.append(tv.getText().toString() + ",");
                }
                tv3.setText(sb.toString());
                break;
            case R.id.pop:
                fm.popBackStack();
                break;
            case R.id.clear:
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;

        }
        ft.commit();
    }
}
