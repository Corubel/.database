package com.example.petagramm3.database;

public final class ConstantesBaseDatos {
    public static final String DATA_BASE_NAME = "mascotas";
    public static final int DATA_BASE_VERSION = 1;

    public static final String TABLE_PETS = "mascota";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_NAME = "nombre";
    public static final String TABLE_PETS_PHOTO = "foto";

    public static final String TABLE_LIKES_PET = "mascota_likes";
    public static final String TABLE_LIKES_PET_ID = "id";
    public static final String TABLE_LIKES_PET_ID_PET = "id_mascota";
    public static final String TABLE_LIKES_PET_NUMBER_LIKES = "numero_likes";
}
