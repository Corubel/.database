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
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarMascotaDejson(mascotaResponseData));
        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarMascotaDejson (JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size() ; i++) {
            JsonObject mascotaResponseDataObjetc = mascotaResponseData.get(i).getAsJsonObject();

            String userJson = mascotaResponseDataObjetc.get(JsonKeys.USERNAME).getAsString();

            String id           = mascotaResponseDataObjetc.get(JsonKeys.USER_ID).getAsString();

            String urlFoto = mascotaResponseDataObjetc.get(JsonKeys.MEDIA_URL).getAsString();

           Integer likesJson = mascotaResponseDataObjetc.get(JsonKeys.LIKES).getAsInt();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombre(userJson);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLike(likesJson);

            mascotas.add(mascotaActual);


        }
        return mascotas;
    }
}
