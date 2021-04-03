package com.example.petagramm3.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.petagramm3.Adaptador.MascotaAdaptador;
import com.example.petagramm3.Fragment.IRecyclerViewFragmentView;
import com.example.petagramm3.Pogo.Mascota;
import com.example.petagramm3.database.ConstructorMascotas;
import com.example.petagramm3.restApi.EndpointsApi;
import com.example.petagramm3.restApi.adapter.RestApiAdapter;
import com.example.petagramm3.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerMacotasBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMacotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        endpointsApi.getRecentMedia();

        Call<MascotaResponse> mascotaResponseCall =  endpointsApi.getRecentMedia();
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(@EverythingIsNonNull Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Conexion falló, intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador((mascotas)));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
