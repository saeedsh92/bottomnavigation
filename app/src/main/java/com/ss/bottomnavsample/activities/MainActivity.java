package com.ss.bottomnavsample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ss.bottomnavsample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDefaultStyle=(Button)findViewById(R.id.button_defaultStyle);
        Button btnSStyle=(Button)findViewById(R.id.button_sStyle);
        btnDefaultStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DefaultStyleDynamicActivity.class));
            }
        });
        btnSStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SStyleDynamicActivity.class));
            }
        });

        Button btnDefaultStyleFixed=(Button)findViewById(R.id.button_defaultStyle_fixed);
        btnDefaultStyleFixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DefaultStyleFixedActivity.class));
            }
        });

        Button btnSStyleFixed=(Button)findViewById(R.id.button_sStyle_fixed);
        btnSStyleFixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SStyleFixedActivity.class));
            }
        });
    }
}
