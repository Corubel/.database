package com.example.petagramm3.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagramm3.Pogo.Mascota;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATA_BASE_NAME, null, ConstantesBaseDatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "(" +
                ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                ConstantesBaseDatos.TABLE_PETS_NAME + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_PHOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PET + "(" +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_NUMBER_LIKES + " INTEGER, " +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + ") " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "(" + ConstantesBaseDatos.TABLE_PETS_ID+")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_PET);
        onCreate(db);
    }
    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        /*while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMBER_LIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLike(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLike(0);
            }

            mascotas.add(mascotaActual);

        }*/
        db.close();


        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
        db.close();

    }
    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PET, null, contentValues);
        db.close();

    }
    public int obtenerLikesMAscota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMBER_LIKES+")" +
                " FROM "+ ConstantesBaseDatos.TABLE_LIKES_PET +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_PET + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);

        }
        db.close();

        return likes;
    }
}
