package com.example.petagramm3.restApi.model;

import com.example.petagramm3.Pogo.Mascota;

import java.util.ArrayList;

public class MascotaResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
