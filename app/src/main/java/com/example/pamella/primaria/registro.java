package com.example.pamella.primaria;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    private String[] sexos = new String[]{
            "Masculino", "feminino"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        Button botaoConfiguracao = (Button) findViewById(R.id.botaoConfiguracao);

        botaoConfiguracao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), segundatela.class);
                startActivity(i);


            }
        });
    }
}