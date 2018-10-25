package com.example.pamella.primaria;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class segundatela extends AppCompatActivity {



    private static final String NOME_ARQUIVO = "dados_formulario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        Spinner spinner = (Spinner) findViewById(R.id.spinnersexo);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,
                R.array.sexos, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void gravar(View view) {

        TextView textoNome = (TextView) findViewById(R.id.textNome);
        TextView textoCodigo = (TextView) findViewById(R.id.codValidacao);
        Spinner spinner = (Spinner) findViewById(R.id.spinnersexo);
        CheckBox primeiroGrau = (CheckBox) findViewById(R.id.checkBox);
        CheckBox segundoGrau = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox superior = (CheckBox) findViewById(R.id.checkBox3);

        SharedPreferences sp = getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Nome",  textoNome.getText().toString());
        editor.putString("Codigo", textoCodigo.getText().toString());
        editor.putInt("Sexo", spinner.getSelectedItemPosition());
        editor.putBoolean("primeiroGrau", primeiroGrau.isChecked());
        editor.putBoolean("segundoGrau", segundoGrau.isChecked());
        editor.putBoolean("Superior", superior.isChecked());
        editor.apply();

    }

    protected void ler (View view) {

        TextView textoNome = (TextView) findViewById(R.id.textNome);
        TextView textoCodigo = (TextView) findViewById(R.id.codValidacao);
        Spinner spinner = (Spinner) findViewById(R.id.spinnersexo);
        CheckBox primeiroGrau = (CheckBox) findViewById(R.id.checkBox);
        CheckBox segundoGrau = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox superior = (CheckBox) findViewById(R.id.checkBox3);

        SharedPreferences sp = getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        String nome = sp.getString("Nome", "aa");
        String codigo = sp.getString("Codigo", "");
        int sexo = sp.getInt("Sexo", -1);
        Boolean checkPrimeiro = sp.getBoolean("primeiroGrau", false);
        Boolean checkSegundo = sp.getBoolean("segundoGrau", false);
        Boolean checkSuperior = sp.getBoolean("Superior", false);

        textoCodigo.setText(codigo);
        textoNome.setText(nome);
        spinner.setSelection(sexo);

        if (checkPrimeiro) {
            primeiroGrau.setChecked(true);
        }
        if (checkSegundo) {
            segundoGrau.setChecked(true);
        }
        if (checkSuperior) {
            superior.setChecked(true);
        }




    }


}
