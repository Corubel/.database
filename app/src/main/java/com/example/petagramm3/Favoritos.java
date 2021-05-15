package com.example.petagramm3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.petagramm3.Adaptador.MascotaAdaptador;
import com.example.petagramm3.Pogo.Mascota;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    private RecyclerView listaMascotas;
    private androidx.appcompat.widget.Toolbar myActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        myActionBar =  findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
        }



        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        //inicializarListaMascotas();
        inicializarAdaptador();

    }



    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

     /*public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Laika", R.mipmap.weimaraner, 7));
        mascotas.add(new Mascota("Pucho", R.mipmap.pitbull, 9));
        mascotas.add(new Mascota("Pochoclo", R.mipmap.doberman, 5));
        mascotas.add(new Mascota("Homero", R.mipmap.labrador, 9));
        mascotas.add(new Mascota("Pili", R.mipmap.dogoargentino, 8));
    }*/


}