package com.example.petagramm3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petagramm3.JavaMail.Formulario;

public class ConfigurarCuenta extends AppCompatActivity {

    private Button btnSaveAccount;
    private EditText eTxtWriteYourAccount;
    private androidx.appcompat.widget.Toolbar myActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        myActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myActionBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
        }

        btnSaveAccount = (Button) findViewById(R.id.btnSaveAccount);
        eTxtWriteYourAccount = (EditText) findViewById(R.id.eTxtWriteYourUser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {

            case R.id.mContacto:
                Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(this, Formulario.class);
                startActivity(f);
                return true;
            case R.id.mAcercaDe:
                Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(this, BioDesarrollador.class);
                startActivity(b);
                return true;
            case  R.id.mConfigurarCuenta:
                Toast.makeText(this, "Configurar Cuenta", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(this, ConfigurarCuenta.class);
                startActivity(c);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}