package com.example.petagramm3;

public class Mascota {
    public String nombre;
    public int foto;
    public String like;

    public Mascota(String nombre, int foto, String like){
        this.nombre=nombre;
        this.foto=foto;
        this.like=like;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRating() {
        return like;
    }

    public void setRating(String rating) {
        this.like = rating;
    }
}

