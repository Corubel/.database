package com.example.petagramm3.restApi;

import com.example.petagramm3.restApi.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPoinstUser {

    @FormUrlEncoded
    @POST(ConstantesUser.KEY_POST_ID_TOKEN)
    Call<UserResponse> registrarUserID(@Field("username")String username);
}
