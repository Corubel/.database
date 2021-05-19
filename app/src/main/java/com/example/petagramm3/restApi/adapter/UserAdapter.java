package com.example.petagramm3.restApi.adapter;

import com.example.petagramm3.restApi.ConstantesUser;
import com.example.petagramm3.restApi.EndPoinstUser;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAdapter {

    public EndPoinstUser establecerConexionRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesUser.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndPoinstUser.class);
    }
}
