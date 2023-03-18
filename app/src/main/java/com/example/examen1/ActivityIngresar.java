package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen1.Configuracion.SQLiteConexion;
import com.example.examen1.Configuracion.Transacciones;

public class ActivityIngresar extends AppCompatActivity {

    EditText codigo, pais, nombre, telefono, nota;
    Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        try {


            codigo = (EditText) findViewById(R.id.txtcodigo);
            pais = (EditText) findViewById(R.id.txtpais);
            nombre = (EditText) findViewById(R.id.txtnombre);
            telefono = (EditText) findViewById(R.id.txttelefono);
            nota = (EditText) findViewById(R.id.txtnota);
            btnguardar = (Button)findViewById(R.id.btnguardar);

            btnguardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AgregarContacto();  //Funcion afuera del metodo
                }
            });

        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.toString(),Toast.LENGTH_SHORT).show();
        }

    }
    private void AgregarContacto()
    {

        try {

            //crear nueva conexion hacia SQL lite

            SQLiteConexion conexion = new SQLiteConexion(this,
                    Transacciones.NameDatabase,
                    null,
                    1);

            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.pais, pais.getText().toString());
            valores.put(Transacciones.nombre, nombre.getText().toString());
            valores.put(Transacciones.telefono, telefono.getText().toString());
            valores.put(Transacciones.nota, nota.getText().toString());

            Long resultado = db.insert(Transacciones.tablacontactos, Transacciones.id, valores);
            Toast.makeText(this, "Guardado con exito", Toast.LENGTH_SHORT).show();

            CleanPantalla();
        }
        catch (Exception ex)
        {
            ex.toString();
        }
    }

    private void CleanPantalla() {
        pais.setText("");
        nombre.setText("");
        telefono.setText("");
        nota.setText("");
    }
}

