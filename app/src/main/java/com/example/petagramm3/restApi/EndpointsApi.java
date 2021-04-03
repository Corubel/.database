package com.example.petagramm3.restApi;

import com.example.petagramm3.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {
    @GET(ConstantesRestApi.URL_GET_RESENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
}
