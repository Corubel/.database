package com.example.petagramm3.restApi.deserializador;

import com.example.petagramm3.Pogo.Mascota;
import com.example.petagramm3.restApi.JsonKeys;
import com.example.petagramm3.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray("data");

        mascotaResponse.setMascotas(deserializarMascotaDejson(mascotaResponseData));
        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarMascotaDejson (JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size() ; i++) {
            JsonObject mascotaResponseDataObjetc = mascotaResponseData.get(i).getAsJsonObject();

            JsonObject userJson = mascotaResponseDataObjetc.getAsJsonObject(JsonKeys.USERNAME);
            String id           = userJson.get(JsonKeys.USER_ID).getAsString();

            JsonObject imageJson = mascotaResponseDataObjetc.getAsJsonObject(JsonKeys.MEDIA_IMAGES);

            JsonObject likesJson = mascotaResponseDataObjetc.getAsJsonObject(JsonKeys.FOLLOW_COUNT);

            Mascota mascotaActual = new Mascota();
            mascotaActual.getId();
            mascotaActual.getUrlFoto();
            mascotaActual.getLike();

            mascotas.add(mascotaActual);


        }
        return mascotas;
    }
}
