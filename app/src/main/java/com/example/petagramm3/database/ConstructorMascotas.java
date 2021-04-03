package com.example.petagramm3.database;

import android.content.ContentValues;
import android.content.Context;
import android.widget.BaseAdapter;

import com.example.petagramm3.Pogo.Mascota;
import com.example.petagramm3.R;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Laika", R.mipmap.weimaraner, "7"));
        mascotas.add(new Mascota("Pucho", R.mipmap.pitbull, "9"));
        mascotas.add(new Mascota("Pochoclo", R.mipmap.doberman, "5"));
        mascotas.add(new Mascota("Homero", R.mipmap.labrador, "9"));
        mascotas.add(new Mascota("Pili", R.mipmap.dogoargentino, "8"));
        return mascotas;*/
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Laika");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.mipmap.weimaraner);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Pucho");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.mipmap.pitbull);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Pochoclo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.mipmap.doberman);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Homero");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.mipmap.labrador);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Pili");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.mipmap.dogoargentino);

        db.insertarMascotas(contentValues);



    }
    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMBER_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMAscota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMAscota(mascota);
    }
}
