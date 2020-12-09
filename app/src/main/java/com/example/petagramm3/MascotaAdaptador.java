package com.example.petagramm3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_mascota, parent, false);
        return new MascotaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        MascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        MascotaViewHolder.cvNombre.setText(mascota.getNombre());
        MascotaViewHolder.cvNumero.setText(mascota.getRating());

        MascotaViewHolder.btnWhiteBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int like = Integer.parseInt(mascota.getRating())+1;
                String newlike = Integer.toString(like);
                mascota.setRating(newlike);
                MascotaViewHolder.cvNumero.setText(mascota.getRating());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private static ImageView imgFoto;
        private static TextView cvNombre;
        private static TextView cvNumero;
        private static ImageButton btnWhiteBone;
        private static ImageView imgYellowBone;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto =(ImageView) itemView.findViewById(R.id.imgFoto);
            cvNombre = (TextView) itemView.findViewById(R.id.cvNombre);
            cvNumero = (TextView) itemView.findViewById(R.id.cvNumero);
            btnWhiteBone = (ImageButton) itemView.findViewById(R.id.btnWhiteBone);
            imgYellowBone =(ImageView) itemView.findViewById(R.id.imgYellowBone);

        }
    }
}
