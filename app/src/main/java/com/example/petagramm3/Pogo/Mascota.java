package com.example.petagramm3.Pogo;

public class Mascota {
    public String id;
    public String nombre;
    public String urlFoto;
    public int like = 0;



    public Mascota() {

    }

    public Mascota(String id, String nombre, String urlFoto, int like) {
        this.id = id;
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.like = like;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}

