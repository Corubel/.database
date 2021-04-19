package com.example.petagramm3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petagramm3.Adaptador.MascotaAdaptador;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

public class DetalleMascota extends AppCompatActivity {
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota_foto);

        Bundle extras  = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKES);

        tvLikesDetalle  = (TextView) findViewById(R.id.tvLikesDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);

        Picasso.get()
                .load(url)
                .placeholder(R.mipmap.ic_dogs)
                .into(imgFotoDetalle);


    }
}
