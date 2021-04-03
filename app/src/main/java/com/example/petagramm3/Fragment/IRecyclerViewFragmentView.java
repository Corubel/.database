package com.example.petagramm3.Fragment;

import com.example.petagramm3.Adaptador.MascotaAdaptador;
import com.example.petagramm3.Pogo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public  void generarLinearLayoutVertical();

    public  void generarGridLayout();

    public MascotaAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
