package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText txtpais, txtnombre;
    Button btnguardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtpais = (EditText) findViewById(R.id.txtpais);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        btnguardar = (Button) findViewById(R.id.btnguardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,  txtpais.getText() + " - "+ txtnombre.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}