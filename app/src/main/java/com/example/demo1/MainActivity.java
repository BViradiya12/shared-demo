package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inc=(Button)findViewById(R.id.inc);
        Button res=(Button) findViewById(R.id.reset);
        Button remove1=(Button)findViewById(R.id.remove);
        TextView value=(TextView)findViewById(R.id.txt);

        preferences=getSharedPreferences("Count",MODE_PRIVATE);
        editor=preferences.edit();
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c=preferences.getInt("mark",0);
                c=c+1;
                editor.putInt("mark",c);
                editor.commit();
                Toast.makeText(getApplicationContext(), String.valueOf(c),Toast.LENGTH_LONG).show();

            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c=100;
                editor.putInt("mark",c);
                editor.commit();
                Toast.makeText(getApplicationContext(),String.valueOf(c),Toast.LENGTH_LONG).show();
            }
        });
        remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("mark");
                editor.commit();
                Toast.makeText(getApplicationContext(),"remove",Toast.LENGTH_LONG).show();

            }
        });
    }
}