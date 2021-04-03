package com.example.petagramm3.restApi;

public final class ConstantesRestApi {
   // https://graph.facebook.com/v10.0/3699418160154380?fields=id,username,profile_pic,media_count,follow_count&access_token=EAALXSwjSbgsBALZBu8mrN1efTvFpFwOwH1ZAZAmaNCLArn6tjjjWj8BnWJS6goazL3lyy13TIwPZBbwaN18AgOPCYZC46GXGOXGcpZCMgOCoEukIjtnRspuZBKn5cjKUb858L7jMmKtP6WtgxtVpGGIGbcvPEVEGSGzJ2ZClx5jOXTjaNRqIZAl5h
    public static final String VERSION = "/v10.0/";
    public static final String ROOT_URL = " https:/" + "/graph.facebook.com" + VERSION;
    public static final String ACCESS_TOKEN = "EAALXSwjSbgsBALZBu8mrN1efTvFpFwOwH1ZAZAmaNCLArn6tjjjWj8BnWJS6goazL3lyy13TIwPZBbwaN18AgOPCYZC46GXGOXGcpZCMgOCoEukIjtnRspuZBKn5cjKUb858L7jMmKtP6WtgxtVpGGIGbcvPEVEGSGzJ2ZClx5jOXTjaNRqIZAl5h";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String KEY_GET_INFORMATION_USER = "3699418160154380?fields=id,username,profile_pic,media_count,follow_count";
    public static final String URL_GET_RESENT_MEDIA_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}
