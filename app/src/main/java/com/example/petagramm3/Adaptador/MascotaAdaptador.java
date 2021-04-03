package com.example.petagramm3.Adaptador;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagramm3.DetalleMascota;
import com.example.petagramm3.Pogo.Mascota;
import com.example.petagramm3.R;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota, parent, false);
        return new MascotaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        //MascotaViewHolder.imgFoto.setImageResource(mascota.getUrlFoto());


        //MascotaViewHolder.cvNombre.setText(mascota.getNombre());
        MascotaViewHolder.cvLikes.setText(String.valueOf(mascota.getLike()) + " Likes ");

        /*MascotaViewHolder.btnWhiteBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a"+ mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                MascotaViewHolder.cvLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMAscota(mascota)));
            }
        });*/
        MascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,  mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("url", mascota.getUrlFoto());
                intent.putExtra("like",mascota.getLike());
                activity.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private static ImageView imgFoto;
       // private static TextView cvNombre;
        private static TextView cvLikes;
       // private static ImageButton btnWhiteBone;
        private static ImageView imgYellowBone;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto =(ImageView) itemView.findViewById(R.id.imgFotoGrid);
           // cvNombre = (TextView) itemView.findViewById(R.id.cvNombre);
            cvLikes = (TextView) itemView.findViewById(R.id.cvGridLikes);
           // btnWhiteBone = (ImageButton) itemView.findViewById(R.id.btnWhiteBone);
            imgYellowBone =(ImageView) itemView.findViewById(R.id.imgHuesoAmarillo);

        }
    }
}
