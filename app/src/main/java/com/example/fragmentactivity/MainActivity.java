package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentactivity.fragments.FirstFragment;
import com.example.fragmentactivity.fragments.SecondFragment;
import com.example.fragmentactivity.fragments.SumFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnFragment;
    private boolean status=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFragment=findViewById(R.id.btnFragment);

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                if (status)
                {
                    SumFragment sumFragment=new SumFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer,sumFragment);
                    fragmentTransaction.commit();
                    btnFragment.setText("Load Second Fragment");
                    status=false;
                }
                else
                {
                    SecondFragment secondFragment=new SecondFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer,secondFragment);
                    fragmentTransaction.commit();
                    btnFragment.setText("Load Sum Transaction");
                    status=true;
                }
            }
        });
    }
}
